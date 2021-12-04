package org.miage.camel;

import dto.CallForFunds;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.miage.service.AccountService;
import org.miage.service.TransferService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {

    @Inject
    TransferService transferService;

    @ConfigProperty(name = "org.miage.idBank")
    String idBank;

    @Inject
    AccountService accountService;

    @Inject
    BeanTest2 beanTest2;

    @Override
    public void configure() throws Exception {

        from("jms:queue:BKRS/" + idBank + "/CFF")
                .unmarshal().json(CallForFunds.class)
                .bean(accountService, "createLoan")//Créer un prêt sur le compte de l'acquéreur
                .bean(transferService, "emitTransferByCFF")//Créer un prêt sur le compte de l'acquéreur
                .log("${body} - ${header.bankCreditorRoute}")
                .toD("jms:queue:BKRS/${header.bankCreditorRoute}/transfer");


        /*  //ajouter aussi dans l'autre bank
        from("jms:queue:BKRS/FR12/virement?extOut")
        .bean(virementService); ////TODO Récupère un virment et l'ajoute, use ?value =   ou un filter piper*/

        //ajouter aussi dans l'autre bank
        from("jms:queue:BKRS/" + idBank + "/RIB")
                .bean(accountService, "emitRibByEmail"); //TODO retourner un rib par l'email


        from("jms:queue:BKRS/" + idBank + "/RIB")
                .bean(accountService, "emitRibByEmail"); //TODO retourner un rib par l'email

    }

}
