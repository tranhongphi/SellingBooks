package com.tranhongphi.webbansach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GioiThieuController {
    @GetMapping("/about-us")
    public String gioiThieu() {return "about-us";}
}
