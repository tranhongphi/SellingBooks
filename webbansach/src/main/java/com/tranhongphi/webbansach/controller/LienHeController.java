package com.tranhongphi.webbansach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LienHeController {
    @GetMapping("/contact")
    public String lienHe() {return "contact";}
}
