package com.tranhongphi.webbansach.service;

import com.tranhongphi.webbansach.model.DanhMuc;
import com.tranhongphi.webbansach.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DanhMucService {
    List<DanhMuc> getAllDanhMuc();
    Page<DanhMuc> pagiantionCategory(int pageNo, int pageSize);
    boolean save(DanhMuc danhMuc);
    boolean removeDanhMucById(int id);
    DanhMuc getDanhMucById(int id);
}
