package com.tranhongphi.webbansach.service;

import com.tranhongphi.webbansach.model.DanhMuc;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DanhMucService {
    List<DanhMuc> getAllDanhMuc();
}
