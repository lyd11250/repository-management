package com.lyd.management.controller;

import com.lyd.management.model.Good;
import com.lyd.management.service.impl.GoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller  //表示当前这个java类是属于控制层的。作用：把UserController这个类创建对象，并且注入到spring容器当中，供程序使用
@ResponseBody  //所有发生到这个类的请求，响应的方式都是以响应体回传
@RequestMapping(value="good") // 映射请求的地址就写在这里
public class GoodController {
    //注入对象给到当前类
    @Autowired
    GoodServiceImpl goodService;
    //定义一个方法来处理一个请求

    @GetMapping(value="/list")//这个注解可以映射到get请求方式
    public List<Good> goodList(){
        //调用service层的方法来处理请求逻辑
        //UserServiceImpl userService= new UserServiceImpl();
        return goodService.selectAllService();
    }

    @RequestMapping(value = "/select")
    public Good selectById(int id) {
        return goodService.selectByIdService(id);
    }

    @PostMapping(value = "/delete")
    public boolean deleteById(int id) {
        return goodService.deleteByIdService(id);
    }

    @RequestMapping(value = "/add")
    public boolean addGood(Good good) {
        return goodService.addGoodService(good);
    }

    @RequestMapping(value = "/edit")
    public boolean editGood(Good good) {
        return goodService.editGoodService(good);
    }

}