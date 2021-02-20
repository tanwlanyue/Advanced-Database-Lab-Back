package cn.edu.ustc.travel.service;

import cn.edu.ustc.travel.common.PageUtils;
import cn.edu.ustc.travel.model.Reservation;
import cn.edu.ustc.travel.model.vo.ReservationQuery;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ReservationService extends IService<Reservation> {
    PageUtils queryPage(long page, long limit, ReservationQuery reservationQuery);
}
