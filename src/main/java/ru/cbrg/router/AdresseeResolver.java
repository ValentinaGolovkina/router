package ru.cbrg.router;

import org.apache.camel.Exchange;

public interface AdresseeResolver {

    Boolean  whenCond(Exchange exchange);
    Addressee  to();
}
