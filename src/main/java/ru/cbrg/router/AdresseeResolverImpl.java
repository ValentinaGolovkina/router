package ru.cbrg.router;

import org.apache.camel.Exchange;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class AdresseeResolverImpl implements AdresseeResolver {

    private final Addressee addressee;

    private AdresseeResolverImpl(Addressee addressee) {
        this.addressee = addressee;
    }

    public static AdresseeResolverImpl of(Addressee addressee) {
        return new AdresseeResolverImpl(addressee);
    }

    @Override
    public Boolean whenCond(Exchange exchange) {
        String recipient = new String((byte[]) exchange.getIn().getHeader("to"), StandardCharsets.UTF_8);
        List<String> recipients = List.of(recipient.split(" "));
        System.out.println("Список {" + recipient + "} содержит " + addressee.name() + ": " + recipients.contains(addressee.name()));
        return recipients.contains(addressee.name());
    }

    @Override
    public Addressee to() {
        System.out.println("to "+ addressee.name());
        return addressee;
    }
}
