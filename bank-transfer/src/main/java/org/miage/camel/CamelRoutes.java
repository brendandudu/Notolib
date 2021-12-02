package org.miage.camel;

import dto.CallForFunds;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.miage.service.TransferService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {

    @Inject
    TransferService transferService;

    @ConfigProperty(name = "org.miage.IdBank")
    String suffix;

    @Inject
    BeanTest beanTest;

    @Inject
    BeanTest2 beanTest2;

    @Inject
    CamelContext camelContext;

    @Override
    public void configure() throws Exception {

        //camelContext.setTracing(true);

        from("jms:queue:BKRS/" + suffix + "/CFF")
                .unmarshal().json(CallForFunds.class)
                //.bean(loanService)//TODO Creer un prêt
                .bean(transferService) //TODO Creer et return un virement
                .log("${body} - ${header.bankCreditorRoute}");
                //.to("jms:queue:BKRS:bankNotaire:transfer");




        /*  //ajouter aussi dans l'autre bank
        from("jms:queue:BKRS/FR12/virement?extOut")
        .bean(virementService); ////TODO Récupère un virment et l'ajoute, use ?value =   ou un filter piper*/

        //ajouter aussi dans l'autre bank
        from("jms:queue:BKRS/" + suffix + "/RIB")
                .bean(beanTest); //TODO retourner un rib par l'email

        from("jms:queue:BKRS/FR129/RIB")
                .bean(beanTest2); //TODO retourner un rib par l'email

    }
}
