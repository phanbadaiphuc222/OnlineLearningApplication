/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;

/**
 *
 * @author Dai Phuc
 */
public class GradeTutorPanel extends javax.swing.JInternalFrame {

    DefaultTableModel tableModel;
    List<Result> ReusltList;

    String ID = new String();
    String IDstudent = new String();
    String courseName = new String();
    String grade = new String();
    String sendTo = new String();

    public GradeTutorPanel() {

        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);

        initComponents();
        tableModel = (DefaultTableModel) tblResult.getModel();

        tblResult.getColumnModel().getColumn(1).setPreferredWidth(80);
        tblResult.getColumnModel().getColumn(4).setPreferredWidth(80);
        tblResult.getColumnModel().getColumn(2).setPreferredWidth(200);
        tblResult.getColumnModel().getColumn(0).setPreferredWidth(200);
        tblResult.getColumnModel().getColumn(3).setPreferredWidth(80);
    }

    public void showResult() {

        ReusltList = DAO.findResult(ID);

        tableModel.setRowCount(0);

        ReusltList.forEach(Result -> {
            tableModel.addRow(new Object[]{Result.getStudent(),
                Result.getID(), Result.getSubject(), Result.getClassCode(), Result.getGrade()});
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        IDTestField = new javax.swing.JTextField();
        SendEmailButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();
        ExcelButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(780, 385));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("ID Test:");

        IDTestField.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                IDTestFieldCaretUpdate(evt);
            }
        });

        SendEmailButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SendEmailButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/applicationIcon/gmail.png"))); // NOI18N
        SendEmailButton.setText("Send Email");
        SendEmailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendEmailButtonActionPerformed(evt);
            }
        });

        tblResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student", "ID", "Subject", "Class", "Grade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblResultMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblResult);
        if (tblResult.getColumnModel().getColumnCount() > 0) {
            tblResult.getColumnModel().getColumn(0).setResizable(false);
            tblResult.getColumnModel().getColumn(1).setResizable(false);
            tblResult.getColumnModel().getColumn(3).setResizable(false);
            tblResult.getColumnModel().getColumn(4).setResizable(false);
        }

        ExcelButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ExcelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/applicationIcon/excel-icon.png"))); // NOI18N
        ExcelButton.setText("Excel");
        ExcelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IDTestField, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(SendEmailButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(ExcelButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(IDTestField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(SendEmailButton)
                .addGap(30, 30, 30)
                .addComponent(ExcelButton)
                .addContainerGap(199, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IDTestFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_IDTestFieldCaretUpdate
        // TODO add your handling code here:
        ID = IDTestField.getText();
        DAO.findResult(ID);
        showResult();
    }//GEN-LAST:event_IDTestFieldCaretUpdate

    private void SendEmailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendEmailButtonActionPerformed

        try {
            JPanel panel = new JPanel();
            JLabel label = new JLabel("Enter password:");
            JPasswordField pass = new JPasswordField(10);
            panel.add(label);
            panel.add(pass);
            String[] options = new String[]{"OK", "Cancel"};
            int option = JOptionPane.showOptionDialog(null, panel, "The title",
                    JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[1]);
            char[] password = pass.getPassword();
            // TODO add your handling code here:
            String subject = "This mail is about your mark of " + courseName;
            String message = "Your score is " + grade + "\nFrom " + Application.userName;
            DAO.send(sendTo, subject, message, Application.Email, new String(password));

        } catch (Exception ex) {
            Logger.getLogger(GradeTutorPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SendEmailButtonActionPerformed

    private void tblResultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultMouseClicked
        // TODO add your handling code here:
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());

        courseName = source.getModel().getValueAt(row, 2) + "";
        grade = source.getModel().getValueAt(row, 4) + "";
        IDstudent = source.getModel().getValueAt(row, 1) + "";

        Connection conn = null;
        PreparedStatement statement = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            PreparedStatement passnew = conn.prepareStatement("select email from user where id = ?;", ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            passnew.setString(1, Application.ExamID);
            ResultSet rs = passnew.executeQuery();
            
            if (rs.next()) {
                sendTo = rs.getString("email");
            }
            sendTo = "phanbadaiphuc123@gmail.com";
            System.out.println(sendTo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblResultMouseClicked

    private void ExcelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcelButtonActionPerformed
        // TODO add your handling code here:
        DAO.exportExcelTutor(tblResult);
    }//GEN-LAST:event_ExcelButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExcelButton;
    private javax.swing.JTextField IDTestField;
    private javax.swing.JButton SendEmailButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResult;
    // End of variables declaration//GEN-END:variables
}