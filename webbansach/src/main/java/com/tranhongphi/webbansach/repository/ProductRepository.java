package com.tranhongphi.webbansach.repository;

import com.tranhongphi.webbansach.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<SanPham, String> {
    public List<SanPham> findProductsByDanhMuc(int danhMuc);
    public SanPham findSanPhamByIdSanPham(String id);
}
