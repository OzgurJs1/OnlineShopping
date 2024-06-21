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

public class PurchaseDatabase {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    // get purchase table max row
    public int getMaxRow() {
        int row = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select max(id) from purchase");
            while (rs.next()) {
                row = rs.getInt(1);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(PurchaseDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return row + 1;
    }

    public String[] getUserValue(String email) {
        String[] value = new String[4];
        String sql = "select uID, uName, uPhone, uAddress from user where uEmail = '" + email + "'";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                value[0] = rs.getString(1);
                value[1] = rs.getString(2);
                value[2] = rs.getString(3);
                value[3] = rs.getString(4);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
    }

    public void insert(int id, int uid, String uname, String uPhone, int pid, String pname, int qty, double price,
            double total, String pDate, String address, String rDate, String supplier, String status) {
        String sql = "insert into purchase values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, uid);
            ps.setString(3, uname);
            ps.setString(4, uPhone);
            ps.setInt(5, pid);
            ps.setString(6, pname);
            ps.setInt(7, qty);
            ps.setDouble(8, price);
            ps.setDouble(9, total);
            ps.setString(10, pDate);
            ps.setString(11, address);
            ps.setString(12, rDate);
            ps.setString(13, supplier);
            ps.setString(14, status);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // get product quantity 
    public int getQty(int pid) {
        int qty = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select pQty from product where pid = " + pid + "");
            if (rs.next()) {
                qty = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qty;
    }

    public void qtyUpdate(int pID, int qty) {
        String sql = "update product set pQty = ? where pID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, qty);
            ps.setInt(2, pID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setSuppStatus(int id, String supplier, String status) {
        String sql = "update purchase set supplier = ?, status = ? where id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, supplier);
            ps.setString(2, status);
            ps.setInt(3, id);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Supplier successfully selected...");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getProductsValue(JTable table, String Search, int uid) {
        String sql = "select * from purchase where concat(id, pID,productName) like ? and uID = ? order by id desc";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + Search + "%");
            ps.setInt(2, uid);
            rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs.next()) {
                row = new Object[10];
                row[0] = rs.getInt(1);
                row[1] = rs.getInt(5);
                row[2] = rs.getString(6);
                row[3] = rs.getInt(7);
                row[4] = rs.getDouble(8);
                row[5] = rs.getDouble(9);
                row[6] = rs.getString(10);
                row[7] = rs.getString(12);
                row[8] = rs.getString(13);
                row[9] = rs.getString(14);
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void refund(int id) {
        int x = JOptionPane.showConfirmDialog(null, "Are you sure to refund this product?", "Refund Product", JOptionPane.OK_OPTION);
        if (x == JOptionPane.OK_OPTION) {
            try {
                ps = con.prepareStatement("delete from purchase where id = ?");
                ps.setInt(1, id);
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Product refund succeed.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(PurchaseDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void getProductsValue(JTable table, String Search) {
        String sql = "select * from purchase where concat(id, uName,pID,productName) like ? and status = 'Pending' order by id desc";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + Search + "%");
            rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs.next()) {
                row = new Object[14];
                row[0] = rs.getInt(1);
                row[1] = rs.getInt(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getInt(5);
                row[5] = rs.getString(6);
                row[6] = rs.getInt(7);
                row[7] = rs.getDouble(8);
                row[8] = rs.getDouble(9);
                row[9] = rs.getString(10);
                row[10] = rs.getString(11);
                row[11] = rs.getString(12);
                row[12] = rs.getString(13);
                row[13] = rs.getString(14);
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // get all on the way purchased products
    public void getOnTheWayProducts(JTable table, String Search, String supplier) {
        String sql = "select * from purchase where concat(id, uName, pID, productName) like ? and supplier = ? and status = 'On the way' order by id desc";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + Search + "%");
            ps.setString(2, supplier);
            rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs.next()) {
                row = new Object[14];
                row[0] = rs.getInt(1);
                row[1] = rs.getInt(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getInt(5);
                row[5] = rs.getString(6);
                row[6] = rs.getInt(7);
                row[7] = rs.getDouble(8);
                row[8] = rs.getDouble(9);
                row[9] = rs.getString(10);
                row[10] = rs.getString(11);
                row[11] = rs.getString(12);
                row[12] = rs.getString(13);
                row[13] = rs.getString(14);
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setDateStatus(int id, String rDate, String status) {
        String sql = "update purchase set receiveDate = ?, status = ? where id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, rDate);
            ps.setString(2, status);
            ps.setInt(3, id);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Product Successfully delivered...");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getSuppDeliProducts(JTable table, String Search, String supplier) {
        String sql = "select * from purchase where concat(id, uName, pID, productName) like ? and supplier = ? and status = 'Received' order by id desc";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + Search + "%");
            ps.setString(2, supplier);
            rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs.next()) {
                row = new Object[14];
                row[0] = rs.getInt(1);
                row[1] = rs.getInt(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getInt(5);
                row[5] = rs.getString(6);
                row[6] = rs.getInt(7);
                row[7] = rs.getDouble(8);
                row[8] = rs.getDouble(9);
                row[9] = rs.getString(10);
                row[10] = rs.getString(11);
                row[11] = rs.getString(12);
                row[12] = rs.getString(13);
                row[13] = rs.getString(14);
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void transaction(JTable table, String Search) {
        String sql = "select * from purchase where concat(id, pID, uID) like ? and status = 'Received' order by id desc";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + Search + "%");
            rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs.next()) {
                row = new Object[8];
                row[0] = rs.getInt(1);
                row[1] = rs.getInt(2);
                row[2] = rs.getInt(5);
                row[3] = rs.getInt(7);
                row[4] = rs.getDouble(8);
                row[5] = rs.getDouble(9);
                row[6] = rs.getString(12);
                row[7] = rs.getString(13);
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
