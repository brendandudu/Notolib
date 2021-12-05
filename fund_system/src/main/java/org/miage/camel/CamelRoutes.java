package org.miage.camel;

import dto.CallForFunds;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.miage.camel.aggregations.CallForFoundAggregationStrategy;
import org.miage.camel.aggregations.RibAggregationStrategy;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {

    @Inject
    CamelContext camelContext;

    @ConfigProperty(name = "org.miage.idBankAcquirer")
    String idBankAcquirer;

    @ConfigProperty(name = "org.miage.idBankNotary")
    String idBankNotary;

    @Inject
    CallForFoundAggregationStrategy callForFoundAggregationStrategy;

    @Inject
    RibAggregationStrategy ribAggregationStrategy;

    @Override
    public void configure() throws Exception {

        //camelContext.setTracing(true);

        from("jms:queue:BKRS/booking")
                .log("${body}")
                .split(jsonpath("$.*"), callForFoundAggregationStrategy).streaming()    //For each line of json
                .choice().when(body().contains("@"))    //If it's an email
                .multicast(ribAggregationStrategy)  // --> ask RIB from all banks
                .to("jms:queue:BKRS/" + idBankAcquirer + "/RIB?exchangePattern=InOut")
                .to("jms:queue:BKRS/" + idBankNotary + "/RIB?exchangePattern=InOut")
                .end()
                .log("RIB found : ${body}")
                .endChoice()
                .end().end()
                .log("CFF : ${body}")
                .marshal().json()
                .log("CFF : ${header.bankAcquirerRoute}")
                .toD("jms:queue:BKRS/${header.bankAcquirerRoute}/CFF")
                /*.unmarshal().json(CallForFunds.class)
                .setHeader(Exchange.FILE_NAME, constant("CFF_.txt"))
                .to("file:data/CFF")*/
                .end();

    }
}
