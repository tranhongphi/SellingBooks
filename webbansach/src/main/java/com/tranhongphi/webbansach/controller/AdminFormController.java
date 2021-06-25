package com.tranhongphi.webbansach.controller;

import com.tranhongphi.webbansach.model.DanhMuc;
import com.tranhongphi.webbansach.model.SanPham;
import com.tranhongphi.webbansach.service.DanhMucService;
import com.tranhongphi.webbansach.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class AdminFormController {
    @Autowired
    private ProductService productService;
    @Autowired
    private DanhMucService danhMucService;
    @GetMapping("/admin/add-product")
    public String GetFormProduct() {
        return "admin/form-product";
    }
    @PostMapping("/admin/add-product")
    public String AddProduct(HttpServletRequest request, HttpSession session, Model model,@RequestParam("file")  MultipartFile file) {
        SanPham sanPham = new SanPham();

        Path path = Paths.get("upload/");
        try {
            InputStream inputStream = file.getInputStream();
            Files.copy(inputStream, path.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(!file.isEmpty()) {
            sanPham.setHinhAnh(file.getOriginalFilename().toLowerCase());
        }
        sanPham.setIdSanPham(request.getParameter("productID"));
        sanPham.setTenSanPham(request.getParameter("productName"));
        sanPham.setGiaSanPham(Integer.parseInt(request.getParameter("price")));
        sanPham.setKhuyenMai(Integer.parseInt(request.getParameter("promotionalPrice")));
        sanPham.setTacGia(request.getParameter("author"));
        sanPham.setStar(0);
        sanPham.setRateCount(0);
        sanPham.setGioiThieu(request.getParameter("introduction"));
        sanPham.setMoTa(request.getParameter("description"));
        sanPham.setDanhMuc(Integer.parseInt(request.getParameter("category")));
        if(productService.save(sanPham)) {
            model.addAttribute("messAddProduct1", "Add successful");
        }
        else {
            model.addAttribute("messAddProduct2", "Add fail");
        }
        return "admin/form-product";
    }
    @PostMapping("/admin/edit-product")
    public String EditProduct(HttpServletRequest request, HttpSession session, Model model) {
        SanPham sanPham = new SanPham();
        sanPham.setIdSanPham(request.getParameter("productID"));
        sanPham.setTenSanPham(request.getParameter("productName"));
        sanPham.setGiaSanPham(Integer.parseInt(request.getParameter("price")));
        sanPham.setKhuyenMai(Integer.parseInt(request.getParameter("promotionalPrice")));
        sanPham.setHinhAnh("fail");
        sanPham.setTacGia(request.getParameter("author"));
        sanPham.setStar(0);
        sanPham.setRateCount(0);
        sanPham.setGioiThieu(request.getParameter("introduction"));
        sanPham.setMoTa(request.getParameter("description"));
        sanPham.setDanhMuc(Integer.parseInt(request.getParameter("category")));
        if(productService.save(sanPham)) {
            model.addAttribute("messEditProduct1", "Edit successful");
        }
        else {
            model.addAttribute("messAddProduct2", "Edit fail");
        }
        return "admin/edit-product";
    }

    //

    @GetMapping("/admin/add-category")
    public String GetFormCategory() {
        return "admin/form-category";
    }
    @PostMapping("/admin/add-category")
    public String AddCategory(HttpServletRequest request, HttpSession session, Model model) {
        DanhMuc danhMuc = new DanhMuc();
        danhMuc.setId_danh_muc(Integer.parseInt(request.getParameter("categoryID")));
        danhMuc.setTen_danh_muc(request.getParameter("categoryName"));
        danhMuc.setMo_ta(request.getParameter("categoryDes"));
        danhMuc.setDanh_muc_con(Integer.parseInt(request.getParameter("categorySubCate")));
        if(danhMucService.save(danhMuc)) {
            model.addAttribute("messAddCategory1", "Add successful");
        }
        else {
            model.addAttribute("messAddCategory2", "Add fail");
        }
        return "admin/form-category";
    }
    @PostMapping("/admin/edit-category")
    public String EditCategory(HttpServletRequest request, HttpSession session, Model model) {
        DanhMuc danhMuc = new DanhMuc();
        danhMuc.setId_danh_muc(Integer.parseInt(request.getParameter("categoryID")));
        danhMuc.setTen_danh_muc(request.getParameter("categoryName"));
        danhMuc.setMo_ta(request.getParameter("categoryDes"));
        danhMuc.setDanh_muc_con(Integer.parseInt(request.getParameter("categorySubCate")));
        if(danhMucService.save(danhMuc)) {
            model.addAttribute("messEditCategory1", "Edit successful");
        }
        else {
            model.addAttribute("messEditCategory2", "Edit fail");
        }
        return "admin/edit-category";
    }
    //////////////////////

    @RequestMapping(value = "getimage/{image}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable("image") String image) {
        if (image.equals("") || image != null) {
            try {
                Path filename = Paths.get("upload", image);
                byte[] buffer = Files.readAllBytes(filename);
                ByteArrayResource arrayResource = new ByteArrayResource(buffer);
                return ResponseEntity.ok().contentLength(buffer.length)
                        .contentType(MediaType.parseMediaType("image/png")).body(arrayResource);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ResponseEntity.badRequest().build();
    }
//    @RequestMapping(value = "/personal/save", method = RequestMethod.POST)
//    public String save(@ModelAttribute(name = "sanpham") SanPham sanPham, MultipartFile file, HttpSession session) {
//
//
//
//
//        productService.save(sanPham);
//        session.setAttribute("sanpham", sanPham);
//        return "redirect:/personal";
//    }
}
