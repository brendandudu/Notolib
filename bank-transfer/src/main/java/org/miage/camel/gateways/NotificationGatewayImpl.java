package org.miage.camel.gateways;

import dto.Booking;
import dto.NotificationDTO;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;

@ApplicationScoped
public class NotificationGatewayImpl implements NotificationGateway{

    @Inject
    CamelContext context;


    @Override
    public void sendNotification(NotificationDTO notificationDTO) {
        try (ProducerTemplate producer = context.createProducerTemplate()) {
            producer.sendBody("direct:notification", notificationDTO );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
