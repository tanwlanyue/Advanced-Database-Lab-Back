package cn.edu.ustc.travel.service.impl;

import cn.edu.ustc.travel.common.PageUtils;
import cn.edu.ustc.travel.dao.CustomerDao;
import cn.edu.ustc.travel.model.Customer;
import cn.edu.ustc.travel.model.vo.CustomerQuery;
import cn.edu.ustc.travel.service.CustomerService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerDao, Customer> implements CustomerService {
    @Override
    public PageUtils queryPage(long page, long limit, CustomerQuery customerQuery) {
        QueryWrapper<Customer>  queryWrapper= new QueryWrapper<>();
        if(customerQuery!=null){
            String custName = customerQuery.getCustName();
            if(!StringUtils.isEmpty(custName)){
                queryWrapper.eq("cust_name",custName);
            }
            // ge >= le<=
        }
        Page<Customer> pageParam = new Page<Customer>(page, limit);
        IPage<Customer> iPage = this.page(pageParam, queryWrapper);
        return new PageUtils(iPage);
    }
}
