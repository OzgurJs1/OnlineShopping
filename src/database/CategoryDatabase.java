package database;

import connection.MyConnection;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CategoryDatabase {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    //get category table max row
    public int getMaxRow() {
        int row = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select max(cID) from category");
            while (rs.next()) {
                row = rs.getInt(1);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CategoryDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row + 1;
    }
    
    public boolean isIDExists(int id){
        try {
            ps = con.prepareStatement("select * from category where cID = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CategoryDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Check category name already exists?
    public boolean isCategoryNameExists(String cName) {
        try {
            ps = con.prepareStatement("select * from category where cName = ? ");
            ps.setString(1, cName);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CategoryDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //insert data into category table
    public void insert(int id, String cName, String description) {
        String sql = "insert into category values(?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, cName);
            ps.setString(3, description);
            
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Category Added successfully.");
            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CategoryDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //update category data
    public void update(int id, String cName, String Description){
        String sql = "update category set cName = ?, cDesc = ? where cID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cName);
            ps.setString(2, Description);
            ps.setInt(3, id);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Category successfully updated.");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CategoryDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // get categories data
    public void getCategoriesValue(JTable table, String search) {
        String sql = "select * from category where concat(cID,cName) like ? order by cID desc";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs.next()) {
                row = new Object[3];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                model.addRow(row);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CategoryDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //delete category
    public void delete(int id){
        int x = JOptionPane.showConfirmDialog(null, "Are you sure to delete this category?", "Delete Category", 2);
        if (x == JOptionPane.OK_OPTION) {
            try {
                ps = con.prepareStatement("delete from category where cID = ?");
                ps.setInt(1, id);
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Category Deleted.");
                }
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(CategoryDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
