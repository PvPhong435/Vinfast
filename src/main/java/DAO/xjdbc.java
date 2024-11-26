/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.text.JTextComponent;

public class xjdbc {
    static String user = "myuser";
    static String pass = "myuser";
    //Thay đổi db phù hợp với máy cá nhân
    static String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyOTO;encrypt=true;trustServerCertificate=true";
    static Connection connection;
    static PreparedStatement statement;

    public xjdbc() {
        try {
            connection=DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void query(String sql,Consumer<ResultSet> query)
    {
        try {
            statement=connection.prepareStatement(sql);
            query.accept(statement.executeQuery());
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
    public static void queryWithCon(String sql,Consumer<ResultSet> qr,Object ...list)
    {
        if(sql.chars().filter(ch -> ch == '?').count() != list.length) {
            throw new IllegalArgumentException("Số ? không khớp");
        }
        try {
            statement=connection.prepareStatement(sql);
            int i=1;
            for(Object o:list)
            {
                if(o instanceof Integer n)
                {
                    statement.setInt(i, n);
                }
                else if(o instanceof Float f)
                {
                    statement.setFloat(i, f);
                }
                else if(o instanceof Boolean b)
                {
                    statement.setBoolean(i, b);
                }
                else if(o instanceof JPasswordField txt)
                {
                    statement.setString(i, txt.getText());
                }
                else if(o instanceof JTextComponent txt)
                {
                    statement.setString(i, txt.getText());
                }
                else if(o instanceof JRadioButton rdb)
                {
                    statement.setString(i, rdb.getText());
                }
                else
                {
                    statement.setObject(i, o);
                }
                i++;
            }
            ResultSet rs=statement.executeQuery();
            qr.accept(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static int Update(String sql,Object...list)
    {
        if(sql.chars().filter(ch -> ch == '?').count() != list.length) {
            throw new IllegalArgumentException("Số ? không khớp");
        }
        try {
           statement=connection.prepareStatement(sql); 
           int i=1;
           for(Object o:list)
            {
                if(o instanceof JPasswordField txt)
                {
                    statement.setString(i, txt.getText());
                }
                else if(o instanceof JTextComponent txt)
                {
                    statement.setString(i, txt.getText());
                }
                else if(o instanceof JRadioButton rdb)
                {
                    statement.setString(i, rdb.getText());
                }
                else
                {
                    statement.setObject(i, o);
                }
                i++;
            }
           return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
           return 0; 
        }
    }
    public static void Close()
    {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void Open()
    {
        try {
            connection=DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void Reset()
    {
        try {
            connection.close();
            connection=DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
