package org.miage.ressources;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.miage.model.Account;
import org.miage.model.Client;
import org.miage.service.AccountService;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.*;

@Path("/account")
public class AccountRessource {

    @Inject
    AccountService accountService;


    @Path("/client/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Account findAccountByClientId(@PathParam("id") int client_id){
        return accountService.findAccountByClientId(client_id);
    }

    @Path("/client/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Account findRibByEmail(@PathParam("email") String email) {
        return accountService.findRibByEmail(email);
    }
}