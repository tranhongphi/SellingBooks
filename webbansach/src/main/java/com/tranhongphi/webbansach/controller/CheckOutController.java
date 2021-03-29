package com.tranhongphi.webbansach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckOutController {
    @GetMapping("/CheckOut")
    public String GetCheckOut() {
        return "CheckOut";
    }
}
