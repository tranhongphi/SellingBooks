package com.tranhongphi.webbansach.service;

import com.tranhongphi.webbansach.model.DanhMuc;
import com.tranhongphi.webbansach.repository.DanhMucRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
