package ru.cbrg.router;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.RouteDefinition;
import org.springframework.stereotype.Component;


@Component
public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure(){
        RouteDefinition routeDef = from("kafka:bus_internal")
                .routeId("Internal router")
                .log(LoggingLevel.INFO,"Message from ${headers[from]} to ${headers[to]}");

        for (Addressee addressee : Addressee.ALL_ADDRESSEE) {
            AdresseeResolver adresseeResolver = AdresseeResolverImpl.of(addressee);
            routeDef.choice().when(adresseeResolver::whenCond)
                    .to("kafka:" + adresseeResolver.to().getTopic());
        }
    }
}
