/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author ADD
 */
public class NhaCungCap {
    private String maNhaCungCap;
    private String tenNhaCungCap;
    private String diaChi;
    private String SDT;

    public NhaCungCap() {
    }

    public NhaCungCap(String maNhaCungCap, String tenNhaCungCap, String diaChi, String SDT) {
        this.maNhaCungCap = maNhaCungCap;
        this.tenNhaCungCap = tenNhaCungCap;
        this.diaChi = diaChi;
        this.SDT = SDT;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }
    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }
    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }
    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
}
