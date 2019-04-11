package com.laptrinhjavaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/admin/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("admin/home");
        return modelAndView;
    }

    @GetMapping("/auth/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("admin/login");
        return modelAndView;
    }
}
