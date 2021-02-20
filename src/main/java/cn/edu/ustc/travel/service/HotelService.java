package cn.edu.ustc.travel.service;

import cn.edu.ustc.travel.common.PageUtils;
import cn.edu.ustc.travel.model.Hotel;
import cn.edu.ustc.travel.model.vo.HotelQuery;
import com.baomidou.mybatisplus.extension.service.IService;

public interface HotelService extends IService<Hotel> {
    PageUtils queryPage(long page, long limit, HotelQuery hotelQuery);
}
