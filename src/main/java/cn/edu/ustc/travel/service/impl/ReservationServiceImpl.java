package cn.edu.ustc.travel.service.impl;

import cn.edu.ustc.travel.common.PageUtils;
import cn.edu.ustc.travel.dao.ReservationDao;
import cn.edu.ustc.travel.model.Reservation;
import cn.edu.ustc.travel.model.vo.ReservationQuery;
import cn.edu.ustc.travel.service.ReservationService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl extends ServiceImpl<ReservationDao, Reservation> implements ReservationService {
    @Override
    public PageUtils queryPage(long page, long limit, ReservationQuery reservationQuery) {
        QueryWrapper<Reservation>  queryWrapper= new QueryWrapper<>();
        if(reservationQuery!=null){
            String custName = reservationQuery.getCustName();
            if(!StringUtils.isEmpty(custName)){
                queryWrapper.eq("cust_name",custName);
            }
            // ge >= le<=
        }
        Page<Reservation> pageParam = new Page<Reservation>(page, limit);
        IPage<Reservation> iPage = this.page(pageParam, queryWrapper);
        return new PageUtils(iPage);
    }
}
