package com.tranhongphi.webbansach.controller;

import com.tranhongphi.webbansach.model.DanhMuc;
import com.tranhongphi.webbansach.model.SanPham;
import com.tranhongphi.webbansach.model.User;
import com.tranhongphi.webbansach.service.DanhMucService;
import com.tranhongphi.webbansach.service.ProductService;
import com.tranhongphi.webbansach.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminTableController {
    @Autowired
    private ProductService productService;
    @Autowired
    private DanhMucService danhMucService;
    @Autowired
    private UserService userService;

    //    @GetMapping("/admin/tables-product")
//    public String GetTableProduct(Model model) {
//        List<SanPham> productList = productService.findAll();
//        model.addAttribute("listProductAdmin", productList);
//        return "admin/tables-product";
//    }
    /// Table Product
    @GetMapping("/admin/remove-product/{id}")
    public String RemoveProduct(@PathVariable(name = "id") String id, Model model, HttpSession session) {
        if (productService.removeProductById(id)) {
            model.addAttribute("statusRemove", "Delete successful");
        } else {
            model.addAttribute("statusRemove", "Delete fail");
        }
        return "redirect:/admin/tables-product/page/1";
    }

    @GetMapping("/admin/edit-product/{id}")
    public String GetEditProduct(@PathVariable(name = "id") String id, Model model, HttpSession session) {
        SanPham sanPham = productService.getProductById(id);
        model.addAttribute("productEdit", sanPham);
        return "admin/edit-product";
    }

    @GetMapping("/admin/tables-product/page/{pageNo}")
    public String pagination(@PathVariable(name = "pageNo") int pageNo, @Param("keyword") String keyword, Model model) {
        int pageSize = 5;
        Page<SanPham> page = productService.pagiantion(pageNo, pageSize);
        List<SanPham> sanPhamList = page.getContent();
        model.addAttribute("listProductAdmin", sanPhamList);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        return "admin/tables-product";
    }

    //Table Category
    @GetMapping("/admin/remove-category/{id}")
    public String RemoveCategory(@PathVariable(name = "id") String id, Model model, HttpSession session) {
        if (danhMucService.removeDanhMucById(Integer.valueOf(id))) {
            model.addAttribute("statusRemoveCategory", "Delete successful");
        } else {
            model.addAttribute("statusRemoveCategory", "Delete fail");
        }
        return "redirect:/admin/tables-category/page/1";
    }

    @GetMapping("/admin/edit-category/{id}")
    public String GetEditCategory(@PathVariable(name = "id") String id, Model model, HttpSession session) {
        DanhMuc danhMuc = danhMucService.getDanhMucById(Integer.valueOf(id));
        model.addAttribute("productEditCategory", danhMuc);
        return "admin/edit-category";
    }

    @GetMapping("/admin/tables-category/page/{pageNo}")
    public String paginationCategory(@PathVariable(name = "pageNo") int pageNo, @Param("keyword") String keyword, Model model) {
        int pageSize = 5;
        Page<DanhMuc> page = danhMucService.pagiantionCategory(pageNo, pageSize);
        List<DanhMuc> danhMucList = page.getContent();
        model.addAttribute("listCategoryAdmin", danhMucList);
        model.addAttribute("currentPageCategory", pageNo);
        model.addAttribute("totalPagesCategory", page.getTotalPages());
        model.addAttribute("totalItemsCategory", page.getTotalElements());
        return "admin/tables-category";
    }

    // Table User
    @GetMapping("/admin/tables-user/page/{pageNo}")
    public String paginationUser(@PathVariable(name = "pageNo") int pageNo, @Param("keyword") String keyword, Model model) {
        int pageSize = 5;
        Page<User> page = userService.pagiantionUser(pageNo, pageSize);
        List<User> userList = page.getContent();
        model.addAttribute("listUserAdmin", userList);
        model.addAttribute("currentPageUser", pageNo);
        model.addAttribute("totalPagesUser", page.getTotalPages());
        model.addAttribute("totalItemsUser", page.getTotalElements());
        return "admin/tables-user";
    }
}
