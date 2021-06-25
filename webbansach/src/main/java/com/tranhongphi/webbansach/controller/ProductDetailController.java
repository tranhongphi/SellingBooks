package com.tranhongphi.webbansach.controller;

import com.tranhongphi.webbansach.model.SanPham;
import com.tranhongphi.webbansach.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProductDetailController {
    @Autowired
    private ProductService productService;
    @GetMapping("/product/product-detail/{id}")
    public String GetProductDetail(@PathVariable(name = "id") String id, Model model, HttpSession session) {
        List<SanPham> productList1 = productService.getAllProductByDanhMuc(1);
        SanPham sanPham = productService.getProductById(id);
        model.addAttribute("listProduct1", productList1);
        model.addAttribute("detailProduct", sanPham);
        session.setAttribute("idProductDetail", id);
        return "user/product-detail";
    }
}
