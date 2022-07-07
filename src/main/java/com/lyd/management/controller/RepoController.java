package com.lyd.management.controller;

import com.lyd.management.model.RmRepository;
import com.lyd.management.service.impl.RepoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller//表示当前这个java类是属于控制层的 作用：把UserController这个类创建对象，并且注入到这个spring容器中，供程序使用
@ResponseBody//所有发送到这个类的请求，相应的方式都是以响应体回传
@RequestMapping(value = "Repository")//映射请求的低地址就写在这里
public class RepoController {
    //注入对象给到当前类
    @Autowired//把注解下面的对象注入到对象中
    RepoServiceImpl repoServiceImpl;
    //定义一个方法来处理一个请求
    @GetMapping(value = "/list")//这个注解可以映射到get请求方式
    public List<RmRepository> repoList(){
        //调用service层的方法来处理请求逻辑
        List<RmRepository> repositoryList = repoServiceImpl.getRepositoryList();
        return repositoryList;
    }
    @PostMapping(value = "/delete")//这个注解可以映射到get请求方式
    public Boolean deleteRepoList(String id){//如果前端传的参数类型是字符串那么可以使用相同的参数名来接受参数（eg：前端的参数名是id，那么方法中的参数名也是id）
        System.out.println(id);
        boolean result = repoServiceImpl.removerRepositoryService(Integer.parseInt(id));
        return result;
    }
    @RequestMapping(value = "/new")
    public boolean newRepo(RmRepository rmRepository){
        System.out.println(rmRepository);
        boolean result = repoServiceImpl.addRepositoryService(rmRepository);
        return result;
    }
    @RequestMapping(value = "/edit")
    public boolean editRepo(RmRepository rmRepository){
        boolean result = repoServiceImpl.editRepositoryService(rmRepository);
        return result;
    }


}
