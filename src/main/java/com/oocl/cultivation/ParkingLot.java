package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<CarTicket, Car> ticketCarMap;
    private final int maxCapacity;

    public ParkingLot() {
        ticketCarMap = new HashMap<>();
        maxCapacity = 10;
    }

    public CarTicket park(Car car) {
        if (ticketCarMap.size() < maxCapacity) {
            CarTicket carTicket = new CarTicket();
            ticketCarMap.put(carTicket, car);
            return carTicket;
        }
        return null;
    }

    public Car fetch(CarTicket carTicket) {
        return ticketCarMap.remove(carTicket);
    }

    public boolean isRightTicket(CarTicket carTicket) {
        return ticketCarMap.get(carTicket) != null;
    }

    public Map<CarTicket, Car> getTicketCarMap() {
        return ticketCarMap;
    }
}
