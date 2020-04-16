package service;

import domain.Event;
import domain.Order;
import domain.Status;

public class DeliverOrder implements IRule<Order, Order> {
    @Override
    public boolean matches(Order input) {
        return input.getEvent().equals(Event.DELIVER);
    }

    @Override
    public Order process(Order input) {
        System.out.println("Order delivered");
        input.setStatus(Status.DELIVERED);
        return null;
    }
}
