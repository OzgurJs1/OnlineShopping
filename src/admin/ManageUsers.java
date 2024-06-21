/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package admin;

import database.Statistics;
import database.UserDatabase;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Özgür
 */
public class ManageUsers extends javax.swing.JFrame {

    /**
     * Creates new form ManageUsers
     */
    UserDatabase user = new UserDatabase();
    Color textPrimaryColor = new Color(102, 120, 138);
    Color primaryColor = new Color(42, 58, 73);
    int aa, ab;
    DefaultTableModel model;
    int rowIndex;
    Statistics stat = new Statistics();

    public ManageUsers() {
        initComponents();
        usersTable();
        setLocation(450,110);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        BtnUpdate = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        BtnDelete1 = new javax.swing.JButton();
        BtnClear = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField8 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(25, 118, 221));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(0, 0, 0));
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jTextField3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(0, 0, 0));

        jPasswordField1.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(0, 0, 0));

        jTextField4.setBackground(new java.awt.Color(255, 255, 255));
        jTextField4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(0, 0, 0));
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jTextField5.setBackground(new java.awt.Color(204, 204, 204));
        jTextField5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(0, 0, 0));

        jTextField7.setBackground(new java.awt.Color(255, 255, 255));
        jTextField7.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Segoe Print", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username");

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Email");

        jLabel4.setFont(new java.awt.Font("Segoe Print", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Segoe Print", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Phone");

        jLabel6.setFont(new java.awt.Font("Segoe Print", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Security Question");

        jLabel7.setFont(new java.awt.Font("Segoe Print", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Answer");

        jLabel9.setFont(new java.awt.Font("Segoe Print", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Address");

        BtnUpdate.setBackground(new java.awt.Color(204, 204, 255));
        BtnUpdate.setFont(new java.awt.Font("Segoe Print", 1, 20)); // NOI18N
        BtnUpdate.setForeground(new java.awt.Color(25, 118, 221));
        BtnUpdate.setText("Update");
        BtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe Print", 0, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("X");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/visible.png"))); // NOI18N
        jLabel11.setText("jLabel8");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hide.png"))); // NOI18N
        jLabel12.setText("jLabel8");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User ID");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(204, 204, 204));

        jTextField6.setBackground(new java.awt.Color(255, 255, 255));

        BtnDelete1.setBackground(new java.awt.Color(204, 204, 255));
        BtnDelete1.setFont(new java.awt.Font("Segoe Print", 1, 20)); // NOI18N
        BtnDelete1.setForeground(new java.awt.Color(25, 118, 221));
        BtnDelete1.setText("Delete");
        BtnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDelete1ActionPerformed(evt);
            }
        });

        BtnClear.setBackground(new java.awt.Color(204, 204, 255));
        BtnClear.setFont(new java.awt.Font("Segoe Print", 1, 20)); // NOI18N
        BtnClear.setForeground(new java.awt.Color(25, 118, 221));
        BtnClear.setText("Clear");
        BtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClearActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("______________________________________________________________________________________________________________________________________________________");

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserID", "Username", "Email", "Password", "Phone", "Security Question", "Answer", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextField8.setBackground(new java.awt.Color(255, 255, 255));
        jTextField8.setForeground(new java.awt.Color(0, 0, 0));
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe Print", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Search");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(62, 62, 62))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4)
                                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(152, 152, 152)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(BtnClear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(BtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                                    .addComponent(BtnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(253, 253, 253)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(1, 1, 1)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(1, 1, 1)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usersTable() {
        user.getUsersVal(jTable1, "");
        model = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowHeight(30);
        jTable1.setShowGrid(true);
        jTable1.setGridColor(Color.BLACK);
        jTable1.setBackground(Color.WHITE);
        jTable1.setSelectionBackground(Color.LIGHT_GRAY);
    }

    public boolean isEmpty() {
        if (jTextField2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Select a user.", "Warning", 2);
            return false;
        }
        if (jTextField3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email address is required.", "Warning", 2);
            return false;
        }
        if (!jTextField3.getText().matches("^.+@.+\\..+$")) {
            JOptionPane.showMessageDialog(this, "Invalid email address", "Warning", 2);
            return false;
        }
        if (String.valueOf(jPasswordField1.getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password is required.", "Warning", 2);
            return false;
        }
        if (jTextField4.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Phone number is required.", "Warning", 2);
            return false;
        }

        if (jTextField4.getText().length() > 15) {
            JOptionPane.showMessageDialog(this, "Phone number is too long.", "Warning", 2);
            return false;
        }

        if (jTextField4.getText().length() < 10) {
            JOptionPane.showMessageDialog(this, "Phone number is too short.", "Warning", 2);
            return false;
        }
        if (jTextField6.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Answer is required.", "Warning", 2);
            return false;
        }
        if (jTextField7.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Address is required.", "Warning", 2);
            return false;
        }
        return true;
    }

    private void Clear() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jPasswordField1.setText("");
        jTable1.clearSelection();
        stat.admin();
        
    }


    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        setVisible(false);
        AdminDashboard.jPanel13.setBackground(primaryColor);
        AdminDashboard.jPanel14.setBackground(primaryColor);
        AdminDashboard.jLabel16.setForeground(textPrimaryColor);
        AdminDashboard.jLabel16.setVisible(true);
        AdminDashboard.jLabel17.setVisible(true);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.1; i <= 1.0; i += 0.1) {
            String s = "" + i;
            float f = Float.parseFloat(s);
            this.setOpacity(f);
            try {
                Thread.sleep(40);
            } catch (InterruptedException ex) {
                Logger.getLogger(ManageUsers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        aa = evt.getXOnScreen();
        ab = evt.getYOnScreen();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int i = evt.getXOnScreen();
        int j = evt.getYOnScreen();
        this.setLocation(i - aa, j - ab);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void BtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearActionPerformed
        Clear();
    }//GEN-LAST:event_BtnClearActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        jPasswordField1.setEchoChar((char) 0);
        jLabel11.setVisible(false);
        jLabel12.setVisible(true);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        jPasswordField1.setEchoChar('*');
        jLabel12.setVisible(false);
        jLabel11.setVisible(true);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        model = (DefaultTableModel) jTable1.getModel();
        rowIndex = jTable1.getSelectedRow();
        jTextField1.setText(model.getValueAt(rowIndex, 0).toString());
        jTextField2.setText(model.getValueAt(rowIndex, 1).toString());
        jTextField3.setText(model.getValueAt(rowIndex, 2).toString());
        jPasswordField1.setText(model.getValueAt(rowIndex, 3).toString());
        jTextField4.setText(model.getValueAt(rowIndex, 4).toString());
        jTextField5.setText(model.getValueAt(rowIndex, 5).toString());
        jTextField6.setText(model.getValueAt(rowIndex, 6).toString());
        jTextField7.setText(model.getValueAt(rowIndex, 7).toString());

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        char input = evt.getKeyChar();
        if (!(input < '0' || input > '9') && input != '\b') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Username doesn't contain any numbers!", "Warning", 2);
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        jTable1.setModel(new DefaultTableModel(null, new Object[]{"UserID", "Username", "Email",
            "Password", "Phone", "Security Question", "Answer", "Address"}));
        user.getUsersVal(jTable1, jTextField8.getText());
    }//GEN-LAST:event_jTextField8KeyReleased

    private void BtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateActionPerformed
        if (isEmpty()) {
            if (!Check()) {
                int id = Integer.parseInt(jTextField1.getText());
                String username = jTextField2.getText();
                String email = jTextField3.getText();
                String password = String.valueOf(jPasswordField1.getPassword());
                String phone = jTextField4.getText();
                String seq = jTextField5.getText();
                String answer = jTextField6.getText();
                String address = jTextField7.getText();
                user.update(id, username, email, password, phone, seq, answer, address);
                this.dispose();
                jTable1.setModel(new DefaultTableModel(null, new Object[]{"UserID", "Username", "Email",
                    "Password", "Phone", "Security Question", "Answer", "Address"}));
                user.getUsersVal(jTable1, "");
                Clear();
            }
        }
    }//GEN-LAST:event_BtnUpdateActionPerformed

    private void BtnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDelete1ActionPerformed
        if (isEmpty()) {
            int id = Integer.parseInt(jTextField1.getText());
            user.delete(id);
            jTable1.setModel(new DefaultTableModel(null, new Object[]{"UserID", "Username", "Email",
                "Password", "Phone", "Security Question", "Answer", "Address"}));
            user.getUsersVal(jTable1, "");
            Clear();
        }
    }//GEN-LAST:event_BtnDelete1ActionPerformed

    private boolean Check() {
        String newEmail = jTextField3.getText();
        String newPhone = jTextField4.getText();
        String oldEmail = model.getValueAt(rowIndex, 2).toString();
        String oldPhone = model.getValueAt(rowIndex, 4).toString();
        if (newEmail.equals(oldEmail) && newPhone.equals(oldPhone)) {
            return false;
        } else {
            if (!newEmail.equals(oldEmail)) {
                boolean x = user.isEmailExists(newEmail);
                if (x) {
                    JOptionPane.showMessageDialog(this, "This email is exists", "Warning", 2);
                }
                return x;
            }
            if (!newEmail.equals(oldPhone)) {
                boolean x = user.isPhoneExists(newPhone);
                if (x) {
                    JOptionPane.showMessageDialog(this, "This phone number already exists", "Warning", 2);
                }
                return x;
            }
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnClear;
    private javax.swing.JButton BtnDelete1;
    private javax.swing.JButton BtnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}