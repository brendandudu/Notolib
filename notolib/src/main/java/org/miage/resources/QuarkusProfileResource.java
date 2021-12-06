package org.miage.resources;

import org.miage.service.QuarkusProfileService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/quarkus/profile")
public class QuarkusProfileResource {

    @Inject
    QuarkusProfileService quarkusProfileService;

    @GET
    public String getActiveQuarkusProfileConfigName(){
        return quarkusProfileService.getActiveQuarkusProfileConfigName();
    }
}
