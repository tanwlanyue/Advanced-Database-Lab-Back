package cn.edu.ustc.travel.controller;

import cn.edu.ustc.travel.common.PageUtils;
import cn.edu.ustc.travel.common.Result;
import cn.edu.ustc.travel.model.Car;
import cn.edu.ustc.travel.model.Flight;
import cn.edu.ustc.travel.model.Hotel;
import cn.edu.ustc.travel.model.Reservation;
import cn.edu.ustc.travel.model.vo.ReservationQuery;
import cn.edu.ustc.travel.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    CarService carService;
    @Autowired
    FlightService flightService;
    @Autowired
    HotelService hotelService;
    @Autowired
    CustomerService customerService;

    @PostMapping("/insert")
    public Result insertReservation(@RequestBody Reservation reservation) {
        int resvType = reservation.getResvType();
        reservation.setCustName(customerService.getById(reservation.getCustName()).getCustName());
        String id = reservation.getResvKey();
        if(resvType==1){
            Flight flight = flightService.getById(id);
            reservation.setResvKey("航班号:"+flight.getFlightNum()+" "+flight.getFromCity()+" → "+flight.getArivCity());
            flight.setNumAvail(flight.getNumAvail()-1);
            flightService.updateById(flight);
        }else if(resvType==2){
            reservation.setResvKey("出租车地区:"+carService.getById(reservation.getResvKey()).getLocation());
            Car car = carService.getById(id);
            car.setNumAvail(car.getNumAvail()-1);
            carService.updateById(car);
        }else if (resvType==3){
            reservation.setResvKey("酒店名:"+hotelService.getById(reservation.getResvKey()).getName());
            Hotel hotel = hotelService.getById(id);
            hotel.setNumAvail(hotel.getNumAvail()-1);
            hotelService.updateById(hotel);
        }
        reservationService.save(reservation);
        return Result.ok();
    }

    @PostMapping("/update")
    public Result updateReservation(@RequestBody Reservation reservation) {
        reservationService.updateById(reservation);
        return Result.ok();
    }

    @RequestMapping("/list/{page}/{limit}")
    public Result list(@PathVariable long page, @PathVariable long limit,@RequestBody(required = false) ReservationQuery reservationQuery){
        List<Reservation> list = reservationService.list();
        PageUtils pageUtils = reservationService.queryPage(page,limit,reservationQuery);
        return Result.ok().put("rows", pageUtils.getList()).put("total",pageUtils.getTotalCount());
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id){
        reservationService.removeById(id);
        return Result.ok();
    }
}
