package com.example.springmvcdemo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springmvcdemo.model.User;
import com.example.springmvcdemo.service.UserService;

@Controller
@RequestMapping(value = "/user")

public class UserController {

    @Autowired
    UserService userService;

    // @ReqeustMapping也可放在method
    // @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    @GetMapping("/{id}")
    public String getUserById(@PathVariable String id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        // return值必須和html的檔名相同，
        // 如 file 的名稱為 user.html 時， return 值為 "user"
        return "user";
    }

    @GetMapping
    public String getUserByName(@RequestParam String name, Model model){
        User user = userService.getUserByName(name);
        model.addAttribute("user", user);
        return "user";
    }

}
