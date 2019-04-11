package com.laptrinhjavaweb.controller;

import com.laptrinhjavaweb.util.SecurityUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {
    @GetMapping("login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("admin/login");
        return modelAndView;
    }

    @GetMapping("logout")
    public RedirectView logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityUtils.getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return new RedirectView("/admin/login");
    }
}
