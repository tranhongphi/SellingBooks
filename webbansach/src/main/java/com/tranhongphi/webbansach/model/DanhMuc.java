package com.tranhongphi.webbansach.model;

import javax.persistence.*;

@Entity
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_danh_muc;
    private String ten_danh_muc;
    private String mo_ta;
    private int danh_muc_con;

    public int getId_danh_muc() {
        return id_danh_muc;
    }

    public void setId_danh_muc(int id_danh_muc) {
        this.id_danh_muc = id_danh_muc;
    }

    public String getTen_danh_muc() {
        return ten_danh_muc;
    }

    public void setTen_danh_muc(String ten_danh_muc) {
        this.ten_danh_muc = ten_danh_muc;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public int getDanh_muc_con() {
        return danh_muc_con;
    }

    public void setDanh_muc_con(int danh_muc_con) {
        this.danh_muc_con = danh_muc_con;
    }
}
