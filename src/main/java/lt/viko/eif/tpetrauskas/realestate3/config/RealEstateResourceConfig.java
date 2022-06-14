package lt.viko.eif.tpetrauskas.realestate3.config;

import lt.viko.eif.tpetrauskas.realestate3.controller.RealEstateObjectResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * ResourceConfig provides advanced capabilities to simplify registration of JAX-RS components.
 */
@Component
public class RealEstateResourceConfig extends ResourceConfig{
    public RealEstateResourceConfig() {
        register(RealEstateObjectResource.class);
    }
}
