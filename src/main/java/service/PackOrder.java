package service;

import domain.Event;
import domain.Order;
import domain.Status;

public class PackOrder implements IRule<Order, Order> {
    @Override
    public boolean matches(Order input) {
        return input.getEvent().equals(Event.PACK);
    }

    @Override
    public Order process(Order input) {
        System.out.println("Order packed");
        input.setStatus(Status.PACKED);
        return input;
    }
}
