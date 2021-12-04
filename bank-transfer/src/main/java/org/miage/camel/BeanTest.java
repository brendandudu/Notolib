package org.miage.camel;

import org.apache.camel.Exchange;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.util.Objects;

@ApplicationScoped
public class BeanTest {

    public void returnRib(Exchange exchange){
        String email = exchange.getIn().getBody(String.class);

        if(email.equals("acquirer@gmail.com")) {
            exchange.getMessage().setHeader("isInMyBank", true);
            exchange.getMessage().setBody("FR121234");
            return;
        }

        exchange.getMessage().setHeader("isInMyBank", false);
    }
}
