package service;

import domain.Event;
import domain.Order;

public class InformLogistics implements IRule<Order, Order> {

    @Override
    public boolean matches(Order input) {
        return input.getEvent().equals(Event.PACK);
    }

    @Override
    public Order process(Order input) {
        System.out.println("Send message to inform logistics to process the shipment");
        return input;
    }
}
