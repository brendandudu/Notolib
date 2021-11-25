package org.miage.camel.gateways;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.miage.dto.CallForFunds;

import javax.inject.Inject;
import java.io.IOException;

public class CallForFundsImpl implements CallForFundsGateway{

    @Inject
    CamelContext context;

    @Override
    public void sendCallForFunds(float amount, String rib, String reason) {
        try (ProducerTemplate producer = context.createProducerTemplate()) {
            producer.sendBody("direct:CFD", new CallForFunds(amount, rib, reason));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
