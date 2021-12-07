package org.miage.ressources;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.miage.exception.AccountNotFoundException;
import org.miage.model.Account;
import org.miage.service.AccountService;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.*;

@Path("/bank")
public class AccountRessource {

    @Inject
    AccountService accountService;

    @ConfigProperty(name = "org.miage.idBank")
    String idBank;

    @Path("/account/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Account findAccountById(@PathParam("id") int id) {
        return accountService.findAccountById(id);
    }

    @Path("/account/{id}/client")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Account findAccountByClientId(@PathParam("id") int client_id) {
        return accountService.findAccountByClientId(client_id);
    }

    @Path("account/{id}/rib")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public String findRibByAccountId(@PathParam("id") int id) {
        return "RIB " + " : " + idBank + id;
    }

}
