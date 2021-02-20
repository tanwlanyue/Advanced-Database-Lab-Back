package cn.edu.ustc.travel.controller;

import cn.edu.ustc.travel.common.Result;
import cn.edu.ustc.travel.common.SimpleResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public SimpleResult login(){
        return new SimpleResult(20000,"admin-token");
    }

    @GetMapping("/info")
    public Result info(){
        return Result.ok().put("roles", Arrays.asList("admin")).put("introduction","I am a super administrator")
        .put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif").put("name","Super Admin");
    }

    @PostMapping("/logout")
    public SimpleResult logout(){
        return new SimpleResult(20000,"success");
    }
}
