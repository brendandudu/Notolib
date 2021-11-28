package org.miage.ressource;


import org.miage.model.Account;
import org.miage.service.BankAcquirorService;
import org.miage.service.BankAcquirorServiceImpl;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/bank/acquiror")
public class BankAcquirorRessource {

    BankAcquirorServiceImpl bankAcquirorService = new BankAcquirorServiceImpl();

    @GET
    @Path("{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account showAccount(@PathParam("email") String email, Account a) {

        return bankAcquirorService.getAccountByEmailAcquiror(email);
    }
}
