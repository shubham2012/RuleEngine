package service;

import domain.Order;

import java.util.Arrays;
import java.util.List;

public class RuleEngine {

    List<IRule> rules;

    public RuleEngine() {
        rules = Arrays.asList(new Notification(),
                new InformLogistics(),
                new InformWarehouse(),
                new DeliverOrder(),
                new PackOrder(),
                new PlaceOrder(),
                new ShipOrder()
        );
    }

    public Order fireRules(Order order) {
        rules.stream()
                .filter(rule -> rule.matches(order))
                .forEach(i -> i.process(order));
        return order;
    }
}
