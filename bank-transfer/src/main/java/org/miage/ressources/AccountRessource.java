package org.miage.ressources;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.miage.model.Account;
import org.miage.service.AccountService;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.*;

@Path("/account")
public class AccountRessource {

    @Inject
    AccountService accountService;

    @ConfigProperty(name = "org.miage.idBank")
    String idBank;

    @Path("/client/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Account findAccountByClientId(@PathParam("id") int client_id) {
        return accountService.findAccountByClientId(client_id);
    }

    @Path("/rib/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public String findRibByAccountId(@PathParam("id") int id) {
        return idBank + id;
    }

    @Path("/client/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public String findRibByEmail(@PathParam("email") String email) {
        return accountService.findRibByEmail(email);
    }
}
