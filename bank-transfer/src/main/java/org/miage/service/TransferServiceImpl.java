package org.miage.service;

import dto.CallForFunds;
import  dto.Transfer;
import org.apache.camel.Exchange;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TransferServiceImpl implements TransferService {
    @Override
    public Transfer emitTransferByCFF(Exchange exchange) {
        CallForFunds CFF = exchange.getIn().getBody(CallForFunds.class);
        exchange.getIn().setHeader("bankCreditorRoute", CFF.getRibCreditor().substring(0,5));
        return new Transfer(CFF.getRibCreditor(), CFF.getAmount());
    }
}