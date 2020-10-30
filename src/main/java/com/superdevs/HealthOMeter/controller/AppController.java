package com.superdevs.HealthOMeter.controller;

import com.superdevs.HealthOMeter.entity.User;
import com.superdevs.HealthOMeter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
    @Autowired
    UserService userService;

    @RequestMapping("/signup")
    public ModelAndView signup() {
        return new ModelAndView("registration", "user", new User());
    }

    @RequestMapping("/register")
    public ModelAndView register(User user) {
        userService.addNewUser(user);
        return new ModelAndView("redirect:login");
    }
}
