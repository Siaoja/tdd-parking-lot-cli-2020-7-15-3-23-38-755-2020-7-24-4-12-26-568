package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {

    @Test
    void should_given_cars_when_park_cars_then_return_tickets() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();

        for (int i = 0; i < 10; i++) {
            //given
            Car car = new Car();

            //when
            CarTicket carTicket = parkingBoy.parkCar(car).getCarTicket();

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
        for (int i = 0; i < 10; i++) {
            //given
            carList.add(new Car());
            carTicketList.add(parkingBoy.parkCar(carList.get(i)).getCarTicket());
        }

        //when
        for (int i = 0; i < 10; i++) {
            fetchedCarList.add(parkingBoy.fetchCar(carTicketList.get(i)).getCar());
        }

        //then
        for (int i = 0; i < 10; i++) {
            assertNotNull(fetchedCarList.get(i));
            assertEquals(carList.get(i), fetchedCarList.get(i));
        }
    }

    @Test
    void should_given_wrong_ticket_when_fetch_cars_then_return_no_car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        parkingBoy.parkCar(car);
        CarTicket wrongTicket = new CarTicket();

        //when
        Car fetchedCar = parkingBoy.fetchCar(wrongTicket).getCar();

        //then
        assertNull(fetchedCar);
    }

    @Test
    void should_given_no_ticket_when_fetch_cars_then_return_no_car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        parkingBoy.parkCar(car);
        CarTicket wrongTicket = null;

        //when
        Car fetchedCar = parkingBoy.fetchCar(wrongTicket).getCar();

        //then
        assertNull(fetchedCar);
    }

    @Test
    void should_given_used_ticket_when_fetch_cars_then_return_no_car() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        CarTicket carTicket = parkingBoy.parkCar(car).getCarTicket();
        parkingBoy.fetchCar(carTicket);

        //when
        Car fetchedCar = parkingBoy.fetchCar(carTicket).getCar();

        //then
        assertNull(fetchedCar);
    }


    @Test
    void should_given_wrong_ticket_when_fetch_car_then_return_correspond_message() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        parkingBoy.parkCar(car);
        CarTicket wrongTicket = new CarTicket();

        //when
        FetchCarInfo fetchCarInfo = parkingBoy.fetchCar(wrongTicket);
        Car fetchedCar = fetchCarInfo.getCar();
        String message = fetchCarInfo.getTicketMessage();

        //then
        assertNull(fetchedCar);
        assertEquals("Unrecognized parking ticket.",message);
    }

    @Test
    void should_given_used_ticket_when_fetch_car_then_return_correspond_message() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        CarTicket carTicket = parkingBoy.parkCar(car).getCarTicket();
        parkingBoy.fetchCar(carTicket);

        //when
        FetchCarInfo fetchCarInfo = parkingBoy.fetchCar(carTicket);
        Car fetchedCar = fetchCarInfo.getCar();
        String message = fetchCarInfo.getTicketMessage();

        //then
        assertNull(fetchedCar);
        assertEquals("Unrecognized parking ticket.",message);
    }

    @Test
    void should_given_no_ticket_when_fetch_car_then_return_correspond_message() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        parkingBoy.parkCar(car);

        //when
        FetchCarInfo fetchCarInfo = parkingBoy.fetchCar(null);
        Car fetchedCar = fetchCarInfo.getCar();
        String message = fetchCarInfo.getTicketMessage();

        //then
        assertNull(fetchedCar);
        assertEquals("Please provide your parking ticket.",message);
    }

    @Test
    void should_given_11_cars_when_park_car_then_return_correspond_message(){
        //give
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            carList.add(new Car());
        }

        //when
        List<ParkCarInfo> parkCarInfo = new ArrayList<>();
        ParkingBoy parkingBoy = new ParkingBoy();
        for (int i = 0; i < 11; i++) {
            parkCarInfo.add(parkingBoy.parkCar(carList.get(i)));
        }


        //then
        assertNull(parkCarInfo.get(10).getCarTicket());
        assertEquals("Not enough position.",parkCarInfo.get(10).getParkMessage());
    }
}
