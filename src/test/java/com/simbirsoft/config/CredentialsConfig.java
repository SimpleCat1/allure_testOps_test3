package com.simbirsoft.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/testing.properties"})
public interface CredentialsConfig extends Config {
    String login();
    String password();
}
