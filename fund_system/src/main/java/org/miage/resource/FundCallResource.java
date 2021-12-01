package org.miage.resource;

import org.miage.dto.FundCallDetailsDTO;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/fund/call")
public class FundCallResource {


    @POST
    @Path("/createFundCall")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces
    @Transactional
    public void createFundCall(FundCallDetailsDTO f) throws Exception {
        System.out.println(f.toString());
    }


}