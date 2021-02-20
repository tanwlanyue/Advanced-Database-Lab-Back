package cn.edu.ustc.travel;

import cn.edu.ustc.travel.model.Flight;
import cn.edu.ustc.travel.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TravelApplicationTests {
    @Autowired
    CarService carService;
    @Autowired
    CustomerService customerService;
    @Autowired
    FlightService flightService;
    @Autowired
    HotelService hotelService;
    @Autowired
    ReservationService reservationService;

    @Test
    void contextLoads() {
        Flight flight = new Flight();
        flight.setNumAvail(10);
        flight.setNumSeats(10);
        flight.setFromCity("上海");
        flight.setArivCity("北京");
        flight.setPrice(500);
        flight.setFlightNum("C10222");
        flightService.save(flight);
    }

}
