package service;

import domain.Event;
import domain.Order;

public class InformWarehouse implements IRule<Order, Order> {

    @Override
    public boolean matches(Order input) {
        return input.getEvent().equals(Event.PLACE);
    }

    @Override
    public Order process(Order input) {
        System.out.println("Send message to warehouse to process");
        return input;
    }
}
