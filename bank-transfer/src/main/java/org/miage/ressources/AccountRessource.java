package org.miage.ressources;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.miage.model.Account;
import org.miage.service.AccountService;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.*;

@Path("account")
public class AccountRessource {

    @Inject
    AccountService accountService;


    @Path("/account/{id}")
    @Produces(MediaType.APPLICATION_XML)
    @GET
    public Account findAccountById(@PathParam("id") int id){
        return accountService.findAccountById(id);
    }

    @Path("/account/{email}")
    @Produces(MediaType.APPLICATION_XML)
    @GET
    public String findRibByEmail(@PathParam("email") String email){
        return accountService.findRibByEmail(email);
    }

}