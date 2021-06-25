package com.tranhongphi.webbansach.service;

import com.tranhongphi.webbansach.model.SanPham;
import com.tranhongphi.webbansach.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Override
    public List<SanPham> getAllProduct() {
        return productRepository.findAll();
    }
    @Override
    public List<SanPham> findAll(){return productRepository.findAll();}
    @Override
    public boolean save(SanPham sanPham) {
        try {
            productRepository.save(sanPham);
            return true;
        }
        catch (Exception e) {
            System.out.println("Insert fail");
            return false;
        }
    }

    @Override
    public boolean removeProductById(String id) {
        try{
            productRepository.deleteById(id);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
    @Override
    public Page<SanPham> pagiantion(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return productRepository.findAll(pageable);
    }
    @Override
    public List<SanPham> findSanPham(String keyword) {
        return productRepository.findSanPham(keyword);
    }
}
