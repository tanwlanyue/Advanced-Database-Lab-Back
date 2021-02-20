package cn.edu.ustc.travel.dao;

import cn.edu.ustc.travel.model.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerDao extends BaseMapper<Customer> {
}
