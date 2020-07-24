package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {

    @Test
    void should_given_cars_when_park_cars_then_return_tickets() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();

        for(int i = 0; i < 10; i++){
            //given
            Car car = new Car();

            //when
            CarTicket carTicket = parkingBoy.parkCar(car);

            //then
            assertNotNull(carTicket);
        }
    }

    @Test
    void should_given_tickets_when_fetch_cars_then_return_right_car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        List<Car> carList = new ArrayList<>();
        List<CarTicket> carTicketList = new ArrayList<>();
        List<Car> fetchedCarList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            //given
            carList.add(new Car());
            carTicketList.add(parkingBoy.parkCar(carList.get(i)));
        }

        //when
        for(int i = 0; i < 10; i++){
            fetchedCarList.add(parkingBoy.fetchCar(carTicketList.get(i)));
        }

        //then
        for(int i = 0; i < 10; i++){
            assertNotNull(fetchedCarList.get(i));
            assertEquals(carList.get(i),fetchedCarList.get(i));
        }
    }

    @Test
    void should_given_wrong_ticket_when_fetch_cars_then_return_no_car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        CarTicket carTicket = parkingBoy.parkCar(car);
        CarTicket wrongTicket = new CarTicket();

        //when
        Car fetchedCar = parkingBoy.fetchCar(wrongTicket);

        //then
        assertNull(fetchedCar);
    }

    @Test
    void should_given_no_ticket_when_fetch_cars_then_return_no_car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        CarTicket carTicket = parkingBoy.parkCar(car);
        CarTicket wrongTicket = null;

        //when
        Car fetchedCar = parkingBoy.fetchCar(wrongTicket);

        //then
        assertNull(fetchedCar);
    }

}
