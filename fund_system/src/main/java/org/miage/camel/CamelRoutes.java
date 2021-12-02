package org.miage.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.miage.camel.aggregations.CallForFoundAggregationStrategy;
import org.miage.camel.aggregations.RibAggregationStrategy;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {

    @Inject
    CamelContext camelContext;

    @Inject
    CallForFoundAggregationStrategy callForFoundAggregationStrategy;

    @Inject
    RibAggregationStrategy ribAggregationStrategy;

    @Override
    public void configure() throws Exception {

        //camelContext.setTracing(true);

        from("jms:queue:BKRS:booking")
                .log("${body}")
                .split(jsonpath("$.*"), callForFoundAggregationStrategy).streaming()    //For each line of json
                .choice().when(body().contains("@"))    //If it's an email --> get RIB
                .multicast(ribAggregationStrategy)
                .to("jms:queue:BKRS:FR121:RIB?exchangePattern=InOut")
                .to("jms:queue:BKRS:FR129:RIB?exchangePattern=InOut")
                .end()
                .log("RIB found : ${body}")
                .endChoice()
                .end().end()
                .log("CFF : ${body}")
                .marshal().json()
                .log("CFF : ${header.bankAcquirerRoute}");
                //.toD("jms:queue:BKRS:${header.bankAcquirerRoute}:CFF");

    }
}
