package org.miage.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {

    @Inject
    CamelContext camelContext;

    @Override
    public void configure() throws Exception {

        //camelContext.setTracing(true);

        from("direct:booking")
                .marshal().json()
                .to("jms:queue:BKRS:booking");


        /*from("jms:queue:BKRS_RIB_BankA?exchangePattern=InOut")
               .bean(beanTest, "returnRib")
        ;

        from("jms:queue:BKRS_RIB_BankB?exchangePattern=InOut")
                .bean(beanTest2, "returnRib")
        ;

        from("direct:FR121")
                .log("${body}");*/

    }
}
