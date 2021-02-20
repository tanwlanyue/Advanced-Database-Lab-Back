package cn.edu.ustc.travel.service.impl;

import cn.edu.ustc.travel.common.PageUtils;
import cn.edu.ustc.travel.dao.HotelDao;
import cn.edu.ustc.travel.model.Hotel;
import cn.edu.ustc.travel.model.vo.HotelQuery;
import cn.edu.ustc.travel.service.HotelService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl extends ServiceImpl<HotelDao, Hotel> implements HotelService {
    @Override
    public PageUtils queryPage(long page, long limit, HotelQuery hotelQuery) {

        QueryWrapper<Hotel>  queryWrapper= new QueryWrapper<>();
        if(hotelQuery!=null){
            String name = hotelQuery.getName();
            String location = hotelQuery.getLocation();
            if(!StringUtils.isEmpty(name)){
                queryWrapper.eq("name",name);
            }
            if(!StringUtils.isEmpty(location)){
                queryWrapper.eq("location",location);
            }
            // ge >= le<=
        }
        Page<Hotel> pageParam = new Page<Hotel>(page, limit);
        IPage<Hotel> iPage = this.page(pageParam, queryWrapper);
        return new PageUtils(iPage);
    }
}
