package org.miage.camel;

import org.apache.camel.Exchange;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BeanTest2 {

    public void returnRib(Exchange exchange){
        String email = exchange.getIn().getBody(String.class);

        if(email.equals("notary@gmail.com")) {
            exchange.getMessage().setHeader("isInMyBank", true);
            exchange.getMessage().setBody("FR129876");
            return;
        }

        exchange.getMessage().setHeader("isInMyBank", false);
    }
}
