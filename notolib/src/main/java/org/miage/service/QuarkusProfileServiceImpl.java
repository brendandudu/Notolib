package org.miage.service;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuarkusProfileServiceImpl implements QuarkusProfileService{

    @ConfigProperty(name = "org.miage.configName")
    String configName;

    @Override
    public String getActiveQuarkusProfileConfigName() {
        return configName;
    }
}
