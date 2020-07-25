package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;
import sun.security.krb5.internal.Ticket;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    void should_given_car_when_park_car_then_return_ticket() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();


        //when
        CarTicket carTicket = parkingLot.park(car);

        //then
        assertNotNull(carTicket);

    }

    @Test
    void should_given_ticket_when_fetch_car_then_return_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        CarTicket carTicket = parkingLot.park(car);

        //when
        Car fetchedCar = parkingLot.fetch(carTicket);

        //then
        assertNotNull(car);
        assertEquals(car, fetchedCar);

    }

    @Test
    void should_given_11_cars_when_call_park_then_return_10_tickets() {
        //give
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            carList.add(new Car());
        }

        //when
        ParkingLot parkingLot = new ParkingLot();
        List<CarTicket> carTicketList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            carTicketList.add(parkingLot.park(carList.get(i)));
        }


        //then
        for (int i = 0; i < 11; i++) {
            if (i != 10)
                assertNotNull(carTicketList.get(i));
            else {
                assertNull(carTicketList.get(i));
            }
        }

    }
}
