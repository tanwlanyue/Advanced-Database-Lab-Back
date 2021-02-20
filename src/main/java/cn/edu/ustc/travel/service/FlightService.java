package cn.edu.ustc.travel.service;

import cn.edu.ustc.travel.common.PageUtils;
import cn.edu.ustc.travel.model.Flight;
import cn.edu.ustc.travel.model.vo.FlightQuery;
import com.baomidou.mybatisplus.extension.service.IService;

public interface FlightService extends IService<Flight> {

    PageUtils queryPage(long page, long limit, FlightQuery flightQuery);
}
