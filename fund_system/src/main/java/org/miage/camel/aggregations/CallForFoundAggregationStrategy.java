package org.miage.camel.aggregations;

import dto.CallForFunds;
import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class CallForFoundAggregationStrategy implements AggregationStrategy {

    //Reconstruct a list of object with the splitted messages
    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

        Object newBody = newExchange.getIn().getBody();
        ArrayList<Object> list = null;
        if (oldExchange == null) {
            list = new ArrayList<Object>();
            list.add(newBody);
            newExchange.getIn().setBody(list);
            return newExchange;
        } else {
            list = oldExchange.getIn().getBody(ArrayList.class);
            list.add(newBody);

            if(list.size() == 3) {
                String bankAcquirerRoute = ((String) list.get(0)).substring(0, 5); //Substring RIB to get bank number of acquirer
                oldExchange.getIn().setHeader("bankAcquirerRoute", bankAcquirerRoute);
                oldExchange.getIn().setBody(new CallForFunds((float) list.get(2), (String) list.get(0), "change reason"));
            }
            return oldExchange;
        }
    }
}
