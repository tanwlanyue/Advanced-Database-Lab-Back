package cn.edu.ustc.travel.dao;

import cn.edu.ustc.travel.model.Reservation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReservationDao extends BaseMapper<Reservation> {
}
