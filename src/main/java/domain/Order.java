package domain;

import lombok.Data;

@Data
public class Order {

    public Order(Event event) {
        this.event = event;
    }

    private String orderId;

    private String address;

    private Event event;

    private Status status;
}
