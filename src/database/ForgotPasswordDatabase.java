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
import user.ForgotPassword;


public class ForgotPasswordDatabase {
    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    
    public boolean isEmailExist(String email){
        try {
            ps = con.prepareStatement("select * from user where uEmail = ? ");
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                ForgotPassword.jTextField2.setText(rs.getString(6));
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Email address doesn't exist.","Warning", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ForgotPasswordDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     public boolean getAnswer(String email, String newAnswer){
        try {
            ps = con.prepareStatement("select * from user where uEmail = ? ");
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                String oldAnswer = rs.getString(7);
                if (newAnswer.equals(oldAnswer)) {
                    return true;
                }else{
                    JOptionPane.showMessageDialog(null, "Security answer didn't match", "Warning",2);
                }
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Email address doesn't exist.","Warning", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ForgotPasswordDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
     // set new password
     public void setPassword(String email, String password){
         String sql = "update user set uPassword = ? where uEmail = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, email);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Password successfully updated.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ForgotPasswordDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
}
