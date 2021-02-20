package cn.edu.ustc.travel.controller;

import cn.edu.ustc.travel.common.PageUtils;
import cn.edu.ustc.travel.common.Result;
import cn.edu.ustc.travel.model.Customer;
import cn.edu.ustc.travel.model.vo.CustomerQuery;
import cn.edu.ustc.travel.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/insert")
    public Result insertCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
        return Result.ok();
    }

    @PostMapping("/update")
    public Result updateCustomer(@RequestBody Customer customer) {
        customerService.updateById(customer);
        return Result.ok();
    }

    @RequestMapping("/list/{page}/{limit}")
    public Result list(@PathVariable long page, @PathVariable long limit,@RequestBody(required = false) CustomerQuery customerQuery){
        List<Customer> list = customerService.list();
        PageUtils pageUtils = customerService.queryPage(page,limit,customerQuery);
        return Result.ok().put("rows", pageUtils.getList()).put("total",pageUtils.getTotalCount());
    }

    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") String id){
        Customer customer = customerService.getById(id);
        return Result.ok().put("customer", customer);
    }
}
