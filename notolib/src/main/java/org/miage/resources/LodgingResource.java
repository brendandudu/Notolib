package org.miage.resources;

import org.miage.model.Lodging;
import org.miage.service.LodgingService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/lodging")
public class LodgingResource {

    @Inject
    LodgingService lodgingService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void createLodging(Lodging lodging) {
        lodgingService.createLodging(lodging);
    }

    @Path("/{lodgingId}")
    @DELETE
    @Transactional
    public void deleteLodging(@PathParam("lodgingId") int lodgingId) {
        lodgingService.deleteLodging(lodgingId);
    }

    @Path("/{lodgingId}/{acquirerId}")
    @PUT
    @Transactional
    public void setLodgingAcquirer(@PathParam("lodgingId") int lodgingId,@PathParam("acquirerId") int acquirerId) {
        lodgingService.setLodgingAcquirer(lodgingId, acquirerId);
    }

    @Path("/lodgings")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Transactional
    public Collection<Lodging> getAllLodgings() {
        return lodgingService.getAllLodgings();
    }

    @Path("/lodgings/query")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Transactional
    public Collection<Lodging> getAllLodgingsByPriceInfTo(@QueryParam("maxPrice") double maxPrice) {
        return lodgingService.getAllLodgingsByPriceInfTo(maxPrice);
    }
}
