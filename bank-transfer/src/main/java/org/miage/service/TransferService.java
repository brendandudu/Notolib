package org.miage.service;

import dto.CallForFunds;
import dto.Transfer;
import org.apache.camel.Exchange;

public interface TransferService {

    Transfer emitTransferByCFF(Exchange exchange);

}
