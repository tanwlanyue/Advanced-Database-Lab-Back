package cn.edu.ustc.travel.controller;

import cn.edu.ustc.travel.common.PageUtils;
import cn.edu.ustc.travel.common.Result;
import cn.edu.ustc.travel.model.Flight;
import cn.edu.ustc.travel.model.vo.FlightQuery;
import cn.edu.ustc.travel.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/insert")
    public Result insertFlight(@RequestBody Flight flight) {
        flightService.save(flight);
        return Result.ok();
    }

    @PostMapping("/update")
    public Result updateFlight(@RequestBody Flight flight) {
        flightService.updateById(flight);
        return Result.ok();
    }

    @PostMapping("/list/{page}/{limit}")
    public Result list(@PathVariable long page, @PathVariable long limit,@RequestBody(required = false) FlightQuery flightQuery){
        List<Flight> list = flightService.list();
        PageUtils pageUtils = flightService.queryPage(page,limit,flightQuery);
        return Result.ok().put("rows", pageUtils.getList()).put("total",pageUtils.getTotalCount());
    }

    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){
        Flight flight = flightService.getById(id);
        return Result.ok().put("flight", flight);
    }
}
