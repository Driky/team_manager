package com.gmail.driktheviking.core.jersey;

import com.gmail.driktheviking.TeamManagerApplication;
import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Named;

/**
 * Configures Jersey for use with Spring Boot.
 */
@Named
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages(TeamManagerApplication.class.getPackage().toString());
    }
}
