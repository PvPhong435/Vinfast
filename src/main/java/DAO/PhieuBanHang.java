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
public class PhieuBanHang {
    private String soPhieu;
    private Date ngayXuat;
    private String trangThai;
    private String phuongThucThanhToan;
    private String maChiNhanh;
    private String maKhachHang;

    public PhieuBanHang() {
    }

    public PhieuBanHang(String soPhieu, Date ngayXuat, String trangThai, String phuongThucThanhToan, String maChiNhanh, String maKhachHang) {
        this.soPhieu = soPhieu;
        this.ngayXuat = ngayXuat;
        this.trangThai = trangThai;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.maChiNhanh = maChiNhanh;
        this.maKhachHang = maKhachHang;
    }

    public String getSoPhieu() {
        return soPhieu;
    }
    public void setSoPhieu(String soPhieu) {
        this.soPhieu = soPhieu;
    }

    public Date getNgayXuat() {
        return ngayXuat;
    }
    public void setNgayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }
    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public String getMaChiNhanh() {
        return maChiNhanh;
    }
    public void setMaChiNhanh(String maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }
    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
}
