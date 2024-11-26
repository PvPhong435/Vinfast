/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author ADD
 */
public class ChiNhanh {
    private String maChiNhanh;
    private String tenChiNhanh;
    private String diaChi;
    private String SDT;

    public ChiNhanh() {
    }

    public ChiNhanh(String maChiNhanh, String tenChiNhanh, String diaChi, String SDT) {
        this.maChiNhanh = maChiNhanh;
        this.tenChiNhanh = tenChiNhanh;
        this.diaChi = diaChi;
        this.SDT = SDT;
    }

    public String getMaChiNhanh() {
        return maChiNhanh;
    }
    public void setMaChiNhanh(String maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
    }

    public String getTenChiNhanh() {
        return tenChiNhanh;
    }
    public void setTenChiNhanh(String tenChiNhanh) {
        this.tenChiNhanh = tenChiNhanh;
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
