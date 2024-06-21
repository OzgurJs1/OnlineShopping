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

/**
 *
 * @author Özgür
 */
public class UserDatabase {
    
    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    
    public int getMaxRow() {
        int row = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select max(uID) from user");
            while (rs.next()) {
                row = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row + 1;
    }

    //check email already exists
    public boolean isEmailExists(String email) {
        try {
            ps = con.prepareStatement("select * from user where uEmail = ? ");
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //check phone number already exists
    public boolean isPhoneExists(String phone) {
        try {
            ps = con.prepareStatement("select * from user where uPhone = ? ");
            ps.setString(1, phone);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void insert(int id, String username, String email, String password, String phone, String seq,
            String answer, String address) {
        String sql = "insert into user values(?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, username);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setString(5, phone);
            ps.setString(6, seq);
            ps.setString(7, answer);
            ps.setString(8, address);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "User Added successfully.");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // update user data 
    public void update(int id, String username, String email, String password, String phone, String seq,
            String answer, String address) {
        String sql = "update user set uName = ?, uEmail = ?, uPassword = ?, uPhone = ?, uSecurityQuestion = ?, uAnswer = ?, uAddress = ? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, phone);
            ps.setString(5, seq);
            ps.setString(6, answer);
            ps.setString(7, address);
            ps.setInt(8, id);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Password successfully updated.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //delete user
    public void delete(int ID){
      int a = JOptionPane.showConfirmDialog(null, "Are you sure to delete this account?","Delete Account", JOptionPane.OK_CANCEL_OPTION,0);
        if (a == JOptionPane.OK_OPTION) {
          try {
              ps=con.prepareStatement("delete from user where uID = ? ");
              ps.setInt(1, ID);
              if (ps.executeUpdate() > 0) {
                  JOptionPane.showMessageDialog(null, "Account deleted.");
              }
          } catch (SQLException ex) {
              Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
    }
    
    public String[] getUserValue(int id) {
        String[] val = new String[8];
        try {
            ps = con.prepareStatement("select * from user where uID = ? ");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                val[0] = rs.getString(1);
                val[1] = rs.getString(2);
                val[2] = rs.getString(3);
                val[3] = rs.getString(4);
                val[4] = rs.getString(5);
                val[5] = rs.getString(6);
                val[6] = rs.getString(7);
                val[7] = rs.getString(8);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return val;
    }
    //get user ID

    public int getUserID(String email) {
        int ID = 0;
        try {
            ps = con.prepareStatement("select uID from user where uEmail = ? ");
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
    public void getUsersVal(JTable table, String search){
        String sql = "select * from user where concat(uID,uName,uEmail) like ? order by uID asc";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object [] row;
            while(rs.next()){
                row = new Object[8];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                row[7] = rs.getString(8);
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
