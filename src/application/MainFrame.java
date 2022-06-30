/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package application;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Dai Phuc
 */
public class MainFrame extends javax.swing.JFrame {

    
    Color DefaultColor, ClickedColor;
    
    public MainFrame() {
        
        DefaultColor = new Color(11, 34, 50);
        ClickedColor = new Color(251,154,59);
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        CourseButton.setBackground(DefaultColor);
        GradeButton.setBackground(DefaultColor);
        ExamButton.setBackground(DefaultColor);
        ExcelButton.setBackground(DefaultColor);
        LogOutButton.setBackground(DefaultColor);
        ExitButton.setBackground(DefaultColor);
        PersonalButton.setBackground(ClickedColor);
    }
    
    public void CloseFrame(){
        super.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        PersonalButton = new javax.swing.JPanel();
        personalButton = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        GradeButton = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ExcelButton = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        CourseButton = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ExamButton = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        LogOutButton = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        ExitButton = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        MainTab = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(251, 154, 59));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ONLINE TESTING APPLICATION");

        PersonalButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PersonalButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PersonalButtonMousePressed(evt);
            }
        });

        personalButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/applicationIcon/PersonalInfor.png"))); // NOI18N
        personalButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                personalButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PersonalButtonLayout = new javax.swing.GroupLayout(PersonalButton);
        PersonalButton.setLayout(PersonalButtonLayout);
        PersonalButtonLayout.setHorizontalGroup(
            PersonalButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PersonalButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(personalButton)
                .addContainerGap())
        );
        PersonalButtonLayout.setVerticalGroup(
            PersonalButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PersonalButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(personalButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(244, 244, 244)
                .addComponent(PersonalButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PersonalButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(11, 34, 50));

        GradeButton.setBackground(new java.awt.Color(11, 34, 50));
        GradeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GradeButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                GradeButtonMousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/applicationIcon/grade.png"))); // NOI18N
        jLabel2.setText("Grade");

        javax.swing.GroupLayout GradeButtonLayout = new javax.swing.GroupLayout(GradeButton);
        GradeButton.setLayout(GradeButtonLayout);
        GradeButtonLayout.setHorizontalGroup(
            GradeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GradeButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        GradeButtonLayout.setVerticalGroup(
            GradeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GradeButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ExcelButton.setBackground(new java.awt.Color(11, 34, 50));
        ExcelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExcelButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ExcelButtonMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/applicationIcon/excel-icon.png"))); // NOI18N
        jLabel3.setText("Excel");

        javax.swing.GroupLayout ExcelButtonLayout = new javax.swing.GroupLayout(ExcelButton);
        ExcelButton.setLayout(ExcelButtonLayout);
        ExcelButtonLayout.setHorizontalGroup(
            ExcelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExcelButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ExcelButtonLayout.setVerticalGroup(
            ExcelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExcelButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        CourseButton.setBackground(new java.awt.Color(11, 34, 50));
        CourseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CourseButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CourseButtonMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/applicationIcon/home-icon.png"))); // NOI18N
        jLabel1.setText("My Course");

        javax.swing.GroupLayout CourseButtonLayout = new javax.swing.GroupLayout(CourseButton);
        CourseButton.setLayout(CourseButtonLayout);
        CourseButtonLayout.setHorizontalGroup(
            CourseButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CourseButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        CourseButtonLayout.setVerticalGroup(
            CourseButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CourseButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ExamButton.setBackground(new java.awt.Color(11, 34, 50));
        ExamButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExamButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ExamButtonMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/applicationIcon/exam.png"))); // NOI18N
        jLabel4.setText("Exam");

        javax.swing.GroupLayout ExamButtonLayout = new javax.swing.GroupLayout(ExamButton);
        ExamButton.setLayout(ExamButtonLayout);
        ExamButtonLayout.setHorizontalGroup(
            ExamButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExamButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ExamButtonLayout.setVerticalGroup(
            ExamButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExamButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        LogOutButton.setBackground(new java.awt.Color(11, 34, 50));
        LogOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogOutButtonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LogOutButtonMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/applicationIcon/logout (1).png"))); // NOI18N
        jLabel5.setText("Log Out");

        javax.swing.GroupLayout LogOutButtonLayout = new javax.swing.GroupLayout(LogOutButton);
        LogOutButton.setLayout(LogOutButtonLayout);
        LogOutButtonLayout.setHorizontalGroup(
            LogOutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogOutButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LogOutButtonLayout.setVerticalGroup(
            LogOutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogOutButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ExitButton.setBackground(new java.awt.Color(11, 34, 50));
        ExitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ExitButtonMousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/applicationIcon/exit-icon.png"))); // NOI18N
        jLabel6.setText("Exit");

        javax.swing.GroupLayout ExitButtonLayout = new javax.swing.GroupLayout(ExitButton);
        ExitButton.setLayout(ExitButtonLayout);
        ExitButtonLayout.setHorizontalGroup(
            ExitButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExitButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ExitButtonLayout.setVerticalGroup(
            ExitButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExitButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(GradeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ExcelButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ExamButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ExitButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LogOutButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CourseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(CourseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(GradeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ExcelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ExamButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LogOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MainTabLayout = new javax.swing.GroupLayout(MainTab);
        MainTab.setLayout(MainTabLayout);
        MainTabLayout.setHorizontalGroup(
            MainTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 773, Short.MAX_VALUE)
        );
        MainTabLayout.setVerticalGroup(
            MainTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainTab)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(MainTab)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GradeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GradeButtonMousePressed
        // TODO add your handling code here:
        CourseButton.setBackground(DefaultColor);
        GradeButton.setBackground(ClickedColor);
        ExamButton.setBackground(DefaultColor);
        ExcelButton.setBackground(DefaultColor);
        LogOutButton.setBackground(DefaultColor);
        ExitButton.setBackground(DefaultColor);
    }//GEN-LAST:event_GradeButtonMousePressed

    private void ExcelButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExcelButtonMousePressed
        // TODO add your handling code here:
        CourseButton.setBackground(DefaultColor);
        GradeButton.setBackground(DefaultColor);
        ExcelButton.setBackground(ClickedColor);
        ExamButton.setBackground(DefaultColor);
        LogOutButton.setBackground(DefaultColor);
        ExitButton.setBackground(DefaultColor);
    }//GEN-LAST:event_ExcelButtonMousePressed

    private void CourseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CourseButtonMouseClicked
        // TODO add your handling code here:
        CoursePanel CourseTab = new CoursePanel();
        MainTab.removeAll();
        MainTab.add(CourseTab).setVisible(true);
    }//GEN-LAST:event_CourseButtonMouseClicked

    private void CourseButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CourseButtonMousePressed
        // TODO add your handling code here:

        //        if (CourseTab == null){
            //            CourseTab=new CoursePanel();
            //            MainTab.addTab("Search", CourseTab);
            //        }
        //        //        CoursePanel.showProduct();
        //        MainTab.setSelectedComponent(CourseTab);
        CourseButton.setBackground(ClickedColor);
        GradeButton.setBackground(DefaultColor);
        ExamButton.setBackground(DefaultColor);
        ExcelButton.setBackground(DefaultColor);
        LogOutButton.setBackground(DefaultColor);
        ExitButton.setBackground(DefaultColor);

    }//GEN-LAST:event_CourseButtonMousePressed

    private void ExamButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExamButtonMousePressed
        // TODO add your handling code here:
        CourseButton.setBackground(DefaultColor);
        GradeButton.setBackground(DefaultColor);
        ExcelButton.setBackground(DefaultColor);
        ExamButton.setBackground(ClickedColor);
        LogOutButton.setBackground(DefaultColor);
        ExitButton.setBackground(DefaultColor);
    }//GEN-LAST:event_ExamButtonMousePressed

    private void LogOutButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutButtonMousePressed
        // TODO add your handling code here:
        CourseButton.setBackground(DefaultColor);
        GradeButton.setBackground(DefaultColor);
        ExcelButton.setBackground(DefaultColor);
        ExamButton.setBackground(DefaultColor);
        LogOutButton.setBackground(ClickedColor);
        ExitButton.setBackground(DefaultColor);
    }//GEN-LAST:event_LogOutButtonMousePressed

    private void ExitButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButtonMousePressed
        // TODO add your handling code here:
        CourseButton.setBackground(DefaultColor);
        GradeButton.setBackground(DefaultColor);
        ExcelButton.setBackground(DefaultColor);
        ExamButton.setBackground(DefaultColor);
        LogOutButton.setBackground(DefaultColor);
        ExitButton.setBackground(ClickedColor);

        int response = JOptionPane.showConfirmDialog(this, "Do you want to exit?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION){
            this.dispose();
        }
    }//GEN-LAST:event_ExitButtonMousePressed

    private void ExamButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExamButtonMouseClicked
        // TODO add your handling code here:
        ExamPanel ExamTab = new ExamPanel();
        MainTab.removeAll();
        MainTab.add(ExamTab).setVisible(true);
    }//GEN-LAST:event_ExamButtonMouseClicked

    private void LogOutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutButtonMouseClicked
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(this, "Do you want to log out?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION){
            this.CloseFrame();
            new LoginFrame().setVisible(true);
        }
    }//GEN-LAST:event_LogOutButtonMouseClicked

    private void ExcelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExcelButtonMouseClicked
        // TODO add your handling code here:
        DAO.exportExcelStudent();
    }//GEN-LAST:event_ExcelButtonMouseClicked

    private void GradeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GradeButtonMouseClicked
        // TODO add your handling code here:
        GradePanel GradeTab = new GradePanel();
        MainTab.removeAll();
        MainTab.add(GradeTab).setVisible(true);
    }//GEN-LAST:event_GradeButtonMouseClicked

    private void PersonalButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PersonalButtonMousePressed
        // TODO add your handling code here:
//        PersonalButton.setBackground(DefaultColor);
    }//GEN-LAST:event_PersonalButtonMousePressed

    private void PersonalButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PersonalButtonMouseClicked
        // TODO add your handling code here:
        new UpdateFrame().setVisible(true);
    }//GEN-LAST:event_PersonalButtonMouseClicked

    private void personalButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personalButtonMouseClicked
        // TODO add your handling code here:
        new UpdateFrame().setVisible(true);
    }//GEN-LAST:event_personalButtonMouseClicked

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CourseButton;
    private javax.swing.JPanel ExamButton;
    private javax.swing.JPanel ExcelButton;
    private javax.swing.JPanel ExitButton;
    private javax.swing.JPanel GradeButton;
    private javax.swing.JPanel LogOutButton;
    private javax.swing.JDesktopPane MainTab;
    private javax.swing.JPanel PersonalButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel personalButton;
    // End of variables declaration//GEN-END:variables
}