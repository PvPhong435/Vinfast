/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author ADD
 */
public class Role {
    static NhanVien nhanVien=null;
    public static Boolean CheckEmployee()
    {
        if(Role.nhanVien!=null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static Boolean IsManager()
    {
        if(Role.nhanVien.getChucVu().equals("Quản lý"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void ClearEmployee()
    {
        Role.nhanVien=null;
    }
    
    static KhachHang khachHang=null;
    public static Boolean CheckCustomer()
    {
        if(Role.khachHang==null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public static void ClearCustomer()
    {
        Role.khachHang=null;
    }


    
 


    
    public static ChiNhanh chiNhanh=null;
    public static Boolean CheckChiNhanh()
    {
        if(Role.chiNhanh==null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public static void ClearChiNhanh()
    {
        Role.chiNhanh=null;
    }
}
