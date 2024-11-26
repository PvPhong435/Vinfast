/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.Date;

/**
 *
 * @author ADD
 */
public class PhieuNhap {
    private String soPhieuNhap;
    private Date ngayNhap;
    private String MaChiNhanh;
    private String maNhanVien;
    private String maNhaCungCap;

    public PhieuNhap() {
    }

    public PhieuNhap(String soPhieuNhap, Date ngayNhap, String MaChiNhanh, String maNhanVien, String maNhaCungCap) {
        this.soPhieuNhap = soPhieuNhap;
        this.ngayNhap = ngayNhap;
        this.MaChiNhanh = MaChiNhanh;
        this.maNhanVien = maNhanVien;
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getSoPhieuNhap() {
        return soPhieuNhap;
    }
    public void setSoPhieuNhap(String soPhieuNhap) {
        this.soPhieuNhap = soPhieuNhap;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }
    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getMaChiNhanh() {
        return MaChiNhanh;
    }
    public void setMaChiNhanh(String MaChiNhanh) {
        this.MaChiNhanh = MaChiNhanh;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }
    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }
    
    
    
}
