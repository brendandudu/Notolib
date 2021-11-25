package org.miage.camel.gateways;

public interface CallForFundsGateway {

    void sendCallForFunds(float amount, String rib, String reason);
}
