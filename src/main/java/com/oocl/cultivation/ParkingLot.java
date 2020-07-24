package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    Map<CarTicket, Car> ticketCarMap;

    public ParkingLot(){
        ticketCarMap = new HashMap<>();
    }

    public CarTicket park(Car car) {
        CarTicket carTicket = new CarTicket();
        ticketCarMap.put(carTicket,car);
        return carTicket;
    }

    public Car fetch(CarTicket carTicket) {
        return ticketCarMap.remove(carTicket);
    }

    public boolean isRightTicket(CarTicket carTicket){
        if(ticketCarMap.get(carTicket) == null)
            return false;
        return true;
    }
}
