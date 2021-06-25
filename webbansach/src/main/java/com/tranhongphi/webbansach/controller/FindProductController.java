package com.tranhongphi.webbansach.controller;

import com.tranhongphi.webbansach.model.SanPham;
import com.tranhongphi.webbansach.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FindProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/searchProduct")
    public String getSearchProduct(HttpServletRequest request, HttpSession session, Model model) {
        String keyword = request.getParameter("keyword");
        List<SanPham> sanPhamList = productService.findSanPham(keyword);
        model.addAttribute("sanPhamList", sanPhamList);
        return "/user/listProduct";
    }
    @GetMapping("/findProduct/{id}")
    public String getProductByDanhMuc(@PathVariable(name = "id") String id, Model model, HttpSession session) {
        List<SanPham> productList = productService.getAllProductByDanhMuc(Integer.parseInt(id));
        model.addAttribute("sanPhamList", productList);
        return "/user/listProduct";
    }
}
