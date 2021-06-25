package com.tranhongphi.webbansach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriesController {
    @GetMapping("/user/Categories")
    public String GetCategories() {
        return "user/Categories";
    }
}
