package service;

import domain.Event;
import domain.Order;
import domain.Status;

public class ShipOrder implements IRule<Order, Order>{
    @Override
    public boolean matches(Order input) {
        return input.getEvent().equals(Event.SHIP);
    }

    @Override
    public Order process(Order input) {
        System.out.println("Order shipped");
        input.setStatus(Status.SHIPPED);
        return input;
    }
}
