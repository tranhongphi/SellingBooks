package com.tranhongphi.webbansach.model;

public class Item {
    private int id;
    private SanPham sanPham;
    private int soLuong;
    private int gia;

    public Item() {
    }

    public Item(int id, SanPham sanPham, int soLuong, int gia) {
        this.id = id;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
