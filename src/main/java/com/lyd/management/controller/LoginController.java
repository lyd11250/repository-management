package com.lyd.management.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import com.lyd.management.model.Employee;
import com.lyd.management.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;

/**
 * @author wr1sw
 * @version 1.0.0
 * @description
 */
@Controller
public class LoginController {
    @Resource
    private EmployeeService employeeService;

    @PostMapping("/doLogin")
    public String doLogin(String username, String password, Model model, HttpSession httpSession, String code) {
        String code1 = httpSession.getAttribute("code").toString();
        if (code1.equals(code)){
            Employee employee = employeeService.doLogin(username, password);
            //  查询到的用户不存在
            if (employee == null) {
                model.addAttribute("error", "用户名或密码错误");
                return "/login";
            }else {
                httpSession.setAttribute("currentUser",employee);
                System.out.println("success");
                return "/index";
            }
        }else {
            model.addAttribute("error", "验证码错误");
            System.out.println("验证码错误");
            return "/login";
        }
    }

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/login")
    public String login1() {
        return "login";
    }
    @RequestMapping("/getCode")
    public void getCode(HttpServletResponse response, HttpSession session) throws IOException {
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 100, 4, 4);
        captcha.setBackground(new Color(255, 48, 200));
        session.setAttribute("code",captcha.getCode());
        System.out.println("captcha.getCode() = " + captcha.getCode());
        captcha.write(response.getOutputStream());
        response.setContentType("image/png");//告诉浏览器输出内容为图片
        response.setHeader("Pragma","No-cache");//禁止浏览器缓存
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expire",0);
    }

    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();//清空session
        return "redirect:/login";
    }



}
