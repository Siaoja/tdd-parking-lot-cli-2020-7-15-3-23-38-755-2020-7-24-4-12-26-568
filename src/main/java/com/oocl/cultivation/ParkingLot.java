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
    public ParkingLot(int maxCapacity) {
        ticketCarMap = new HashMap<>();
        this.maxCapacity = maxCapacity;
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

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public boolean isFull(){
        return ticketCarMap.size() >= maxCapacity;
    }

    public int calculateRemainingCapacity(){
        return maxCapacity - ticketCarMap.size();
    }

    public double calculateAvaliableRate(){
        return 1.0 - (double)ticketCarMap.size()/(double)maxCapacity;
    }
}
