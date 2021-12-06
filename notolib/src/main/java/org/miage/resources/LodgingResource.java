package org.miage.resources;

import org.miage.model.Lodging;
import org.miage.service.LodgingService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/lodging")
public class LodgingResource {

    @Inject
    LodgingService lodgingService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createLodging(Lodging lodging) {
        lodgingService.createLodging(lodging);
        return Response.status(200)
                .entity("Lodging successfully created").build();
    }

    @Path("/{lodgingId}")
    @DELETE
    @Transactional
    public Response deleteLodging(@PathParam("lodgingId") int lodgingId) {
        lodgingService.deleteLodging(lodgingId);
        return Response.status(200)
                .entity("Lodging successfully deleted").build();
    }

    @Path("/{lodgingId}/{acquirerId}")
    @PUT
    @Transactional
    public Response setLodgingAcquirer(@PathParam("lodgingId") int lodgingId,@PathParam("acquirerId") int acquirerId) {
        lodgingService.setLodgingAcquirer(lodgingId, acquirerId);
        return Response.status(200)
                .entity("Lodging acquirer successfully updated").build();
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
