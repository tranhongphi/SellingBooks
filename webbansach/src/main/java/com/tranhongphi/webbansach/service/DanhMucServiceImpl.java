package com.tranhongphi.webbansach.service;

import com.tranhongphi.webbansach.model.DanhMuc;
import com.tranhongphi.webbansach.model.SanPham;
import com.tranhongphi.webbansach.repository.DanhMucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhMucServiceImpl implements DanhMucService{
    @Autowired
    private DanhMucRepository danhMucRepository;
    @Override
    public List<DanhMuc> getAllDanhMuc() {
        return danhMucRepository.findAll();
    }
    @Override
    public Page<DanhMuc> pagiantionCategory(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return danhMucRepository.findAll(pageable);
    }
    @Override
    public boolean save(DanhMuc danhMuc) {
        try {
            danhMucRepository.save(danhMuc);
            return true;
        }
        catch (Exception e) {
            System.out.println("Insert fail");
            return false;
        }
    }
    @Override
    public boolean removeDanhMucById(int id) {
        try{
            danhMucRepository.deleteById(id);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
    @Override
    public  DanhMuc getDanhMucById(int id) {
        return danhMucRepository.findDanhMucById_danh_muc(id);
    }
}
