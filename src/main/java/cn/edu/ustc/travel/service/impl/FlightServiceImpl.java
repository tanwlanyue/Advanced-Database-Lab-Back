package cn.edu.ustc.travel.service.impl;

import cn.edu.ustc.travel.common.PageUtils;
import cn.edu.ustc.travel.dao.FlightDao;
import cn.edu.ustc.travel.model.Flight;
import cn.edu.ustc.travel.model.vo.FlightQuery;
import cn.edu.ustc.travel.service.FlightService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl extends ServiceImpl<FlightDao, Flight> implements FlightService {

    @Override
    public PageUtils queryPage(long page, long limit, FlightQuery flightQuery) {
        QueryWrapper<Flight>  queryWrapper= new QueryWrapper<>();
        if(flightQuery!=null){
            String fromCity = flightQuery.getFromCity();
            String arivCity = flightQuery.getArivCity();
            if(!StringUtils.isEmpty(fromCity)){
                queryWrapper.eq("from_city",fromCity);
            }
            if(!StringUtils.isEmpty(arivCity)){
                queryWrapper.eq("ariv_city",arivCity);
            }
            // ge >= le<=
        }
        Page<Flight> pageParam = new Page<Flight>(page, limit);
        IPage<Flight> iPage = this.page(pageParam, queryWrapper);
        return new PageUtils(iPage);
    }
}
