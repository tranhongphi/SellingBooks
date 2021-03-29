package com.tranhongphi.webbansach.service;

import com.tranhongphi.webbansach.model.SanPham;
import com.tranhongphi.webbansach.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<SanPham> getAllProductByDanhMuc(int danhMuc) {
        return productRepository.findProductsByDanhMuc(danhMuc);
    }

    @Override
    public SanPham getProductById(String id) {
        return productRepository.findSanPhamByIdSanPham(id);
    }
}
