package com.laptrinhjavaweb.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin")
public class HomeController {
    @GetMapping("home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("admin/home");
        return modelAndView;
    }

    @GetMapping("denied")
    public RedirectView denied() {
        return new RedirectView("/admin/home");
    }
}
