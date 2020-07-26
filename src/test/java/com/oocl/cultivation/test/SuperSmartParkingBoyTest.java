package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SuperSmartParkingBoyTest {

    List<ParkingLot> parkingLots;
    SuperSmartParkingBoy superSmartParkingBoy;

    @BeforeEach
    void init() {
        parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot());
        superSmartParkingBoy =new SuperSmartParkingBoy(parkingLots);
    }

    @Test
    void should_given_11_cars_2_different_parkinglot_when_park_then_parkinglot1_1_car_parkinglot2_10_cars() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(10));
        parkingLots.add(new ParkingLot(100));
        SuperSmartParkingBoy supersuperSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        //when

        for(int i = 0; i < 11; i++){
            supersuperSmartParkingBoy.parkCar(new Car());
        }

        //then
        assertEquals(1,supersuperSmartParkingBoy.getParkingLots().get(0).getTicketCarMap().size());
        assertEquals(10,supersuperSmartParkingBoy.getParkingLots().get(1).getTicketCarMap().size());
    }

    @Test
    void should_given_cars_when_park_cars_then_return_tickets() {
        //given
        for (int i = 0; i < 10; i++) {
            //given
            Car car = new Car();

            //when
            CarTicket carTicket = superSmartParkingBoy.parkCar(car).getCarTicket();

            //then
            assertNotNull(carTicket);
        }
    }

    @Test
    void should_given_tickets_when_fetch_cars_then_return_right_car() {
        //given
        List<Car> carList = new ArrayList<>();
        List<CarTicket> carTicketList = new ArrayList<>();
        List<Car> fetchedCarList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            //given
            carList.add(new Car());
            carTicketList.add(superSmartParkingBoy.parkCar(carList.get(i)).getCarTicket());
        }

        //when
        for (int i = 0; i < 10; i++) {
            fetchedCarList.add(superSmartParkingBoy.fetchCar(carTicketList.get(i)).getCar());
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
        Car car = new Car();
        superSmartParkingBoy.parkCar(car);
        CarTicket wrongTicket = new CarTicket();

        //when
        Car fetchedCar = superSmartParkingBoy.fetchCar(wrongTicket).getCar();

        //then
        assertNull(fetchedCar);
    }

    @Test
    void should_given_no_ticket_when_fetch_cars_then_return_no_car() {
        //given
        Car car = new Car();
        superSmartParkingBoy.parkCar(car);
        CarTicket wrongTicket = null;

        //when
        Car fetchedCar = superSmartParkingBoy.fetchCar(wrongTicket).getCar();

        //then
        assertNull(fetchedCar);
    }

    @Test
    void should_given_used_ticket_when_fetch_cars_then_return_no_car() {
        //given
        Car car = new Car();
        CarTicket carTicket = superSmartParkingBoy.parkCar(car).getCarTicket();
        superSmartParkingBoy.fetchCar(carTicket);

        //when
        Car fetchedCar = superSmartParkingBoy.fetchCar(carTicket).getCar();

        //then
        assertNull(fetchedCar);
    }


    @Test
    void should_given_wrong_ticket_when_fetch_car_then_return_correspond_message() {
        //given
        Car car = new Car();
        superSmartParkingBoy.parkCar(car);
        CarTicket wrongTicket = new CarTicket();

        //when
        FetchCarInfo fetchCarInfo = superSmartParkingBoy.fetchCar(wrongTicket);
        Car fetchedCar = fetchCarInfo.getCar();
        String message = fetchCarInfo.getTicketMessage();

        //then
        assertNull(fetchedCar);
        assertEquals("Unrecognized parking ticket.", message);
    }

    @Test
    void should_given_used_ticket_when_fetch_car_then_return_correspond_message() {
        //given
        Car car = new Car();
        CarTicket carTicket = superSmartParkingBoy.parkCar(car).getCarTicket();
        superSmartParkingBoy.fetchCar(carTicket);

        //when
        FetchCarInfo fetchCarInfo = superSmartParkingBoy.fetchCar(carTicket);
        Car fetchedCar = fetchCarInfo.getCar();
        String message = fetchCarInfo.getTicketMessage();

        //then
        assertNull(fetchedCar);
        assertEquals("Unrecognized parking ticket.", message);
    }

    @Test
    void should_given_no_ticket_when_fetch_car_then_return_correspond_message() {
        //given
        Car car = new Car();
        superSmartParkingBoy.parkCar(car);

        //when
        FetchCarInfo fetchCarInfo = superSmartParkingBoy.fetchCar(null);
        Car fetchedCar = fetchCarInfo.getCar();
        String message = fetchCarInfo.getTicketMessage();

        //then
        assertNull(fetchedCar);
        assertEquals("Please provide your parking ticket.", message);
    }

    @Test
    void should_given_11_cars_when_park_car_then_return_correspond_message() {
        //give
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            carList.add(new Car());
        }

        //when
        List<ParkCarInfo> parkCarInfo = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            parkCarInfo.add(superSmartParkingBoy.parkCar(carList.get(i)));
        }


        //then
        assertNull(parkCarInfo.get(10).getCarTicket());
        assertEquals("Not enough position.", parkCarInfo.get(10).getParkMessage());
    }
}
