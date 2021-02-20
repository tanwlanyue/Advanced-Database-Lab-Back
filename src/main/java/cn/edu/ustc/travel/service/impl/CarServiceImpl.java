package cn.edu.ustc.travel.service.impl;

import cn.edu.ustc.travel.common.PageUtils;
import cn.edu.ustc.travel.dao.CarDao;
import cn.edu.ustc.travel.model.Car;
import cn.edu.ustc.travel.model.vo.CarQuery;
import cn.edu.ustc.travel.service.CarService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends ServiceImpl<CarDao, Car> implements CarService {
    @Override
    public PageUtils queryPage(long page, long limit, CarQuery carQuery) {
        QueryWrapper<Car>  queryWrapper= new QueryWrapper<>();
        if(carQuery!=null){
            Integer type = carQuery.getType();
            String location = carQuery.getLocation();
            if(type!=0){
                queryWrapper.eq("type",type);
            }
            if(!StringUtils.isEmpty(location)){
                queryWrapper.eq("location",location);
            }
            // ge >= le<=
        }
        Page<Car> pageParam = new Page<Car>(page, limit);
        IPage<Car> iPage = this.page(pageParam, queryWrapper);
        return new PageUtils(iPage);
    }
}
