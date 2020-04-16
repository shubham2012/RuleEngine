package service;

import domain.Event;
import domain.Order;
import domain.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RuleEngineTest {

    RuleEngine engine = new RuleEngine();

    @Test
    void test_place_order() {
        Order order = new Order(Event.PLACE);
        Order placeResponse = engine.fireRules(order);
        Assertions.assertEquals(Status.CONFIRMED, placeResponse.getStatus());

        order.setEvent(Event.PACK);
        Order packResponse = engine.fireRules(order);
        Assertions.assertEquals(Status.PACKED, packResponse.getStatus());

        order.setEvent(Event.SHIP);
        Order shipResponse = engine.fireRules(order);
        Assertions.assertEquals(Status.SHIPPED, shipResponse.getStatus());

        order.setEvent(Event.DELIVER);
        Order deliverResponse = engine.fireRules(order);
        Assertions.assertEquals(Status.DELIVERED, deliverResponse.getStatus());

    }

}