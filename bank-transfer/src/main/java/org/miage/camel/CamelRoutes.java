package org.miage.camel;

import org.apache.camel.builder.RouteBuilder;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("jms:queue:BKRS/FR121/RIB?exchangePattern=InOut")
                .log()


    }

}
