package com.laptrinhjavaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/home")
public class HomeController {
    @GetMapping
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }
}
