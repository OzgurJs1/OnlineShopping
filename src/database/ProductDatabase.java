package database;

import connection.MyConnection;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ProductDatabase {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    
    // get product table max row
    public int getMaxRow() {
        int row = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select max(pID) from product");
            while (rs.next()) {
                row = rs.getInt(1);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CategoryDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return row + 1;
    }
    
    public int countCategories(){
        int sum = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("Select count(*) as 'Sum' from category");
            if (rs.next()) {
                sum = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return sum;
    }
    public String[] getCat(){
        String[] categories = new String[countCategories()];
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from category");
            int i = 0;
            while(rs.next()){
                categories[i] = rs.getString(2);
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return categories;
    }
    public boolean isProCatExists(String pro, String cat){
        try {
            ps = con.prepareStatement("select * from product where pName = ? and cName = ?");
            ps.setString(1, pro);
            ps.setString(2, cat);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean isIDExists(int id){
        try {
            ps = con.prepareStatement("select * from product where pID = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void insert(int id, String pname, String cat, int qty, double price){
        String sql = "insert into product values(?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setString(2, pname);
            ps.setString(3, cat);
            ps.setInt(4, qty);
            ps.setDouble(5, price);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Product added successfully.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public void update(int id, String pName, String cName, int qty, double price){
        String sql = "update product set pName = ?, cName = ?, pQty = ?, pPrice = ? where pID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pName);
            ps.setString(2, cName);
            ps.setInt(3, qty);
            ps.setDouble(4, price);
            ps.setInt(5, id);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Product successfully updated.");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ProductDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    
    public void getProductsVal(JTable table, String Search){
        String sql = "select * from product where concat(pID, pName, cName) like ? order by pID desc";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + Search + "%");
            rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object [] row;
            while(rs.next()){
                row = new Object[5];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getInt(4);
                row[4] = rs.getDouble(5);
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    //delete category
    public void delete(int id){
        int x = JOptionPane.showConfirmDialog(null, "Are you sure to delete this category?", "Delete Product", 2);
        if (x == JOptionPane.OK_OPTION) {
            try {
                ps = con.prepareStatement("delete from product where pID = ?");
                ps.setInt(1, id);
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Product Deleted.");
                }
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ProductDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }
}
