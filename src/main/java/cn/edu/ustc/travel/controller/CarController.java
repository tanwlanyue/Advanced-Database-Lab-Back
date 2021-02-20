package cn.edu.ustc.travel.controller;

import cn.edu.ustc.travel.common.PageUtils;
import cn.edu.ustc.travel.common.Result;
import cn.edu.ustc.travel.model.Car;
import cn.edu.ustc.travel.model.vo.CarQuery;
import cn.edu.ustc.travel.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/insert")
    public Result insertCar(@RequestBody Car car) {
        carService.save(car);
        return Result.ok();
    }

    @PostMapping("/update")
    public Result updateCar(@RequestBody Car car) {
        carService.updateById(car);
        return Result.ok();
    }

    @RequestMapping("/list/{page}/{limit}")
    public Result list(@PathVariable long page, @PathVariable long limit,@RequestBody(required = false) CarQuery carQuery){
        List<Car> list = carService.list();
        PageUtils pageUtils = carService.queryPage(page,limit,carQuery);
        return Result.ok().put("rows", pageUtils.getList()).put("total",pageUtils.getTotalCount());
    }

    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){
        Car car = carService.getById(id);
        return Result.ok().put("car", car);
    }
}
