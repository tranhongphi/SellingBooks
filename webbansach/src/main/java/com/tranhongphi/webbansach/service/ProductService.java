package com.tranhongphi.webbansach.service;

import com.tranhongphi.webbansach.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
    List<SanPham> getAllProductByDanhMuc(int danhMuc);
    SanPham getProductById(String id);
    List<SanPham> getAllProduct();
    List<SanPham> findAll();
    boolean save(SanPham sanPham);
    boolean removeProductById(String id);
    Page<SanPham> pagiantion(int pageNo, int pageSize);
    public List<SanPham> findSanPham(String keyword);
}
