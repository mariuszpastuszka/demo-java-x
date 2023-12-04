#!/bin/bash
set -e

rm -rf app-cds
mkdir app-cds

if ! [ -e target/java-x.jar ]
then
	printf "Building Maven project, so JAR is available...\n"
    mvn clean package
fi

printf "\n--- RUN WITHOUT CDS ---\n\n"
time java --enable-preview \
	-jar target/java-x.jar


# Since Java 12, the JDK comes with an archive of the JDK classes
# and so it makes no sense to create a new one
#printf "\n--- RUN WITH CDS ---\n"
#printf "\n#Create archive for default JDK classes\n"
#sudo java -Xshare:dump
#printf "\n# Use default archive\n"
#time java --enable-preview -jar target/java-x.jar
#printf "\n# Non-archived classes\n"
#java --enable-preview \
#	-Xlog:class+load \
#	-jar target/java-x.jar \
#| grep -v "shared objects file"


printf "\n--- RUN WITH APPLICATION CDS ---\n"
printf "\n# Record used classes\n"
java --enable-preview \
	-XX:DumpLoadedClassList=app-cds/classes.lst \
	-jar target/java-x.jar

printf "\n# Create archive for recorded classes\n"
java --enable-preview \
	-Xshare:dump \
	-XX:SharedClassListFile=app-cds/classes.lst \
	-XX:SharedArchiveFile=app-cds/app.jsa \
	--class-path target/java-x.jar

printf "\n# Use created archive\n"
time java --enable-preview \
	-XX:SharedArchiveFile=app-cds/app.jsa \
	-jar target/java-x.jar \

printf "\n# Non-archived classes\n"
java --enable-preview \
	-XX:SharedArchiveFile=app-cds/app.jsa \
	-Xlog:class+load \
	-jar target/java-x.jar \
| grep -v "shared objects file"


printf "\n--- RUN WITH DYNAMIC APP CDS ---\n"
printf "\n# Run without CDS & create archive\n"
time java --enable-preview \
	-XX:ArchiveClassesAtExit=app-cds/dyn.jsa \
	-jar target/java-x.jar

printf "\n# Use created archive\n"
time java --enable-preview \
	-XX:SharedArchiveFile=app-cds/dyn.jsa \
	-jar target/java-x.jar

printf "\n# Non-archived classes\n"
java --enable-preview \
	-XX:SharedArchiveFile=app-cds/dyn.jsa \
	-Xlog:class+load \
	-jar target/java-x.jar \
| grep -v "shared objects file"
