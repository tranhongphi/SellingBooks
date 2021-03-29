package com.tranhongphi.webbansach.service;

import com.tranhongphi.webbansach.model.SanPham;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
    List<SanPham> getAllProductByDanhMuc(int danhMuc);
    SanPham getProductById(String id);
}
