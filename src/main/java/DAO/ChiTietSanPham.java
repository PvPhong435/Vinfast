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
public class ChiTietSanPham {
    private String maSanPham;
    private Date namSanXuat;
    private String hopSo;
    private Float canNang;
    private String tinhTrang;
    private String mau;
    private String congXuat;
    private String tieuThuDienNang;
    private String soTuiKhi;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(String maSanPham, Date namSanXuat, String hopSo, Float canNang, String tinhTrang, String mau, String congXuat, String tieuThuDienNang, String soTuiKhi) {
        this.maSanPham = maSanPham;
        this.namSanXuat = namSanXuat;
        this.hopSo = hopSo;
        this.canNang = canNang;
        this.tinhTrang = tinhTrang;
        this.mau = mau;
        this.congXuat = congXuat;
        this.tieuThuDienNang = tieuThuDienNang;
        this.soTuiKhi = soTuiKhi;
    }

    public String getMaSanPham() {
        return maSanPham;
    }
    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public Date getNamSanXuat() {
        return namSanXuat;
    }
    public void setNamSanXuat(Date namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getHopSo() {
        return hopSo;
    }
    public void setHopSo(String hopSo) {
        this.hopSo = hopSo;
    }

    public Float getCanNang() {
        return canNang;
    }
    public void setCanNang(Float canNang) {
        this.canNang = canNang;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }
    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getMau() {
        return mau;
    }
    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getCongXuat() {
        return congXuat;
    }
    public void setCongXuat(String congXuat) {
        this.congXuat = congXuat;
    }

    public String getTieuThuDienNang() {
        return tieuThuDienNang;
    }
    public void setTieuThuDienNang(String tieuThuDienNang) {
        this.tieuThuDienNang = tieuThuDienNang;
    }

    public String getSoTuiKhi() {
        return soTuiKhi;
    }
    public void setSoTuiKhi(String soTuiKhi) {
        this.soTuiKhi = soTuiKhi;
    }
}
