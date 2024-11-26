/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author ADD
 */
public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private Integer soLuongTon;
    private Float donGia;
    private String maLoai;

    public SanPham() {
    }

    public SanPham(String maSanPham, String tenSanPham, Integer soLuongTon, Float donGia, String maLoai) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
        this.maLoai = maLoai;
    }

    public String getMaSanPham() {
        return maSanPham;
    }
    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }
    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }
    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public Float getDonGia() {
        return donGia;
    }
    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }

    public String getMaLoai() {
        return maLoai;
    }
    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }
}
