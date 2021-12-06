package org.miage.resources;

import org.miage.model.Notification;
import org.miage.service.NotificationService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/notification")
public class NotificationResource {

    @Inject
    NotificationService notificationService;

    @Path("/user/{userId}/notifications")
    @PUT
    @Transactional
    public Response setAllUserNotificationsViewed(@PathParam("userId") int userId) {
        notificationService.setAllUserNotificationsViewed(userId);
        return Response.status(200)
                .entity("All user notifications marked as viewed").build();
    }

    @Path("/user/{userId}/notifications")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Transactional
    public Collection<Notification> getAllUserNotifications(@PathParam("userId") int userId) {
        return notificationService.getAllUserNotifications(userId);
    }

    @Path("/user/{userId}/notifications/new/count")
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Transactional
    public int getUserNewNotificationsCount(@PathParam("userId") int userId) {
        return notificationService.getUserNewNotificationsCount(userId);
    }
}
