/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author ADD
 */
public class ChiTietPhieuNhap {
    private String soPhieuNhap;
    private String maSanPham;
    private Integer soLuongNhap;
    private Float donGia;

    public ChiTietPhieuNhap() {
    }

    public ChiTietPhieuNhap(String soPhieuNhap, String maSanPham, Integer soLuongNhap, Float donGia) {
        this.soPhieuNhap = soPhieuNhap;
        this.maSanPham = maSanPham;
        this.soLuongNhap = soLuongNhap;
        this.donGia = donGia;
    }

    public String getSoPhieuNhap() {
        return soPhieuNhap;
    }
    public void setSoPhieuNhap(String soPhieuNhap) {
        this.soPhieuNhap = soPhieuNhap;
    }

    public String getMaSanPham() {
        return maSanPham;
    }
    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public Integer getSoLuongNhap() {
        return soLuongNhap;
    }
    public void setSoLuongNhap(Integer soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public Float getDonGia() {
        return donGia;
    }
    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }
}
