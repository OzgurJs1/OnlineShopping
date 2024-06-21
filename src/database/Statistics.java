package database;

import admin.AdminDashboard;
import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import supplier.SupplierDashboard;
import user.UserDashboard;

public class Statistics {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    public int Total(String tableName) {
        int total = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select count(*) as 'total' from " + tableName + "");
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    private double totalSales() {
        double total = 0.0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select sum(total) as 'total' from purchase");
            if (rs.next()) {
                total = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    private double todaySales() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = new Date();
        String today = sdf.format(date);
        double total = 0.0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select sum(total) as 'total' from purchase where pDate = '" + today + "'");
            if (rs.next()) {
                total = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    private double totalPurchase(int id) {
        double total = 0.0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select sum(total) as 'total' from purchase where uID = ?" + id + "");
            if (rs.next()) {
                total = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public int totalDeliveries(String name) {
        int total = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select count(*) as 'total' from purchase where supplier = '"+name+"' and status = 'Received'");
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    //admin dashboard
    public void admin() {
        AdminDashboard.jCat.setText(String.valueOf(Total("category")));
        AdminDashboard.jPro.setText(String.valueOf(Total("product")));
        AdminDashboard.jUsers.setText(String.valueOf(Total("user")));
        AdminDashboard.jSuppliers.setText(String.valueOf(Total("supplier")));
        AdminDashboard.jSales.setText(String.valueOf(totalSales()));
        AdminDashboard.jTsales.setText(String.valueOf(todaySales()));
    }

    //user dashboard
    public void user(int id) {
        UserDashboard.jCat.setText(String.valueOf(Total("category")));
        UserDashboard.jPro.setText(String.valueOf(Total("product")));
        UserDashboard.jPurchase.setText(String.valueOf(totalPurchase(id)));
    }

    public void supplier(String name) {
        SupplierDashboard.jDeliveries.setText(String.valueOf(totalDeliveries(name)));
    }
}
