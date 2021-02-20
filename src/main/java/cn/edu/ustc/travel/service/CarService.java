package cn.edu.ustc.travel.service;

import cn.edu.ustc.travel.common.PageUtils;
import cn.edu.ustc.travel.model.Car;
import cn.edu.ustc.travel.model.vo.CarQuery;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CarService extends IService<Car> {

    PageUtils queryPage(long page, long limit, CarQuery carQuery);
}
