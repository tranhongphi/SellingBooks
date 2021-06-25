package com.tranhongphi.webbansach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    @GetMapping("/Logout")
    public String getLogout(HttpSession session) {
        session.removeAttribute("userRegister");
        return "redirect:/";
    }
}
