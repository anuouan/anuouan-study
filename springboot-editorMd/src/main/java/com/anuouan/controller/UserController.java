package com.anuouan.controller;


import com.anuouan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/getInfo")
    public String gitInfo(Model model) {
        List<User> list = Arrays.asList(new User("张三", "123456"), new User("李四", "123456"), new User("王五", "123456"));
        model.addAttribute("users", list);
        return "getInfo";
    }
}

