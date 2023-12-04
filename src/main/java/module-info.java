import com.mpas.demo.java17.api.random.Xkcd;
import com.mpas.demo.java18.api.ip_resolution.ForwardingInetAddressResolverProvider;

import java.net.spi.InetAddressResolverProvider;
import java.util.random.RandomGenerator;

/**
 * Project demonstrating various Java features introduced since Java 9.
 */
module com.mpas.demo.java_x {
	exports com.mpas.demo.java18.javadoc;

	requires java.desktop;
	requires java.net.http;
	requires jdk.incubator.vector;

	provides RandomGenerator with Xkcd;
	provides InetAddressResolverProvider with ForwardingInetAddressResolverProvider;
}
