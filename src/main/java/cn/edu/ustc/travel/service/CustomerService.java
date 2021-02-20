package cn.edu.ustc.travel.service;

import cn.edu.ustc.travel.common.PageUtils;
import cn.edu.ustc.travel.model.Customer;
import cn.edu.ustc.travel.model.vo.CustomerQuery;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CustomerService extends IService<Customer> {
    PageUtils queryPage(long page, long limit, CustomerQuery customerQuery);
}
