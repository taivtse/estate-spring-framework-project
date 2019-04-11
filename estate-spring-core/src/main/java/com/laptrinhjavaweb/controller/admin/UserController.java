package com.laptrinhjavaweb.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/user")
public class UserController {
    @GetMapping
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("admin/user/list");
        return modelAndView;
    }
}
