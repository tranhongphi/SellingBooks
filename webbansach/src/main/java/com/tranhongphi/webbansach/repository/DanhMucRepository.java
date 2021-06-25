package com.tranhongphi.webbansach.repository;

import com.tranhongphi.webbansach.model.DanhMuc;
import com.tranhongphi.webbansach.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanhMucRepository extends JpaRepository<DanhMuc, Integer> {
    public List<DanhMuc> findAll();
    @Query("SELECT d FROM DanhMuc d WHERE d.id_danh_muc=:id_danh_muc")
    public DanhMuc findDanhMucById_danh_muc(int id_danh_muc);
}
