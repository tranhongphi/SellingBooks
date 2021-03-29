package com.tranhongphi.webbansach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriesController {
    @GetMapping("/Categories")
    public String GetCategories() {
        return "Categories";
    }
}
