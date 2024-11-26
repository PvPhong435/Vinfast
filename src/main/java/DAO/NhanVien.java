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
public class NhanVien {
    private String maNhanVien;
    private String tenNhanVien;
    private String matKhau;
    private String ChucVu;
    private String gioiTinh;
    private Date namSinh;
    private String SDT;       
    private String email;
    private String QRCode;
    private String maChiNhanh;
    

    public NhanVien() {
    }

    public NhanVien(String maNhanVien, String tenNhanVien, String matKhau, String ChucVu, String gioiTinh, Date namSinh, String SDT, String email, String QRCode, String maChiNhanh) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.matKhau = matKhau;
        this.ChucVu = ChucVu;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
        this.SDT = SDT;
        this.email = email;
        this.QRCode = QRCode;
        this.maChiNhanh = maChiNhanh;
        
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }
    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getMatKhau() {
        return matKhau;
    }
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getChucVu() {
        return ChucVu;
    }
    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNamSinh() {
        return namSinh;
    }
    public void setNamSinh(Date namSinh) {
        this.namSinh = namSinh;
    }

    public String getSDT() {
        return SDT;
    }
    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getQRCode() {
        return QRCode;
    }

    public void setQRCode(String QRCode) {
        this.QRCode = QRCode;
    }
    

    public String getMaChiNhanh() {
        return maChiNhanh;
    }
    public void setMaChiNhanh(String maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
    }
}
