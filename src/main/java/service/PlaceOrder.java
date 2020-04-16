package service;

import domain.Event;
import domain.Order;
import domain.Status;

public class PlaceOrder implements IRule<Order, Order> {
    @Override
    public boolean matches(Order input) {
        return input.getEvent().equals(Event.PLACE);
    }

    @Override
    public Order process(Order input) {
        System.out.println("Order placed");
        input.setStatus(Status.CONFIRMED);
        return input;
    }
}
