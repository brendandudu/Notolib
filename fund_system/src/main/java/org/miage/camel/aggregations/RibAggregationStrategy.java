package org.miage.camel.aggregations;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class RibAggregationStrategy implements AggregationStrategy {

    //Get only the isInMyBank success reply message
    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null) {
            return newExchange;
        }

        boolean oldHeader = oldExchange.getIn().getHeader("isInMyBank", Boolean.class);

        return oldHeader ? oldExchange : newExchange;

    }
}
