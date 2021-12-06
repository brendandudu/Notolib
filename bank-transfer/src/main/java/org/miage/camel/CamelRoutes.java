package org.miage.camel;

import dto.CallForFunds;
import dto.Transfer;
import org.apache.camel.CamelContext;
import org.apache.camel.CamelExecutionException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.miage.exception.ClientNotAdultException;
import org.miage.exception.LoanAlreadyExistsException;
import org.miage.service.AccountService;
import org.miage.service.TransferService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {

    @Inject
    TransferService transferService;

    @Inject
    CamelContext context;

    @ConfigProperty(name = "org.miage.idBank")
    String idBank;

    @Inject
    AccountService accountService;

    @Override
    public void configure() throws Exception {

        onException(ClientNotAdultException.class)
                .handled(true)
                .process(new ClientNotAdultProcessor())
                .log("${body}");

        onException(LoanAlreadyExistsException.class)
                .handled(true)
                .process(new LoanAlreadyExistsProcessor())
                .log("${body}");

        from("jms:queue:BKRS/" + idBank + "/CFF")
                .log("${body}")
                .unmarshal().json(CallForFunds.class)
                .bean(accountService, "depositLoanBalance")//Créer un prêt sur le compte de l'acquéreur
                .bean(transferService, "emitTransferByCFF")
                .log("${header.bankCreditorRoute}")
                .marshal().json()
                .toD("jms:queue:BKRS/${header.bankCreditorRoute}/transfer");


        from("jms:queue:BKRS/" + idBank + "/transfer")
                .log("transfer recu")
                .unmarshal().json(Transfer.class)
                .bean(accountService, "depositBalance");

        //ajouter aussi dans l'autre bank
        from("jms:queue:BKRS/" + idBank + "/RIB")
                .bean(accountService, "emitRibByEmail"); //TODO retourner un rib par l'email

        from("jms:queue:BKRS/" + idBank + "/RIB")
                .bean(accountService, "emitRibByEmail");

    }

    private static class ClientNotAdultProcessor implements Processor {
        @Override
        public void process(Exchange exchange) {
            CamelExecutionException exception = (CamelExecutionException) exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class);
            exchange.getMessage().setBody(((ClientNotAdultException) exception.getCause()).getErrorMessage());
        }
    }

    private static class LoanAlreadyExistsProcessor implements Processor {
        @Override
        public void process(Exchange exchange) {
            CamelExecutionException exception = (CamelExecutionException) exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class);
            exchange.getMessage().setBody(((ClientNotAdultException) exception.getCause()).getErrorMessage());
        }
    }

}
