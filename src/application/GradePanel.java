/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package application;

import java.util.List;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dai Phuc
 */
public class GradePanel extends javax.swing.JInternalFrame {

    DefaultTableModel tableModel;
    List <Result> ResultList;
    
    public GradePanel() {
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        
        initComponents();
        tableModel = (DefaultTableModel) tblGrade.getModel();
        showCourse();
        
        tblGrade.getColumnModel().getColumn(1).setPreferredWidth(120);
        tblGrade.getColumnModel().getColumn(3).setPreferredWidth(50);
        tblGrade.getColumnModel().getColumn(4).setPreferredWidth(50);
        tblGrade.getColumnModel().getColumn(6).setPreferredWidth(100);
        tblGrade.getColumnModel().getColumn(0).setPreferredWidth(50);
    }
    
    public void showCourse(){
        
        ResultList = DAO.findResult(Application.ID);
            
            tableModel.setRowCount(0);  
            
                ResultList.forEach(Result -> { 
                    tableModel.addRow(new Object[] { Result.getExamNameTest(),
                    Result.getSubject(), Result.getCourseCode(), Result.getClassCode(), Result.getGrade(), Result.getTime(), 
                    Result.getTimeStart()});
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblGrade = new javax.swing.JTable();

        setRequestFocusEnabled(false);

        tblGrade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Subject", "Course Code", "Class Code", "Grade", "Time (min)", "Time start"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblGrade);
        if (tblGrade.getColumnModel().getColumnCount() > 0) {
            tblGrade.getColumnModel().getColumn(0).setResizable(false);
            tblGrade.getColumnModel().getColumn(1).setResizable(false);
            tblGrade.getColumnModel().getColumn(2).setResizable(false);
            tblGrade.getColumnModel().getColumn(3).setResizable(false);
            tblGrade.getColumnModel().getColumn(4).setResizable(false);
            tblGrade.getColumnModel().getColumn(5).setResizable(false);
            tblGrade.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblGrade;
    // End of variables declaration//GEN-END:variables
}
