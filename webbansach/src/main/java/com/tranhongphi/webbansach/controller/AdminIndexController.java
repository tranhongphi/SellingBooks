package com.tranhongphi.webbansach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminIndexController {
    @GetMapping({"/admin/index","/admin"})
    public String GetIndexAdmin() {

        return "admin/index";
    }
}
