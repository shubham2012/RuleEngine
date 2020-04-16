package service;

import domain.Event;
import domain.Order;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Notification implements IRule<Order, Order> {

    @Override
    public boolean matches(Order input) {
        Set<Event> collect = Stream.of(Event.PLACE, Event.PACK, Event.SHIP, Event.DELIVER)
                .collect(Collectors.toSet());
        return collect.contains(input.getEvent());
    }

    @Override
    public Order process(Order input) {
        System.out.println("Notification send to customer for event : "+ input.getEvent());
        return input;
    }
}
