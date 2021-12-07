package org.miage.camel;

import dto.NotificationDTO;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.miage.service.NotificationService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {

    @Inject
    CamelContext camelContext;

    @Inject
    NotificationService notificationService;

    @Override
    public void configure() throws Exception {

        //camelContext.setTracing(true);

        from("direct:booking")
                .marshal().json()
                .to("jms:queue:BKRS/booking");

        from("jms:queue:BKRS/notolib/notification")
                .unmarshal().json(NotificationDTO.class)
                .log("${body}")
                .bean(notificationService, "createUserNotificationByDTO");
    }
}
