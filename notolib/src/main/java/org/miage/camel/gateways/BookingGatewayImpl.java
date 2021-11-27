package org.miage.camel.gateways;

import dto.Booking;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;

@ApplicationScoped
public class BookingGatewayImpl implements BookingGateway {

    @Inject
    CamelContext context;

    @Override
    public void sendBooking(String acquirerEmail, String notaryEmail, float amount) {
        try (ProducerTemplate producer = context.createProducerTemplate()) {
           producer.sendBody("direct:booking", new Booking(acquirerEmail, notaryEmail, amount));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
