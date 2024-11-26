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
public class ChiTietPhieuXuat {
    private String soPhieu;
    private String maSanPham;
    private Integer soLuongMua;
    private Date ngayKetThucBH;

    public ChiTietPhieuXuat() {
    }
    public ChiTietPhieuXuat(String soPhieu, String maSanPham, Integer soLuongMua, Date ngayKetThucBH) {
        this.soPhieu = soPhieu;
        this.maSanPham = maSanPham;
        this.soLuongMua = soLuongMua;
        this.ngayKetThucBH = ngayKetThucBH;
    }

    public String getSoPhieu() {
        return soPhieu;
    }
    public void setSoPhieu(String soPhieu) {
        this.soPhieu = soPhieu;
    }

    public String getMaSanPham() {
        return maSanPham;
    }
    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public Integer getSoLuongMua() {
        return soLuongMua;
    }
    public void setSoLuongMua(Integer soLuongMua) {
        this.soLuongMua = soLuongMua;
    }

    public Date getNgayKetThucBH() {
        return ngayKetThucBH;
    }
    public void setNgayKetThucBH(Date ngayKetThucBH) {
        this.ngayKetThucBH = ngayKetThucBH;
    }
}
