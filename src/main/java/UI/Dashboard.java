/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import DAO.Role;
import java.awt.Color;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import raven.chart.ModelChart;
import test.DatabaseConnection;
import test.ModelData;
import untils.XImage;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import raven.chart.ModelChart;
/**
 *
 * @author ASUS
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
             void init(){
        setChart();
        setChar1();
        initTable();
//        initTable();

        initEmpTable();
        setIconImage(XImage.getAppIcon());
        setTitle("VINFAST SHOWROOM MANAGEMENT");
        setLocationRelativeTo(null);
        // set logo
        int hight1 = lbl_logo.getHeight();
        int width1 = lbl_logo.getWidth();
        ImageIcon login_img1 = new ImageIcon("E:\\Desktop\\F_poly\\SPRING_24\\DUAN1\\project1\\src\\main\\resources\\imgs\\bigLogo.png");
        Image background_login1 = login_img1.getImage().getScaledInstance(width1, hight1, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(background_login1);
         lbl_logo.setIcon(scaledIcon1); 
    }
    public Dashboard() {
//    dlg_welcommm s = new dlg_welcommm(this, true);
//    s.setVisible(true); 
    new dlg_login(this, true).setVisible(true);  
        initComponents();
        init();
    }
    
    // pnl_dashboard
        private void setData() {
            
        try {
            List<ModelData> lists = new ArrayList<>();
            DatabaseConnection.getInstance().connectToDatabase();
            String sql = "select DATE_FORMAT(Date,'%M') as `Month`, SUM(TotalAmount) as Amount, SUM(TotalCost) as Cost, SUM(TotalProfit) as Profit from orders group by DATE_FORMAT(Date,'%m%Y') order by Date DESC limit 7";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                String month = r.getString("Month");
                double amount = r.getDouble("Amount");
                double cost = r.getDouble("Cost");
                double profit = r.getDouble("Profit");
                lists.add(new ModelData(month, amount, cost, profit));
            }
            r.close();
            p.close();
            //  Add Data to chart
            for (int i = lists.size() - 1; i >= 0; i--) {
                ModelData d = lists.get(i);
                chart.addData(new ModelChart(d.getMonth(), new double[]{d.getAmount(), d.getCost(), d.getProfit()}));
            }
            //  Start to show data with animation
            chart.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void setChart() {
        chart.setTitle("Biều Đồ Dữ Liệu Toàn Hệ thống");
        chart.addLegend("Doanh thu", Color.decode("#7b4397"), Color.decode("#dc2430"));
        chart.addLegend("Oto điện", Color.decode("#e65c00"), Color.decode("#F9D423"));
        chart.addLegend("Oto xăng", Color.decode("#0099F7"), Color.decode("#F11712"));
        chart.addLegend("Xe máy", Color.decode("#FFD700"), Color.decode("#32CD32"));
        chart.clear();
        chart.addData(new ModelChart("Tháng1", new double[]{500, 50, 100, 500}));
        chart.addData(new ModelChart("Tháng2", new double[]{600, 300, 150, 600}));
        chart.addData(new ModelChart("Tháng3", new double[]{200, 50, 900, 200}));
        chart.addData(new ModelChart("Tháng4", new double[]{480, 700, 100, 480}));
        chart.addData(new ModelChart("Tháng5", new double[]{350, 540, 500 ,350}));
        chart.addData(new ModelChart("Tháng6", new double[]{450, 800, 100, 450}));
        chart.addData(new ModelChart("Tháng7", new double[]{500, 50, 100, 500}));
        chart.addData(new ModelChart("Tháng8", new double[]{600, 300, 150, 600}));
        chart.addData(new ModelChart("Tháng9", new double[]{200, 50, 900, 200}));
        chart.addData(new ModelChart("Tháng10", new double[]{480, 700, 100, 480}));
        chart.addData(new ModelChart("Tháng11", new double[]{350, 540, 500 ,350}));
        chart.addData(new ModelChart("Tháng12", new double[]{450, 800, 100, 450}));
        chart.start();
    }
    
    
    // pnl_statictis
        private void setData1() {
        try {
            List<ModelData> lists = new ArrayList<>();
            DatabaseConnection.getInstance().connectToDatabase();
            String sql = "select DATE_FORMAT(Date,'%M') as `Month`, SUM(TotalAmount) as Amount, SUM(TotalCost) as Cost, SUM(TotalProfit) as Profit from orders group by DATE_FORMAT(Date,'%m%Y') order by Date DESC limit 7";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                String month = r.getString("Month");
                double amount = r.getDouble("Amount");
                double cost = r.getDouble("Cost");
                double profit = r.getDouble("Profit");
                lists.add(new ModelData(month, amount, cost, profit));
            }
            r.close();
            p.close();
            //  Add Data to chart
            for (int i = lists.size() - 1; i >= 0; i--) {
                ModelData d = lists.get(i);
                chart.addData(new ModelChart(d.getMonth(), new double[]{d.getAmount(), d.getCost(), d.getProfit()}));
            }
            //  Start to show data with animation
            chart.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void setChar1() {
        chart1.setTitle("Biều Đồ Dữ Liệu Chi Nhánh");
        chart1.addLegend("Doanh thu", Color.decode("#7b4397"), Color.decode("#dc2430"));
        chart1.addLegend("Oto điện", Color.decode("#e65c00"), Color.decode("#F9D423"));
        chart1.addLegend("Oto xăng", Color.decode("#0099F7"), Color.decode("#F11712"));
        chart1.addLegend("Xe máy", Color.decode("#FFD700"), Color.decode("#32CD32"));
        
        chart1.clear();
        chart1.addData(new ModelChart("Tháng1", new double[]{500, 50, 100, 500}));
        chart1.addData(new ModelChart("Tháng2", new double[]{600, 300, 150, 600}));
        chart1.addData(new ModelChart("Tháng3", new double[]{200, 50, 900, 200}));
        chart1.addData(new ModelChart("Tháng4", new double[]{480, 700, 100, 480}));
        chart1.addData(new ModelChart("Tháng5", new double[]{350, 540, 5060 ,350}));
        chart1.addData(new ModelChart("Tháng6", new double[]{450, 800, 100, 450}));
        chart1.addData(new ModelChart("Tháng7", new double[]{500, 50, 100, 500}));
        chart1.addData(new ModelChart("Tháng8", new double[]{600, 300, 150, 600}));
        chart1.addData(new ModelChart("Tháng9", new double[]{200, 50, 900, 200}));
        chart1.addData(new ModelChart("Tháng10", new double[]{480, 700, 100, 480}));
        chart1.addData(new ModelChart("Tháng11", new double[]{350, 540, 500 ,350}));
        chart1.addData(new ModelChart("Tháng12", new double[]{450, 800, 100, 450}));
        chart1.start();
    }
    
    //pnl reparing history
        public void initable(){
        String sql = "select* from SuaChuavaBaoHanh";
    try {
        // Khởi tạo Connection và Statement
        Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Duan1;encrypt=true;trustServerCertificate=true", "sa", "123456");
        Statement st = con.createStatement();

        // Thực hiện truy vấn
        ResultSet rs = st.executeQuery(sql);

        // Tạo một DefaultTableModel
        DefaultTableModel model = new DefaultTableModel(new String[]{"STT", "Mã Bảo Hành", "Mã Xe", "Tên Xe", "Mã Khách Hàng", "Tên Khách Hàng", "Ngày Bảo Hành", "Mô Tả Lỗi", "Giải Pháp"}, 0);

        // Xử lý kết quả
        int stt = 1;
        while(rs.next()){
            String maBH = rs.getString("MaBaoHanh");
            String tenMx = rs.getString("MaXe");
            String tenXe = rs.getString("TenXe");
            String maKH = rs.getString("MaKhachHang");
            String tenKH = rs.getString("TenKhachHang");
            String ngayBH = rs.getString("NgayBaoHanh");
            String moTa = rs.getString("MoTaLoi");
            String giaiPhap= rs.getString("GiaiPhap");
            model.addRow(new Object[]{stt, maBH, tenMx, tenXe, maKH, tenKH, ngayBH, moTa, giaiPhap});
            stt++;
        }

        // Gán DefaultTableModel cho JTable
        tblsuachua.setModel(model);

        con.close();
    } catch (Exception e) {
        System.out.println(e);
    }
}
    
    // pnl_customer
        public void initTable() {
    String sql = "select * from KhachHang";
    try {
        // Khởi tạo Connection và Statement
        Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Duan1;encrypt=true;trustServerCertificate=true", "sa", "123456");
        Statement st = con.createStatement();

        // Thực hiện truy vấn
        ResultSet rs = st.executeQuery(sql);

        // Tạo một DefaultTableModel
        DefaultTableModel model = new DefaultTableModel(new String[]{"STT","Mã Khách Hàng", "Tên Khách Hàng", "Năm Sinh", "Địa Chỉ", "SDT", "Email","Lịch Sử Giao Dịch"}, 0);
        // Xử lý kết quả
        int stt = 1;
        while(rs.next()){
            String maKhachHang = rs.getString("MaKhachHang");
            String tenKhachHang = rs.getString("TenKhachHang");
            String namSinh = rs.getString("NamSinh");
            String diaChi = rs.getString("DiaChi");
            String sdt = rs.getString("SDT");
            String email = rs.getString("Email");
            model.addRow(new Object[]{stt,maKhachHang, tenKhachHang, namSinh, diaChi, sdt, email,""});
            stt++;
        }

        // Gán DefaultTableModel cho JTable
        tblkhachhang.setModel(model);

        con.close();
    } catch (Exception e) {
        System.out.println(e);
    }
}
        //pnl employee
            public void initEmpTable() {
        String sql = "select* from NhanVien";
    try {
        // Khởi tạo Connection và Statement
        Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Duan1;encrypt=true;trustServerCertificate=true", "sa", "123456");
        Statement st = con.createStatement();

        // Thực hiện truy vấn
        ResultSet rs = st.executeQuery(sql);

        // Tạo một DefaultTableModel
        DefaultTableModel model = new DefaultTableModel(new String[]{"STT", "MaNhanVien", "TenNhanVien", "MatKhau", "ChucVu", "GioiTinh", "NamSinh", "SDT", "Email", "MaChiNhanh"}, 0);

        // Xử lý kết quả
        int stt = 1;
        while(rs.next()){
            String maNv = rs.getString("MaNhanVien");
            String tenNv = rs.getString("TenNhanVien");
            String matkhau = rs.getString("MatKhau");
            String chucVu = rs.getString("ChucVu");
            String gioiTinh = rs.getString("GioiTinh");
            String namSinh = rs.getString("NamSinh");
            String sdt = rs.getString("SDT");
            String email = rs.getString("Email");
            String maChinhanh = rs.getString("MaChiNhanh");
            model.addRow(new Object[]{stt, maNv, tenNv, matkhau, chucVu, gioiTinh, namSinh, sdt, email, maChinhanh});
            stt++;
        }

        // Gán DefaultTableModel cho JTable
        tblnhanvien.setModel(model);

        con.close();
    } catch (Exception e) {
        System.out.println(e);
    }
}
            
            // pnl branch
//            public void LoadDuLieu() {
//        LamMoi();
//        if(!Role.CheckChiNhanh())
//        {
//            lbChiNhanh.setText("Chưa Chọn Chi Nhánh");
//        }
//        else
//        {
//            lbChiNhanh.setText(Role.chiNhanh.getTenChiNhanh());
//        }
//        DefaultTableModel model = new DefaultTableModel();
//        model.addColumn("Mã Chi nhánh");
//        model.addColumn("Tên Chi Nhánh");
//        model.addColumn("Địa Chỉ");
//        model.addColumn("SDT");
//
//        db.query("SELECT * FROM ChiNhanh", rs
//                -> {
//            try {
//                dscn.clear();
//                while (rs.next()) {
//                    dscn.add(new DAO.ChiNhanh(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
//                    model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
//                }
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(rootPane, "Lỗi khi load dữ liệu");
//            }
//
//        });
//        tblChiNhanh.setModel(model);
//    }
    public void LamMoi()
    {
        txtMa.setText("");
        txtTen.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtMa.setEnabled(true);
        txtTen.setEnabled(true);
        txtDiaChi.setEnabled(true);
        txtSDT.setEnabled(true);
        btnDoiChiNhanh.setVisible(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        btnThem.setEnabled(true);
//        viTriChon=-1;
        txtMa.requestFocus();
    }
    public void KiemTraDuLieu()
    {
        String patter="\\d{10,12}";
        if(txtMa.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Bạn Chưa nhập dữ liệu");
            txtMa.requestFocus();
        }
        else
        {
            Boolean checkMaChiNhanh=true;
//            for(DAO.ChiNhanh cn:dscn)
//            {
//                if(cn.getMaChiNhanh().equalsIgnoreCase(txtMa.getText()))
//                {
//                    JOptionPane.showMessageDialog(rootPane, "Mã chi nhánh bạn nhập đã tồn tại vui lòng nhập lại");
//                    txtMa.setText("");
//                    txtMa.requestFocus();
//                    checkMaChiNhanh=false;
//                    break;
//                }
//            }
            if(checkMaChiNhanh)
            {
                if(txtTen.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(rootPane, "bạn chưa nhập tên chi nhánh");
                    txtTen.requestFocus();
                }
                else if(txtSDT.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập sdt");
                    txtSDT.requestFocus();
                }
                else if(!txtSDT.getText().matches(patter))
                {
                    JOptionPane.showMessageDialog(rootPane, "SDT bạn nhập không đúng định dạng");
                    txtSDT.setText("");
                    txtSDT.requestFocus();
                }
                else if(txtDiaChi.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập địa chỉ");
                }
                else 
                {
                    ThemDuLieu();
                }
            }
        }
    }
    public void ThemDuLieu()
    {
//        if(db.Update("INSERT INTO ChiNhanh VALUES (?,?,?,?)", txtMa.getText(),txtTen.getText(),txtDiaChi.getText(),txtSDT.getText())>0)
//        {
//            JOptionPane.showMessageDialog(rootPane, "Thêm chi nhánh thành công");
//            LoadDuLieu();
//        }
//        else
//        {
//            JOptionPane.showMessageDialog(rootPane, "Thêm Chi nhánh thất bại");
//            txtMa.requestFocus();
//        }
    }
//    public void LayPhanTuTaiViTri(int index)
//    {
//        DAO.ChiNhanh cn=dscn.get(index);
//        txtMa.setText(cn.getMaChiNhanh());
//        txtTen.setText(cn.getTenChiNhanh());
//        txtDiaChi.setText(cn.getDiaChi());
//        txtSDT.setText(cn.getSDT());
//        txtMa.setEnabled(false);
//        btnDoiChiNhanh.setVisible(true);
//        btnSua.setEnabled(true);
//        btnXoa.setEnabled(true);
//    }
//    public void SuaDuLieu()
//    {
//        DAO.ChiNhanh cn=dscn.get(viTriChon);
//        if(txtTen.getText().equalsIgnoreCase(cn.getTenChiNhanh())&&txtSDT.getText().equalsIgnoreCase(cn.getSDT())&&txtDiaChi.getText().equalsIgnoreCase(cn.getDiaChi()))
//        {
//            JOptionPane.showMessageDialog(rootPane, "Bạn chưa sửa dữ liệu nào cả");
//            txtTen.requestFocus();
//        }
//        else
//        {
//            if(db.Update("UPDATE ChiNhanh SET TenChiNhanh=?, DiaChi=?, SDT=? WHERE MaChiNhanh=?", txtTen.getText(),txtDiaChi.getText(),txtSDT.getText(),txtMa.getText())>0)
//            {
//                JOptionPane.showMessageDialog(rootPane, "Sửa dữ liệu thành công");
//                LoadDuLieu();
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(rootPane, "Sửa dữ liệu thất bại ");
//                txtTen.requestFocus();
//            }
//        }
//    }
//    public void XoaDuLieu()
//    {
//        if(db.Update("DELETE FROM ChiNhanh WHERE MaChiNhanh=?", txtMa.getText())>0)
//        {
//            JOptionPane.showMessageDialog(rootPane, "Xóa dữ liệu thành công");
//            LoadDuLieu();
//        }
//        else
//        {
//            JOptionPane.showMessageDialog(rootPane, "Xóa Chi nhánh Thất bại");
//        }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        menu_dashboard = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        menu_statictis = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        menu_calender = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        menu_transactionHistory = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        menu_enteringHistory = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        menu_repairingHistory = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        menu_branch = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        menu_employee = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        menu_customer = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        menu_carList = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        menu_services = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        menu_timeKeeping = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        menu_setting = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        menu_contact = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbl_logo = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnl_dashboard = new javax.swing.JPanel();
        panelShadow1 = new raven.panel.PanelShadow();
        chart = new raven.chart.CurveLineChart();
        pnl_statictis = new javax.swing.JPanel();
        panelShadow2 = new raven.panel.PanelShadow();
        chart1 = new raven.chart.CurveLineChart();
        pnl_calender = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        cboChonThoiGian = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblLich = new javax.swing.JTable();
        cboChonThoiGian1 = new javax.swing.JComboBox<>();
        btn = new javax.swing.JButton();
        pnl_transactionHistory = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblLSGiaoDich = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        pnl_enteringHistory = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblLSNhapHang = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        pnl_repairingHistory = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        lblbanghi = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblsuachua = new javax.swing.JTable();
        pnl_branch = new javax.swing.JPanel();
        btnThoat = new javax.swing.JButton();
        btnDoiChiNhanh = new javax.swing.JButton();
        lbChiNhanh = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblChiNhanh = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        txtMa = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        pnl_employee = new javax.swing.JPanel();
        lblnext = new javax.swing.JButton();
        lblbanghi1 = new javax.swing.JLabel();
        btnback1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblnhanvien = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        Themnvmoi = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        pnl_carList = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        btnThemSanPham = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        cboLoaiXe = new javax.swing.JComboBox<>();
        cboMauXe = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        Section = new javax.swing.JPanel();
        TempCarCard = new javax.swing.JPanel();
        icoHinh = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JLabel();
        txtGiaSP = new javax.swing.JLabel();
        txtMoTa = new javax.swing.JTextArea();
        btnChinhSua = new javax.swing.JButton();
        TempCarCard1 = new javax.swing.JPanel();
        icoHinh1 = new javax.swing.JLabel();
        txtTenSP1 = new javax.swing.JLabel();
        txtGiaSP1 = new javax.swing.JLabel();
        txtMoTa1 = new javax.swing.JTextArea();
        btnChinhSua1 = new javax.swing.JButton();
        TempCarCard2 = new javax.swing.JPanel();
        icoHinh2 = new javax.swing.JLabel();
        txtTenSP2 = new javax.swing.JLabel();
        txtGiaSP2 = new javax.swing.JLabel();
        txtMoTa2 = new javax.swing.JTextArea();
        btnChinhSua2 = new javax.swing.JButton();
        TempCarCard3 = new javax.swing.JPanel();
        icoHinh3 = new javax.swing.JLabel();
        txtTenSP3 = new javax.swing.JLabel();
        txtGiaSP3 = new javax.swing.JLabel();
        txtMoTa3 = new javax.swing.JTextArea();
        btnChinhSua3 = new javax.swing.JButton();
        pnl_services = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        txtTimKiem1 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        btnThemSanPham1 = new javax.swing.JButton();
        pnl_timeKeeping = new javax.swing.JPanel();
        pnl_setting = new javax.swing.JPanel();
        pnl_contact = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        pnl_customer = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        cbbkhuvuc = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblkhachhang = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        btnnext = new javax.swing.JButton();
        lblBangGhi = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/fn_icon/icons8-homepage-35.png"))); // NOI18N
        jLabel2.setText("Bảng điều khiển");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout menu_dashboardLayout = new org.jdesktop.layout.GroupLayout(menu_dashboard);
        menu_dashboard.setLayout(menu_dashboardLayout);
        menu_dashboardLayout.setHorizontalGroup(
            menu_dashboardLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu_dashboardLayout.setVerticalGroup(
            menu_dashboardLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Chức năng");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/fn_icon/icons8-statistics-35.png"))); // NOI18N
        jLabel3.setText("Thống kê doanh thu");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout menu_statictisLayout = new org.jdesktop.layout.GroupLayout(menu_statictis);
        menu_statictis.setLayout(menu_statictisLayout);
        menu_statictisLayout.setHorizontalGroup(
            menu_statictisLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu_statictisLayout.setVerticalGroup(
            menu_statictisLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/fn_icon/icons8-desk-calender-35.png"))); // NOI18N
        jLabel4.setText("Lịch giao xe");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout menu_calenderLayout = new org.jdesktop.layout.GroupLayout(menu_calender);
        menu_calender.setLayout(menu_calenderLayout);
        menu_calenderLayout.setHorizontalGroup(
            menu_calenderLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu_calenderLayout.setVerticalGroup(
            menu_calenderLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/fn_icon/icons8-transaction-35.png"))); // NOI18N
        jLabel5.setText("Lịch sử giao dịch");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout menu_transactionHistoryLayout = new org.jdesktop.layout.GroupLayout(menu_transactionHistory);
        menu_transactionHistory.setLayout(menu_transactionHistoryLayout);
        menu_transactionHistoryLayout.setHorizontalGroup(
            menu_transactionHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu_transactionHistoryLayout.setVerticalGroup(
            menu_transactionHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/fn_icon/icons8-history-35.png"))); // NOI18N
        jLabel6.setText("Lịch sử nhập hàng");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout menu_enteringHistoryLayout = new org.jdesktop.layout.GroupLayout(menu_enteringHistory);
        menu_enteringHistory.setLayout(menu_enteringHistoryLayout);
        menu_enteringHistoryLayout.setHorizontalGroup(
            menu_enteringHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu_enteringHistoryLayout.setVerticalGroup(
            menu_enteringHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/fn_icon/icons8-repairing-35.png"))); // NOI18N
        jLabel7.setText("Lịch sửa chữa bảo hành");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout menu_repairingHistoryLayout = new org.jdesktop.layout.GroupLayout(menu_repairingHistory);
        menu_repairingHistory.setLayout(menu_repairingHistoryLayout);
        menu_repairingHistoryLayout.setHorizontalGroup(
            menu_repairingHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );
        menu_repairingHistoryLayout.setVerticalGroup(
            menu_repairingHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Quản lý");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/fn_icon/icons8-branch-34.png"))); // NOI18N
        jLabel9.setText("Chi nhánh");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout menu_branchLayout = new org.jdesktop.layout.GroupLayout(menu_branch);
        menu_branch.setLayout(menu_branchLayout);
        menu_branchLayout.setHorizontalGroup(
            menu_branchLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu_branchLayout.setVerticalGroup(
            menu_branchLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/fn_icon/icons8-customer-35.png"))); // NOI18N
        jLabel10.setText("Nhân viên");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout menu_employeeLayout = new org.jdesktop.layout.GroupLayout(menu_employee);
        menu_employee.setLayout(menu_employeeLayout);
        menu_employeeLayout.setHorizontalGroup(
            menu_employeeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu_employeeLayout.setVerticalGroup(
            menu_employeeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/fn_icon/icons8-client-35.png"))); // NOI18N
        jLabel11.setText("Khách hàng");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout menu_customerLayout = new org.jdesktop.layout.GroupLayout(menu_customer);
        menu_customer.setLayout(menu_customerLayout);
        menu_customerLayout.setHorizontalGroup(
            menu_customerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel11, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu_customerLayout.setVerticalGroup(
            menu_customerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel11, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/fn_icon/icons8-car-35.png"))); // NOI18N
        jLabel12.setText("Xe VINFAST");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout menu_carListLayout = new org.jdesktop.layout.GroupLayout(menu_carList);
        menu_carList.setLayout(menu_carListLayout);
        menu_carListLayout.setHorizontalGroup(
            menu_carListLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu_carListLayout.setVerticalGroup(
            menu_carListLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/fn_icon/icons8-repairing-35 (1).png"))); // NOI18N
        jLabel13.setText("Bảo dưỡng và dịch vụ");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout menu_servicesLayout = new org.jdesktop.layout.GroupLayout(menu_services);
        menu_services.setLayout(menu_servicesLayout);
        menu_servicesLayout.setHorizontalGroup(
            menu_servicesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel13, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu_servicesLayout.setVerticalGroup(
            menu_servicesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel13, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setText("Khác");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/fn_icon/icons8-appointment-35.png"))); // NOI18N
        jLabel15.setText("Chấm công");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout menu_timeKeepingLayout = new org.jdesktop.layout.GroupLayout(menu_timeKeeping);
        menu_timeKeeping.setLayout(menu_timeKeepingLayout);
        menu_timeKeepingLayout.setHorizontalGroup(
            menu_timeKeepingLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel15, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu_timeKeepingLayout.setVerticalGroup(
            menu_timeKeepingLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel15, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/fn_icon/icons8-setting-35.png"))); // NOI18N
        jLabel16.setText("Cài đặt");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout menu_settingLayout = new org.jdesktop.layout.GroupLayout(menu_setting);
        menu_setting.setLayout(menu_settingLayout);
        menu_settingLayout.setHorizontalGroup(
            menu_settingLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel16, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu_settingLayout.setVerticalGroup(
            menu_settingLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel16, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/fn_icon/icons8-phone-35.png"))); // NOI18N
        jLabel17.setText("Hỗ trợ");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout menu_contactLayout = new org.jdesktop.layout.GroupLayout(menu_contact);
        menu_contact.setLayout(menu_contactLayout);
        menu_contactLayout.setHorizontalGroup(
            menu_contactLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel17, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu_contactLayout.setVerticalGroup(
            menu_contactLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel17, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, menu_dashboard, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(menu_statictis, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(menu_calender, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(menu_transactionHistory, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(menu_enteringHistory, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(menu_repairingHistory, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(menu_branch, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(menu_employee, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(menu_customer, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(menu_carList, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(menu_services, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 152, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 87, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(menu_timeKeeping, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(menu_setting, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(menu_contact, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(menu_dashboard, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(menu_statictis, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(menu_calender, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(menu_transactionHistory, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(menu_enteringHistory, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(menu_repairingHistory, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel8)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(menu_branch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(menu_employee, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(menu_customer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(menu_carList, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(menu_services, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel14)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(menu_timeKeeping, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(menu_setting, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(menu_contact, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 230, 680));

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(1168, Short.MAX_VALUE)
                .add(lbl_logo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 160, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(62, 62, 62))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .add(lbl_logo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 70));

        panelShadow1.setBackground(new java.awt.Color(34, 59, 68));
        panelShadow1.setColorGradient(new java.awt.Color(17, 37, 45));

        chart.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        org.jdesktop.layout.GroupLayout panelShadow1Layout = new org.jdesktop.layout.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .add(chart, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 1094, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addContainerGap(175, Short.MAX_VALUE)
                .add(chart, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 464, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout pnl_dashboardLayout = new org.jdesktop.layout.GroupLayout(pnl_dashboard);
        pnl_dashboard.setLayout(pnl_dashboardLayout);
        pnl_dashboardLayout.setHorizontalGroup(
            pnl_dashboardLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, pnl_dashboardLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelShadow1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_dashboardLayout.setVerticalGroup(
            pnl_dashboardLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, pnl_dashboardLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .add(panelShadow1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab1", pnl_dashboard);

        panelShadow2.setBackground(new java.awt.Color(34, 59, 68));
        panelShadow2.setColorGradient(new java.awt.Color(17, 37, 45));

        chart1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        org.jdesktop.layout.GroupLayout panelShadow2Layout = new org.jdesktop.layout.GroupLayout(panelShadow2);
        panelShadow2.setLayout(panelShadow2Layout);
        panelShadow2Layout.setHorizontalGroup(
            panelShadow2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelShadow2Layout.createSequentialGroup()
                .add(15, 15, 15)
                .add(chart1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 1088, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelShadow2Layout.setVerticalGroup(
            panelShadow2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panelShadow2Layout.createSequentialGroup()
                .addContainerGap(190, Short.MAX_VALUE)
                .add(chart1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 336, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(106, 106, 106))
        );

        org.jdesktop.layout.GroupLayout pnl_statictisLayout = new org.jdesktop.layout.GroupLayout(pnl_statictis);
        pnl_statictis.setLayout(pnl_statictisLayout);
        pnl_statictisLayout.setHorizontalGroup(
            pnl_statictisLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnl_statictisLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelShadow2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_statictisLayout.setVerticalGroup(
            pnl_statictisLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnl_statictisLayout.createSequentialGroup()
                .add(37, 37, 37)
                .add(panelShadow2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab2", pnl_statictis);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel24.setText("Lich Giao Xe");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cboChonThoiGian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Chon Thoi Gian -", "Hom nay", "Tuan nay", "Thang nay", "Nam nay" }));
        cboChonThoiGian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboChonThoiGianActionPerformed(evt);
            }
        });

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jButton6.setText("<");
        jPanel10.add(jButton6);

        jLabel25.setText("1 tren 100");
        jPanel10.add(jLabel25);

        jButton7.setText(">");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton7);

        tblLich.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tblLich);

        cboChonThoiGian1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Chon Trang Thai -", "Da giao", "Chua giao" }));
        cboChonThoiGian1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboChonThoiGian1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel9Layout = new org.jdesktop.layout.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1116, Short.MAX_VALUE)
                    .add(jPanel10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel9Layout.createSequentialGroup()
                        .add(cboChonThoiGian, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 170, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(cboChonThoiGian1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 170, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(24, 24, 24)
                        .add(txtTimKiem, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cboChonThoiGian, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cboChonThoiGian1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtTimKiem, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jScrollPane6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 435, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(27, 27, 27)
                .add(jPanel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(14, 14, 14))
        );

        btn.setText("Tao Don Hang Moi");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout pnl_calenderLayout = new org.jdesktop.layout.GroupLayout(pnl_calender);
        pnl_calender.setLayout(pnl_calenderLayout);
        pnl_calenderLayout.setHorizontalGroup(
            pnl_calenderLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnl_calenderLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .add(pnl_calenderLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jLabel24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 243, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(340, 340, 340)
                .add(btn)
                .add(24, 24, 24))
        );
        pnl_calenderLayout.setVerticalGroup(
            pnl_calenderLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnl_calenderLayout.createSequentialGroup()
                .add(12, 12, 12)
                .add(pnl_calenderLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel24)
                    .add(btn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab3", pnl_calender);

        jButton3.setBackground(new java.awt.Color(102, 204, 255));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton3.setText("Export");

        tblLSGiaoDich.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Ma PX", "Mã KH", "Tên KH", "Mã SP", "Tên SP", "Ngày Xuât", "Han BH"
            }
        ));
        jScrollPane5.setViewportView(tblLSGiaoDich);

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1085, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Danh sách", jPanel6);

        org.jdesktop.layout.GroupLayout jPanel7Layout = new org.jdesktop.layout.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 1097, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 497, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Câp nhât", jPanel7);

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel22.setText("Lich Su giao dich");

        org.jdesktop.layout.GroupLayout pnl_transactionHistoryLayout = new org.jdesktop.layout.GroupLayout(pnl_transactionHistory);
        pnl_transactionHistory.setLayout(pnl_transactionHistoryLayout);
        pnl_transactionHistoryLayout.setHorizontalGroup(
            pnl_transactionHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, pnl_transactionHistoryLayout.createSequentialGroup()
                .add(22, 22, 22)
                .add(pnl_transactionHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jTabbedPane3)
                    .add(pnl_transactionHistoryLayout.createSequentialGroup()
                        .add(jLabel22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 303, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(21, 21, 21))
        );
        pnl_transactionHistoryLayout.setVerticalGroup(
            pnl_transactionHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnl_transactionHistoryLayout.createSequentialGroup()
                .add(21, 21, 21)
                .add(pnl_transactionHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jLabel22, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .add(jButton3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(66, 66, 66)
                .add(jTabbedPane3)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab4", pnl_transactionHistory);

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel21.setText("Lich Su Nhap Hang");

        tblLSNhapHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã PN", "Mã SP", "Tên SP", "Sô luong", "Ngày nhâp", "Chi Nhanh", "Quan Li CN"
            }
        ));
        jScrollPane4.setViewportView(tblLSNhapHang);

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 427, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Danh Sach", jPanel4);

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 1115, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 423, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Cap Nhat", jPanel5);

        jButton2.setBackground(new java.awt.Color(102, 204, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setText("Export");

        org.jdesktop.layout.GroupLayout pnl_enteringHistoryLayout = new org.jdesktop.layout.GroupLayout(pnl_enteringHistory);
        pnl_enteringHistory.setLayout(pnl_enteringHistoryLayout);
        pnl_enteringHistoryLayout.setHorizontalGroup(
            pnl_enteringHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, pnl_enteringHistoryLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jLabel21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 303, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(307, 307, 307)
                .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(14, 14, 14))
            .add(pnl_enteringHistoryLayout.createSequentialGroup()
                .add(19, 19, 19)
                .add(jTabbedPane2)
                .addContainerGap())
        );
        pnl_enteringHistoryLayout.setVerticalGroup(
            pnl_enteringHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, pnl_enteringHistoryLayout.createSequentialGroup()
                .add(51, 51, 51)
                .add(pnl_enteringHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 99, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jTabbedPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 458, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab5", pnl_enteringHistory);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel19.setText("Lịch Sử Sữa Chữa Và Bảo Hành");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng 2/2024", "Tháng 3/2024", "Tháng 4/2024", "Tháng 5/2024" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Export");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mới Nhất" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setText("<");

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setText(">");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        lblbanghi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblbanghi.setText("1 of 100");

        tblsuachua.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Bảo Hành", "Mã Xe", "Tên Xe", "Mã Khách Hàng", "Tên Khách Hàng", "Ngày Bảo Hành", "Mô Tả Lỗi ", "Giải Pháp"
            }
        ));
        jScrollPane2.setViewportView(tblsuachua);

        org.jdesktop.layout.GroupLayout pnl_repairingHistoryLayout = new org.jdesktop.layout.GroupLayout(pnl_repairingHistory);
        pnl_repairingHistory.setLayout(pnl_repairingHistoryLayout);
        pnl_repairingHistoryLayout.setHorizontalGroup(
            pnl_repairingHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnl_repairingHistoryLayout.createSequentialGroup()
                .addContainerGap()
                .add(pnl_repairingHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, pnl_repairingHistoryLayout.createSequentialGroup()
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1115, Short.MAX_VALUE)
                        .add(19, 19, 19))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, pnl_repairingHistoryLayout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(pnl_repairingHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, pnl_repairingHistoryLayout.createSequentialGroup()
                                .add(jButton4)
                                .add(27, 27, 27)
                                .add(lblbanghi, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(jButton5)
                                .add(536, 536, 536))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, pnl_repairingHistoryLayout.createSequentialGroup()
                                .add(pnl_repairingHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(pnl_repairingHistoryLayout.createSequentialGroup()
                                        .add(jComboBox2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 160, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(27, 27, 27)
                                        .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 160, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(pnl_repairingHistoryLayout.createSequentialGroup()
                                        .add(jLabel19)
                                        .add(253, 253, 253)
                                        .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 138, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .add(47, 47, 47))))))
        );
        pnl_repairingHistoryLayout.setVerticalGroup(
            pnl_repairingHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnl_repairingHistoryLayout.createSequentialGroup()
                .add(pnl_repairingHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnl_repairingHistoryLayout.createSequentialGroup()
                        .addContainerGap(45, Short.MAX_VALUE)
                        .add(jLabel19)
                        .add(31, 31, 31))
                    .add(pnl_repairingHistoryLayout.createSequentialGroup()
                        .add(17, 17, 17)
                        .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(pnl_repairingHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnl_repairingHistoryLayout.createSequentialGroup()
                        .add(108, 108, 108)
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 380, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(pnl_repairingHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jButton5)
                            .add(lblbanghi, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jButton4)))
                    .add(pnl_repairingHistoryLayout.createSequentialGroup()
                        .add(19, 19, 19)
                        .add(pnl_repairingHistoryLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jComboBox2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(25, 25, 25))
        );

        jTabbedPane1.addTab("tab6", pnl_repairingHistory);

        btnThoat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnDoiChiNhanh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDoiChiNhanh.setText("Đổi Chi Nhánh");
        btnDoiChiNhanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiChiNhanhActionPerformed(evt);
            }
        });

        lbChiNhanh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbChiNhanh.setText("Chi nhánh 1");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setText("Chi Nhánh Hiện Tại: ");

        tblChiNhanh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChiNhanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiNhanhMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblChiNhanh);

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel29.setText("Quản Lý Chi nhánh");
        jLabel29.setFocusTraversalPolicyProvider(true);

        txtMa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel30.setText("Mã Chi nhánh");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel31.setText("Tên Chi nhánh");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel32.setText("Địa Chỉ");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel33.setText("SDT");

        txtTen.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        txtSDT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setEnabled(false);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnMoi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnMoi.setText("Làm Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setEnabled(false);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel13Layout = new org.jdesktop.layout.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel13Layout.createSequentialGroup()
                        .add(81, 81, 81)
                        .add(jLabel33)
                        .add(18, 18, 18)
                        .add(jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtSDT)
                            .add(jPanel13Layout.createSequentialGroup()
                                .add(txtDiaChi, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 245, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(0, 47, Short.MAX_VALUE))))
                    .add(jPanel13Layout.createSequentialGroup()
                        .add(btnThem)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnSua)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnXoa)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(btnMoi)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(jPanel13Layout.createSequentialGroup()
                        .add(jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel30)
                            .add(jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jLabel31)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel32)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtTen)
                            .add(txtMa))))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel13Layout.createSequentialGroup()
                .add(25, 25, 25)
                .add(jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel30)
                    .add(txtMa, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(41, 41, 41)
                .add(jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel31)
                    .add(txtTen, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(48, 48, 48)
                .add(jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel32)
                    .add(txtDiaChi, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(49, 49, 49)
                .add(jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel33)
                    .add(txtSDT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 69, Short.MAX_VALUE)
                .add(jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnThem)
                    .add(btnSua)
                    .add(btnMoi)
                    .add(btnXoa))
                .add(23, 23, 23))
        );

        org.jdesktop.layout.GroupLayout pnl_branchLayout = new org.jdesktop.layout.GroupLayout(pnl_branch);
        pnl_branch.setLayout(pnl_branchLayout);
        pnl_branchLayout.setHorizontalGroup(
            pnl_branchLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnl_branchLayout.createSequentialGroup()
                .add(474, 474, 474)
                .add(jLabel29)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, pnl_branchLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jScrollPane8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 401, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(80, 80, 80)
                .add(jPanel13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(101, 101, 101))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, pnl_branchLayout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 196, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lbChiNhanh)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 486, Short.MAX_VALUE)
                .add(btnDoiChiNhanh)
                .add(70, 70, 70)
                .add(btnThoat)
                .add(38, 38, 38))
        );
        pnl_branchLayout.setVerticalGroup(
            pnl_branchLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, pnl_branchLayout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .add(jLabel29)
                .add(27, 27, 27)
                .add(pnl_branchLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnl_branchLayout.createSequentialGroup()
                        .add(19, 19, 19)
                        .add(jScrollPane8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 370, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(27, 27, 27)
                .add(pnl_branchLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnDoiChiNhanh)
                    .add(btnThoat)
                    .add(jLabel28)
                    .add(lbChiNhanh))
                .add(72, 72, 72))
        );

        jTabbedPane1.addTab("tab7", pnl_branch);

        lblnext.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblnext.setText(">");
        lblnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnextActionPerformed(evt);
            }
        });

        lblbanghi1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblbanghi1.setText("1 of 100");

        btnback1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnback1.setText("<");
        btnback1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnback1ActionPerformed(evt);
            }
        });

        tblnhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Nhân Viên", "Tên Nhân Viên", "Chức Vụ", "Giới Tính", "Năm Sinh", "SDT", "Email", "Mã Chi Nhánh"
            }
        ));
        tblnhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblnhanvienMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblnhanvien);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        Themnvmoi.setBackground(new java.awt.Color(0, 51, 255));
        Themnvmoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Themnvmoi.setForeground(new java.awt.Color(255, 255, 255));
        Themnvmoi.setText("Thêm nhân viên mới");
        Themnvmoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemnvmoiActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel20.setText("Quản Lý Nhân Viên");

        org.jdesktop.layout.GroupLayout pnl_employeeLayout = new org.jdesktop.layout.GroupLayout(pnl_employee);
        pnl_employee.setLayout(pnl_employeeLayout);
        pnl_employeeLayout.setHorizontalGroup(
            pnl_employeeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnl_employeeLayout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .add(pnl_employeeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, pnl_employeeLayout.createSequentialGroup()
                        .add(pnl_employeeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(pnl_employeeLayout.createSequentialGroup()
                                .add(jLabel20)
                                .add(274, 274, 274)
                                .add(Themnvmoi))
                            .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(23, 23, 23))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, pnl_employeeLayout.createSequentialGroup()
                        .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 1000, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(52, 52, 52))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, pnl_employeeLayout.createSequentialGroup()
                        .add(btnback1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lblbanghi1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lblnext)
                        .add(495, 495, 495))))
        );
        pnl_employeeLayout.setVerticalGroup(
            pnl_employeeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnl_employeeLayout.createSequentialGroup()
                .add(pnl_employeeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnl_employeeLayout.createSequentialGroup()
                        .add(17, 17, 17)
                        .add(Themnvmoi, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnl_employeeLayout.createSequentialGroup()
                        .add(29, 29, 29)
                        .add(jLabel20)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(31, 31, 31)
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 380, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 97, Short.MAX_VALUE)
                .add(pnl_employeeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblbanghi1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnl_employeeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(btnback1)
                        .add(lblnext)))
                .add(36, 36, 36))
        );

        jTabbedPane1.addTab("tab8", pnl_employee);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel23.setText("Quản Lý Xe VINFAST");

        btnThemSanPham.setText("Them san pham moi");
        btnThemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSanPhamActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cboLoaiXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Loai Xe -", "Oto dien", "Oto xang", "Xe may dien" }));
        cboLoaiXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiXeActionPerformed(evt);
            }
        });

        cboMauXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Mau Xe -" }));
        cboMauXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMauXeActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        TempCarCard.setBackground(new java.awt.Color(255, 255, 255));
        TempCarCard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 2));

        icoHinh.setBackground(new java.awt.Color(255, 204, 204));
        icoHinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icoHinh.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTenSP.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtTenSP.setText("VF9 - PLUS");

        txtGiaSP.setText("Gia: 2.290.000 (VND)");

        txtMoTa.setEditable(false);
        txtMoTa.setBackground(new java.awt.Color(255, 255, 255));
        txtMoTa.setColumns(20);
        txtMoTa.setLineWrap(true);
        txtMoTa.setRows(5);
        txtMoTa.setText("Công suất tối đa: 300 kW - 402 hp\nThời gian tăng tốc (từ 0 - 100 km/h): 6,8 giây\nQuãng đường di chuyển: 626 km/lần sạc đầy\nSố túi khí: 11\nSố ghế ngồi: 7 (tùy chọn 6)\nBảo hành: 10 năm hoặc 200.000 km\nMức tiêu thụ điện năng: 205 Wh/km");
        txtMoTa.setWrapStyleWord(true);
        txtMoTa.setBorder(null);

        btnChinhSua.setText("Chinh sua thong tin");
        btnChinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSuaActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout TempCarCardLayout = new org.jdesktop.layout.GroupLayout(TempCarCard);
        TempCarCard.setLayout(TempCarCardLayout);
        TempCarCardLayout.setHorizontalGroup(
            TempCarCardLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TempCarCardLayout.createSequentialGroup()
                .addContainerGap()
                .add(icoHinh, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(TempCarCardLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtTenSP)
                    .add(txtGiaSP))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, TempCarCardLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(txtMoTa, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 321, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnChinhSua)
                .addContainerGap())
        );
        TempCarCardLayout.setVerticalGroup(
            TempCarCardLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, TempCarCardLayout.createSequentialGroup()
                .addContainerGap()
                .add(TempCarCardLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(icoHinh, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(TempCarCardLayout.createSequentialGroup()
                        .add(txtTenSP)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtGiaSP)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(TempCarCardLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(txtMoTa, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnChinhSua))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        TempCarCard1.setBackground(new java.awt.Color(255, 255, 255));
        TempCarCard1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 2));

        icoHinh1.setBackground(new java.awt.Color(255, 204, 204));
        icoHinh1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icoHinh1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTenSP1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtTenSP1.setText("VF9 - PLUS");

        txtGiaSP1.setText("Gia: 2.290.000 (VND)");

        txtMoTa1.setEditable(false);
        txtMoTa1.setBackground(new java.awt.Color(255, 255, 255));
        txtMoTa1.setColumns(20);
        txtMoTa1.setLineWrap(true);
        txtMoTa1.setRows(5);
        txtMoTa1.setText("Công suất tối đa: 300 kW - 402 hp\nThời gian tăng tốc (từ 0 - 100 km/h): 6,8 giây\nQuãng đường di chuyển: 626 km/lần sạc đầy\nSố túi khí: 11\nSố ghế ngồi: 7 (tùy chọn 6)\nBảo hành: 10 năm hoặc 200.000 km\nMức tiêu thụ điện năng: 205 Wh/km");
        txtMoTa1.setWrapStyleWord(true);
        txtMoTa1.setBorder(null);

        btnChinhSua1.setText("Chinh sua thong tin");
        btnChinhSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSua1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout TempCarCard1Layout = new org.jdesktop.layout.GroupLayout(TempCarCard1);
        TempCarCard1.setLayout(TempCarCard1Layout);
        TempCarCard1Layout.setHorizontalGroup(
            TempCarCard1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TempCarCard1Layout.createSequentialGroup()
                .addContainerGap()
                .add(icoHinh1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(TempCarCard1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtTenSP1)
                    .add(txtGiaSP1))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, TempCarCard1Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(txtMoTa1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 321, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnChinhSua1)
                .addContainerGap())
        );
        TempCarCard1Layout.setVerticalGroup(
            TempCarCard1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, TempCarCard1Layout.createSequentialGroup()
                .addContainerGap()
                .add(TempCarCard1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(icoHinh1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(TempCarCard1Layout.createSequentialGroup()
                        .add(txtTenSP1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtGiaSP1)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(TempCarCard1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(txtMoTa1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnChinhSua1))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        TempCarCard2.setBackground(new java.awt.Color(255, 255, 255));
        TempCarCard2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 2));

        icoHinh2.setBackground(new java.awt.Color(255, 204, 204));
        icoHinh2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icoHinh2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTenSP2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtTenSP2.setText("VF9 - PLUS");

        txtGiaSP2.setText("Gia: 2.290.000 (VND)");

        txtMoTa2.setEditable(false);
        txtMoTa2.setBackground(new java.awt.Color(255, 255, 255));
        txtMoTa2.setColumns(20);
        txtMoTa2.setLineWrap(true);
        txtMoTa2.setRows(5);
        txtMoTa2.setText("Công suất tối đa: 300 kW - 402 hp\nThời gian tăng tốc (từ 0 - 100 km/h): 6,8 giây\nQuãng đường di chuyển: 626 km/lần sạc đầy\nSố túi khí: 11\nSố ghế ngồi: 7 (tùy chọn 6)\nBảo hành: 10 năm hoặc 200.000 km\nMức tiêu thụ điện năng: 205 Wh/km");
        txtMoTa2.setWrapStyleWord(true);
        txtMoTa2.setBorder(null);

        btnChinhSua2.setText("Chinh sua thong tin");
        btnChinhSua2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSua2ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout TempCarCard2Layout = new org.jdesktop.layout.GroupLayout(TempCarCard2);
        TempCarCard2.setLayout(TempCarCard2Layout);
        TempCarCard2Layout.setHorizontalGroup(
            TempCarCard2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TempCarCard2Layout.createSequentialGroup()
                .addContainerGap()
                .add(icoHinh2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(TempCarCard2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtTenSP2)
                    .add(txtGiaSP2))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, TempCarCard2Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(txtMoTa2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 321, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnChinhSua2)
                .addContainerGap())
        );
        TempCarCard2Layout.setVerticalGroup(
            TempCarCard2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, TempCarCard2Layout.createSequentialGroup()
                .addContainerGap()
                .add(TempCarCard2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(icoHinh2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(TempCarCard2Layout.createSequentialGroup()
                        .add(txtTenSP2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtGiaSP2)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(TempCarCard2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(txtMoTa2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnChinhSua2))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        TempCarCard3.setBackground(new java.awt.Color(255, 255, 255));
        TempCarCard3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230), 2));

        icoHinh3.setBackground(new java.awt.Color(255, 204, 204));
        icoHinh3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icoHinh3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTenSP3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtTenSP3.setText("VF9 - PLUS");

        txtGiaSP3.setText("Gia: 2.290.000 (VND)");

        txtMoTa3.setEditable(false);
        txtMoTa3.setBackground(new java.awt.Color(255, 255, 255));
        txtMoTa3.setColumns(20);
        txtMoTa3.setLineWrap(true);
        txtMoTa3.setRows(5);
        txtMoTa3.setText("Công suất tối đa: 300 kW - 402 hp\nThời gian tăng tốc (từ 0 - 100 km/h): 6,8 giây\nQuãng đường di chuyển: 626 km/lần sạc đầy\nSố túi khí: 11\nSố ghế ngồi: 7 (tùy chọn 6)\nBảo hành: 10 năm hoặc 200.000 km\nMức tiêu thụ điện năng: 205 Wh/km");
        txtMoTa3.setWrapStyleWord(true);
        txtMoTa3.setBorder(null);

        btnChinhSua3.setText("Chinh sua thong tin");
        btnChinhSua3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSua3ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout TempCarCard3Layout = new org.jdesktop.layout.GroupLayout(TempCarCard3);
        TempCarCard3.setLayout(TempCarCard3Layout);
        TempCarCard3Layout.setHorizontalGroup(
            TempCarCard3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(TempCarCard3Layout.createSequentialGroup()
                .addContainerGap()
                .add(icoHinh3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(TempCarCard3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtTenSP3)
                    .add(txtGiaSP3))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, TempCarCard3Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(txtMoTa3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 321, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnChinhSua3)
                .addContainerGap())
        );
        TempCarCard3Layout.setVerticalGroup(
            TempCarCard3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, TempCarCard3Layout.createSequentialGroup()
                .addContainerGap()
                .add(TempCarCard3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(icoHinh3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(TempCarCard3Layout.createSequentialGroup()
                        .add(txtTenSP3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtGiaSP3)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(TempCarCard3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(txtMoTa3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnChinhSua3))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout SectionLayout = new org.jdesktop.layout.GroupLayout(Section);
        Section.setLayout(SectionLayout);
        SectionLayout.setHorizontalGroup(
            SectionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(SectionLayout.createSequentialGroup()
                .addContainerGap()
                .add(SectionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(SectionLayout.createSequentialGroup()
                        .add(TempCarCard, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(TempCarCard2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(SectionLayout.createSequentialGroup()
                        .add(TempCarCard1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(TempCarCard3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SectionLayout.setVerticalGroup(
            SectionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(SectionLayout.createSequentialGroup()
                .addContainerGap()
                .add(SectionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(TempCarCard, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(TempCarCard2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(SectionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(TempCarCard1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(TempCarCard3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel8Layout = new org.jdesktop.layout.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(Section, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel8Layout.createSequentialGroup()
                        .add(cboLoaiXe, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 170, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(cboMauXe, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 170, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 587, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cboLoaiXe, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cboMauXe, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(Section, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout pnl_carListLayout = new org.jdesktop.layout.GroupLayout(pnl_carList);
        pnl_carList.setLayout(pnl_carListLayout);
        pnl_carListLayout.setHorizontalGroup(
            pnl_carListLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnl_carListLayout.createSequentialGroup()
                .add(74, 74, 74)
                .add(pnl_carListLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, pnl_carListLayout.createSequentialGroup()
                        .add(19, 749, Short.MAX_VALUE)
                        .add(btnThemSanPham)
                        .add(173, 173, 173)))
                .addContainerGap())
            .add(pnl_carListLayout.createSequentialGroup()
                .add(383, 383, 383)
                .add(jLabel23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 243, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_carListLayout.setVerticalGroup(
            pnl_carListLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, pnl_carListLayout.createSequentialGroup()
                .add(17, 17, 17)
                .add(jLabel23)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 19, Short.MAX_VALUE)
                .add(btnThemSanPham)
                .add(21, 21, 21)
                .add(jPanel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(49, 49, 49))
        );

        jTabbedPane1.addTab("tab10", pnl_carList);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtTimKiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiem1ActionPerformed(evt);
            }
        });

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jButton8.setText("<");
        jPanel12.add(jButton8);

        jLabel27.setText("1 tren 100");
        jPanel12.add(jLabel27);

        jButton9.setText(">");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton9);

        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tblDichVu);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel26.setText("Quan Ly Dich Vu & Bao Hanh");

        btnThemSanPham1.setText("Them Dich Vu moi");
        btnThemSanPham1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSanPham1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel11Layout = new org.jdesktop.layout.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel11Layout.createSequentialGroup()
                        .add(jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1116, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel11Layout.createSequentialGroup()
                                .add(jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(jPanel11Layout.createSequentialGroup()
                                        .add(0, 0, Short.MAX_VALUE)
                                        .add(jLabel26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 360, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(242, 242, 242)
                                        .add(btnThemSanPham1))
                                    .add(txtTimKiem1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1108, Short.MAX_VALUE))
                                .add(8, 8, 8)))
                        .addContainerGap())
                    .add(jPanel11Layout.createSequentialGroup()
                        .add(jPanel12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(86, 86, 86))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel11Layout.createSequentialGroup()
                .add(24, 24, 24)
                .add(jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel26)
                    .add(btnThemSanPham1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 31, Short.MAX_VALUE)
                .add(txtTimKiem1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(27, 27, 27)
                .add(jScrollPane7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 386, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(35, 35, 35))
        );

        org.jdesktop.layout.GroupLayout pnl_servicesLayout = new org.jdesktop.layout.GroupLayout(pnl_services);
        pnl_services.setLayout(pnl_servicesLayout);
        pnl_servicesLayout.setHorizontalGroup(
            pnl_servicesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnl_servicesLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel11, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_servicesLayout.setVerticalGroup(
            pnl_servicesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnl_servicesLayout.createSequentialGroup()
                .add(61, 61, 61)
                .add(jPanel11, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab11", pnl_services);

        org.jdesktop.layout.GroupLayout pnl_timeKeepingLayout = new org.jdesktop.layout.GroupLayout(pnl_timeKeeping);
        pnl_timeKeeping.setLayout(pnl_timeKeepingLayout);
        pnl_timeKeepingLayout.setHorizontalGroup(
            pnl_timeKeepingLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 1140, Short.MAX_VALUE)
        );
        pnl_timeKeepingLayout.setVerticalGroup(
            pnl_timeKeepingLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 675, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab12", pnl_timeKeeping);

        org.jdesktop.layout.GroupLayout pnl_settingLayout = new org.jdesktop.layout.GroupLayout(pnl_setting);
        pnl_setting.setLayout(pnl_settingLayout);
        pnl_settingLayout.setHorizontalGroup(
            pnl_settingLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 1140, Short.MAX_VALUE)
        );
        pnl_settingLayout.setVerticalGroup(
            pnl_settingLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 675, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab13", pnl_setting);

        org.jdesktop.layout.GroupLayout pnl_contactLayout = new org.jdesktop.layout.GroupLayout(pnl_contact);
        pnl_contact.setLayout(pnl_contactLayout);
        pnl_contactLayout.setHorizontalGroup(
            pnl_contactLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 1140, Short.MAX_VALUE)
        );
        pnl_contactLayout.setVerticalGroup(
            pnl_contactLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 675, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab14", pnl_contact);

        org.jdesktop.layout.GroupLayout jPanel18Layout = new org.jdesktop.layout.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 1140, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 675, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab15", jPanel18);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel18.setText("Quản Lý Khách Hàng");

        cbbkhuvuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn Khu Vực" }));
        cbbkhuvuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbkhuvucActionPerformed(evt);
            }
        });

        tblkhachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Khách Hàng", "Tên Khách Hàng", "Năm Sinh", "Địa Chỉ", "Số Điện Thoại", "Email", "Lịch Sử Giao Dịch"
            }
        ));
        jScrollPane1.setViewportView(tblkhachhang);

        jTextField1.setToolTipText("");

        btnnext.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnnext.setText(">");

        lblBangGhi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBangGhi.setText("1 of 100");

        btnback.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnback.setText("<");

        org.jdesktop.layout.GroupLayout pnl_customerLayout = new org.jdesktop.layout.GroupLayout(pnl_customer);
        pnl_customer.setLayout(pnl_customerLayout);
        pnl_customerLayout.setHorizontalGroup(
            pnl_customerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, pnl_customerLayout.createSequentialGroup()
                .add(0, 0, Short.MAX_VALUE)
                .add(btnback)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lblBangGhi, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnnext)
                .add(649, 649, 649))
            .add(pnl_customerLayout.createSequentialGroup()
                .add(pnl_customerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnl_customerLayout.createSequentialGroup()
                        .add(45, 45, 45)
                        .add(cbbkhuvuc, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 160, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(308, 308, 308)
                        .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 302, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnl_customerLayout.createSequentialGroup()
                        .add(446, 446, 446)
                        .add(jLabel18))
                    .add(pnl_customerLayout.createSequentialGroup()
                        .add(25, 25, 25)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 1072, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        pnl_customerLayout.setVerticalGroup(
            pnl_customerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnl_customerLayout.createSequentialGroup()
                .add(22, 22, 22)
                .add(jLabel18)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 50, Short.MAX_VALUE)
                .add(pnl_customerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cbbkhuvuc, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(48, 48, 48)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 380, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(40, 40, 40)
                .add(pnl_customerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblBangGhi, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnback)
                    .add(btnnext))
                .add(32, 32, 32))
        );

        jTabbedPane1.addTab("tab9", pnl_customer);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 1140, 710));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(7);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(14);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(8);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(9);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(11);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(12);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(13);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void cbbkhuvucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbkhuvucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbkhuvucActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void lblnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnextActionPerformed

    }//GEN-LAST:event_lblnextActionPerformed

    private void btnback1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnback1ActionPerformed

    }//GEN-LAST:event_btnback1ActionPerformed

    private void tblnhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblnhanvienMouseClicked

    }//GEN-LAST:event_tblnhanvienMouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void ThemnvmoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemnvmoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ThemnvmoiActionPerformed

    private void btnThemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSanPhamActionPerformed
//        this.openDialog();
    }//GEN-LAST:event_btnThemSanPhamActionPerformed

    private void cboLoaiXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiXeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboLoaiXeActionPerformed

    private void cboMauXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMauXeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMauXeActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void btnChinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChinhSuaActionPerformed

    private void btnChinhSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSua1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChinhSua1ActionPerformed

    private void btnChinhSua2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSua2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChinhSua2ActionPerformed

    private void btnChinhSua3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSua3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChinhSua3ActionPerformed

    private void cboChonThoiGianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboChonThoiGianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboChonThoiGianActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void cboChonThoiGian1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboChonThoiGian1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboChonThoiGian1ActionPerformed

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
//        this.openDialog();
    }//GEN-LAST:event_btnActionPerformed

    private void btnThemSanPham1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSanPham1ActionPerformed
//        this.openDialog();
    }//GEN-LAST:event_btnThemSanPham1ActionPerformed

    private void txtTimKiem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiem1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnDoiChiNhanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiChiNhanhActionPerformed
//        if(viTriChon==-1)
//        {
//            JOptionPane.showMessageDialog(rootPane, "bạn chưa chọn chi nhánh để đổi");
//        }
//        else
//        {
//            if(JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn đổi sang chi nhánh này")==JOptionPane.OK_OPTION)
//            {
//                DAO.ChiNhanh cn=dscn.get(viTriChon);
//                Role.chiNhanh=cn;
//                JOptionPane.showMessageDialog(rootPane, "Đổi chi nhánh thành công");
//                LoadDuLieu();
//            }
//        }
    }//GEN-LAST:event_btnDoiChiNhanhActionPerformed

    private void tblChiNhanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiNhanhMouseClicked
//        if(evt.getClickCount()==1)
//        {
//            viTriChon=tblChiNhanh.getSelectedRow();
//            LayPhanTuTaiViTri(viTriChon);
//        }
    }//GEN-LAST:event_tblChiNhanhMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        KiemTraDuLieu();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
//        if(viTriChon==-1)
//        {
//            JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn dữ liệu để sửa");
//            btnThem.setEnabled(false);
//        }
//        else
//        {
//            SuaDuLieu();
//        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        LamMoi();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
//        if(viTriChon==-1)
//        {
//            JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn chi nhánh để xóa");
//        }
//        else
//        {
//            if(JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc muốn xóa chi nhánh này")==JOptionPane.OK_OPTION)
//            {
//                XoaDuLieu();
//            }
//        }

    }//GEN-LAST:event_btnXoaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Section;
    private javax.swing.JPanel TempCarCard;
    private javax.swing.JPanel TempCarCard1;
    private javax.swing.JPanel TempCarCard2;
    private javax.swing.JPanel TempCarCard3;
    private javax.swing.JButton Themnvmoi;
    private javax.swing.JButton btn;
    private javax.swing.JButton btnChinhSua;
    private javax.swing.JButton btnChinhSua1;
    private javax.swing.JButton btnChinhSua2;
    private javax.swing.JButton btnChinhSua3;
    private javax.swing.JButton btnDoiChiNhanh;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemSanPham;
    private javax.swing.JButton btnThemSanPham1;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnback1;
    private javax.swing.JButton btnnext;
    private javax.swing.JComboBox<String> cbbkhuvuc;
    private javax.swing.JComboBox<String> cboChonThoiGian;
    private javax.swing.JComboBox<String> cboChonThoiGian1;
    private javax.swing.JComboBox<String> cboLoaiXe;
    private javax.swing.JComboBox<String> cboMauXe;
    private raven.chart.CurveLineChart chart;
    private raven.chart.CurveLineChart chart1;
    private javax.swing.JLabel icoHinh;
    private javax.swing.JLabel icoHinh1;
    private javax.swing.JLabel icoHinh2;
    private javax.swing.JLabel icoHinh3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lbChiNhanh;
    private javax.swing.JLabel lblBangGhi;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lblbanghi;
    private javax.swing.JLabel lblbanghi1;
    private javax.swing.JButton lblnext;
    private javax.swing.JPanel menu_branch;
    private javax.swing.JPanel menu_calender;
    private javax.swing.JPanel menu_carList;
    private javax.swing.JPanel menu_contact;
    private javax.swing.JPanel menu_customer;
    private javax.swing.JPanel menu_dashboard;
    private javax.swing.JPanel menu_employee;
    private javax.swing.JPanel menu_enteringHistory;
    private javax.swing.JPanel menu_repairingHistory;
    private javax.swing.JPanel menu_services;
    private javax.swing.JPanel menu_setting;
    private javax.swing.JPanel menu_statictis;
    private javax.swing.JPanel menu_timeKeeping;
    private javax.swing.JPanel menu_transactionHistory;
    private raven.panel.PanelShadow panelShadow1;
    private raven.panel.PanelShadow panelShadow2;
    private javax.swing.JPanel pnl_branch;
    private javax.swing.JPanel pnl_calender;
    private javax.swing.JPanel pnl_carList;
    private javax.swing.JPanel pnl_contact;
    private javax.swing.JPanel pnl_customer;
    private javax.swing.JPanel pnl_dashboard;
    private javax.swing.JPanel pnl_employee;
    private javax.swing.JPanel pnl_enteringHistory;
    private javax.swing.JPanel pnl_repairingHistory;
    private javax.swing.JPanel pnl_services;
    private javax.swing.JPanel pnl_setting;
    private javax.swing.JPanel pnl_statictis;
    private javax.swing.JPanel pnl_timeKeeping;
    private javax.swing.JPanel pnl_transactionHistory;
    private javax.swing.JTable tblChiNhanh;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTable tblLSGiaoDich;
    private javax.swing.JTable tblLSNhapHang;
    private javax.swing.JTable tblLich;
    private javax.swing.JTable tblkhachhang;
    private javax.swing.JTable tblnhanvien;
    private javax.swing.JTable tblsuachua;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JLabel txtGiaSP;
    private javax.swing.JLabel txtGiaSP1;
    private javax.swing.JLabel txtGiaSP2;
    private javax.swing.JLabel txtGiaSP3;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextArea txtMoTa1;
    private javax.swing.JTextArea txtMoTa2;
    private javax.swing.JTextArea txtMoTa3;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JLabel txtTenSP;
    private javax.swing.JLabel txtTenSP1;
    private javax.swing.JLabel txtTenSP2;
    private javax.swing.JLabel txtTenSP3;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiem1;
    // End of variables declaration//GEN-END:variables
}
