/*package org.miage.ressources;
//import fr.pantheonsorbonne.ufr27.miage.service.TicketingService;
import org.miage.model.Account;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
@Path("ticket")
public class AccountRessource {
    @Inject
    AccountService accountService;

    @Path(("/validity"))
    @POST
    @Produces({MediaType.TEXT_PLAIN})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public boolean isAccountValid(Account t) {
        return accountService.validateAccount(t);
    }

}*/