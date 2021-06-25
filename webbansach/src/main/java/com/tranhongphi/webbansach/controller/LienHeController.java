package com.tranhongphi.webbansach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LienHeController {
    @GetMapping("user/contact")
    public String lienHe() {return "user/contact";}
}
