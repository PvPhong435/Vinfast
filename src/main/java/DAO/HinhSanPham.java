/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author ADD
 */
public class HinhSanPham {
    private String maSanPham;
    private String hinh;

    public HinhSanPham() {
    }

    public HinhSanPham(String maSanPham, String hinh) {
        this.maSanPham = maSanPham;
        this.hinh = hinh;
    }

    public String getMaSanPham() {
        return maSanPham;
    }
    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getHinh() {
        return hinh;
    }
    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
    
     
}
