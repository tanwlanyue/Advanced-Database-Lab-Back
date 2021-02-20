package cn.edu.ustc.travel.controller;

import cn.edu.ustc.travel.common.PageUtils;
import cn.edu.ustc.travel.common.Result;
import cn.edu.ustc.travel.model.Hotel;
import cn.edu.ustc.travel.model.vo.HotelQuery;
import cn.edu.ustc.travel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
@CrossOrigin(origins="*")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/insert")
    public Result insertHotel(@RequestBody Hotel hotel) {
        hotelService.save(hotel);
        return Result.ok();
    }

    @PostMapping("/update")
    public Result updateHotel(@RequestBody Hotel hotel) {
        hotelService.updateById(hotel);
        return Result.ok();
    }

    @RequestMapping("/list/{page}/{limit}")
    public Result list(@PathVariable long page, @PathVariable long limit,@RequestBody(required = false) HotelQuery hotelQuery){
        List<Hotel> list = hotelService.list();
        PageUtils pageUtils = hotelService.queryPage(page,limit,hotelQuery);
        return Result.ok().put("rows", pageUtils.getList()).put("total",pageUtils.getTotalCount());
    }

    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){
        Hotel hotel = hotelService.getById(id);
        return Result.ok().put("hotel", hotel);
    }

}
