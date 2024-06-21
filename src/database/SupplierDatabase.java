package database;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SupplierDatabase {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    //get Supplier table max row
    public int getMaxRow() {
        int row = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select max(sID) from supplier");
            while (rs.next()) {
                row = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row + 1;
    }

    // check supplier mail already exists
    public boolean isEmailExists(String email) {
        try {
            ps = con.prepareStatement("select * from supplier where sEmail = ? ");
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //check supplier phone already exists
    public boolean isPhoneExists(String phone) {
        try {
            ps = con.prepareStatement("select * from supplier where sPhone = ? ");
            ps.setString(1, phone);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    
    // check supplier username already exists
    public boolean isUsernameExists(String name) {
        try {
            ps = con.prepareStatement("select * from supplier where sName = ? ");
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public void insert(int id, String username, String email, String password, String phone, String address) {
        String sql = "insert into supplier values(?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, username);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setString(5, phone);
            ps.setString(6, address);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "User Added successfully.");
            }    
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getSupplierVal(JTable table, String search){
        String sql = "select * from supplier where concat(sID,sName,sEmail) like ? order by sID asc";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object [] row;
            while(rs.next()){
                row = new Object[6];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(int id, String username, String email, String password, String phone, String address) {
        String sql = "update supplier set sName = ?, sEmail = ?, sPassword = ?, sPhone = ?, sAddress = ? where sID = ? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, phone);
            ps.setString(5, address);
            ps.setInt(6, id);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Fields successfully updated.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delete(int ID){
      int a = JOptionPane.showConfirmDialog(null, "Are you sure to delete this account?","Delete Account", JOptionPane.OK_CANCEL_OPTION,0);
        if (a == JOptionPane.OK_OPTION) {
          try {
              ps=con.prepareStatement("delete from supplier where sID = ? ");
              ps.setInt(1, ID);
              if (ps.executeUpdate() > 0) {
                  JOptionPane.showMessageDialog(null, "Account deleted.");
              }
          } catch (SQLException ex) {
              Logger.getLogger(SupplierDatabase.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
    }
    
     public int getSupplierID(String email) {
        int ID = 0;
        try {
            ps = con.prepareStatement("select sID from supplier where sEmail = ? ");
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                ID = rs.getInt(1);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ID;
    } 
     
     public String getSupplierName(String email) {
        String supplierName = "";
        try {
            ps = con.prepareStatement("select sName from supplier where sEmail = ? ");
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                supplierName = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return supplierName;
    } 
     
     public String[] getSupplierValue(int id) {
        String[] val = new String[6];
        try {
            ps = con.prepareStatement("select * from supplier where sID = ? ");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                val[0] = rs.getString(1);
                val[1] = rs.getString(2);
                val[2] = rs.getString(3);
                val[3] = rs.getString(4);
                val[4] = rs.getString(5);
                val[5] = rs.getString(6);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return val;
    }
     
     public int countSuppliers(){
         int total = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select count(*) as 'Total' from supplier");
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
     }
     
     public String[] getSuppliers(){
         String[] suppliers = new String[countSuppliers()];
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from supplier");
            int i = 0;
            while(rs.next()){
                suppliers[i] = rs.getString(2);
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
         return suppliers;
     }
}
