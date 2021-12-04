package org.miage.camel.gateways;

public interface BookingGateway {

    void sendBooking(String acquirerEmail, String notaryEmail, float amount);
}
