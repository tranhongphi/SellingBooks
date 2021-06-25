package com.tranhongphi.webbansach.controller;

import com.tranhongphi.webbansach.model.DanhMuc;
import com.tranhongphi.webbansach.model.SanPham;
import com.tranhongphi.webbansach.service.DanhMucService;
import com.tranhongphi.webbansach.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private DanhMucService danhMucService;
    @Autowired
    private ProductService productService;
    @GetMapping("/user/index")
    public String index(Model model) {
        List<DanhMuc> danhMucList = danhMucService.getAllDanhMuc();
        List<SanPham> productList1 = productService.getAllProductByDanhMuc(1);
        List<SanPham> productList2 = productService.getAllProductByDanhMuc(2);
        List<SanPham> productList4 = productService.getAllProductByDanhMuc(4);
        model.addAttribute("listDanhMuc", danhMucList);
        model.addAttribute("listProduct1", productList1);
        model.addAttribute("listProduct2", productList2);
        model.addAttribute("listProduct4", productList4);
        return "user/index";
    }
}
