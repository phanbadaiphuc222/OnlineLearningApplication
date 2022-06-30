/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package application;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Dai Phuc
 */
public class QuestionPanel extends javax.swing.JInternalFrame {

    DefaultTableModel tableModel;
    
    public QuestionPanel() {
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        initComponents();
        tableModel = (DefaultTableModel) tblQuestions.getModel();
        showQuestion();
        
        tblQuestions.getColumnModel().getColumn(1).setPreferredWidth(400);
        tblQuestions.getColumnModel().getColumn(2).setPreferredWidth(60);
        tblQuestions.getColumnModel().getColumn(3).setPreferredWidth(60);
        tblQuestions.getColumnModel().getColumn(4).setPreferredWidth(40);
        tblQuestions.getColumnModel().getColumn(5).setPreferredWidth(80);
        tblQuestions.getColumnModel().getColumn(6).setPreferredWidth(80);
        tblQuestions.getColumnModel().getColumn(7).setPreferredWidth(80);
        tblQuestions.getColumnModel().getColumn(8).setPreferredWidth(80);
       
    }
    
    public void showQuestion(){
        
        List <Question> QuestionList = DAO.findQuestion();
                
        tableModel.setRowCount(0);
        
        QuestionList.forEach(Question -> { 
            tableModel.addRow(new Object[] { Question.getCourse(),
                Question.getQuestions(), Question.getAnswer(), Question.getGrade(), Question.getId(), 
                Question.getOption1(), Question.getOption2(), Question.getOption3(), Question.getOption4()});
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
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Option4Field = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        AnswerField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        ModifyButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        Option3Field = new javax.swing.JTextField();
        Option2Field = new javax.swing.JTextField();
        Option1Field = new javax.swing.JTextField();
        QuestionField = new javax.swing.JTextField();
        CourseCodeField = new javax.swing.JTextField();
        IDField = new javax.swing.JTextField();
        GradeField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQuestions = new javax.swing.JTable();

        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(795, 380));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Question:");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("ID:");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("Course Code:");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("A");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("C");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("B");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("D");

        Option4Field.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Answer:");

        AnswerField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        AnswerField.setPreferredSize(new java.awt.Dimension(64, 28));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Grade:");

        AddButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        AddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/applicationIcon/add-icon.png"))); // NOI18N
        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        ModifyButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ModifyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/applicationIcon/draw.png"))); // NOI18N
        ModifyButton.setText("Modify");
        ModifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyButtonActionPerformed(evt);
            }
        });

        DeleteButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        DeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/applicationIcon/remove-icon.png"))); // NOI18N
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        Option3Field.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        Option2Field.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Option2Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Option2FieldActionPerformed(evt);
            }
        });

        Option1Field.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Option1Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Option1FieldActionPerformed(evt);
            }
        });

        QuestionField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        QuestionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuestionFieldActionPerformed(evt);
            }
        });

        CourseCodeField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CourseCodeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourseCodeFieldActionPerformed(evt);
            }
        });

        IDField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        IDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDFieldActionPerformed(evt);
            }
        });

        GradeField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        GradeField.setPreferredSize(new java.awt.Dimension(64, 28));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tblQuestions.getTableHeader().setFont(new Font("Dialog", 0, 12));
        tblQuestions.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tblQuestions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Course Code", "Question", "Answer", "Grade", "ID", "Option 1", "Option 2", "Option 3", "Option 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblQuestions.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblQuestions.getTableHeader().setReorderingAllowed(false);
        tblQuestions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuestionsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblQuestions);
        if (tblQuestions.getColumnModel().getColumnCount() > 0) {
            tblQuestions.getColumnModel().getColumn(0).setResizable(false);
            tblQuestions.getColumnModel().getColumn(1).setResizable(false);
            tblQuestions.getColumnModel().getColumn(2).setResizable(false);
            tblQuestions.getColumnModel().getColumn(3).setResizable(false);
            tblQuestions.getColumnModel().getColumn(4).setResizable(false);
            tblQuestions.getColumnModel().getColumn(5).setResizable(false);
            tblQuestions.getColumnModel().getColumn(6).setResizable(false);
            tblQuestions.getColumnModel().getColumn(7).setResizable(false);
            tblQuestions.getColumnModel().getColumn(8).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(245, 245, 245)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CourseCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Option3Field))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Option1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Option2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Option4Field))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(QuestionField, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AnswerField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(162, 162, 162)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(GradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AddButton)
                                .addGap(147, 147, 147)
                                .addComponent(ModifyButton)
                                .addGap(119, 119, 119)
                                .addComponent(DeleteButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(CourseCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(QuestionField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Option2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(GradeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Option1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Option3Field, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Option4Field, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(AnswerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AddButton)
                        .addComponent(ModifyButton))
                    .addComponent(DeleteButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        // TODO add your handling code here:
        String ID = IDField.getText();
        String CourseCode = CourseCodeField.getText();
        String Question = QuestionField.getText();
        String Option1 = Option1Field.getText();
        String Option2 = Option2Field.getText();
        String Option3 = Option3Field.getText();
        String Option4 = Option4Field.getText();
        String Answer = AnswerField.getText();
        String Grade = GradeField.getText();

        try {
            if (ID.equals("")){
                JOptionPane.showMessageDialog(this, "ID is null!", "Error", JOptionPane.ERROR_MESSAGE);
                IDField.setBackground(new Color(255, 123, 123));
            } else if (CourseCodeField.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Course Code is null!", "Error", JOptionPane.ERROR_MESSAGE);
                CourseCodeField.setBackground(new Color(255, 123, 123));
            } else if (QuestionField.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Question is null!", "Error", JOptionPane.ERROR_MESSAGE);
                QuestionField.setBackground(new Color(255, 123, 123));
            } else if (Option1Field.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Option A is null!", "Error", JOptionPane.ERROR_MESSAGE);
                Option1Field.setBackground(new Color(255, 123, 123));
            } else if (Option3Field.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Option B is null!", "Error", JOptionPane.ERROR_MESSAGE);
                Option3Field.setBackground(new Color(255, 123, 123));
            } else if (Option3Field.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Option C is null!", "Error", JOptionPane.ERROR_MESSAGE);
                Option3Field.setBackground(new Color(255, 123, 123));
            } else if (Option4Field.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Option D is null!", "Error", JOptionPane.ERROR_MESSAGE);
                Option4Field.setBackground(new Color(255, 123, 123));
            } else if (AnswerField.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Answer is null!", "Error", JOptionPane.ERROR_MESSAGE);
                AnswerField.setBackground(new Color(255, 123, 123));
            } else if (GradeField.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Grade is null!", "Error", JOptionPane.ERROR_MESSAGE);                GradeField.setBackground(new Color(255, 123, 123));
            } else {

                Question c = new Question();

                IDField.setBackground(null);
                CourseCodeField.setBackground(null);
                QuestionField.setBackground(null);
                Option1Field.setBackground(null);
                Option2Field.setBackground(null);
                Option3Field.setBackground(null);
                Option4Field.setBackground(null);
                AnswerField.setBackground(null);
                GradeField.setBackground(null);

                c.setId(ID);
                c.setCourse(CourseCode);
                c.setQuestions(Question);
                c.setOption1(Option1);
                c.setOption2(Option2);
                c.setOption3(Option3);
                c.setOption4(Option4);
                c.setAnswer(Answer);
                c.setGrade(Integer.parseInt(Grade));

                if (DAO.check(ID, 1) == true) JOptionPane.showMessageDialog(this, "ID has already existed!", "Error", JOptionPane.ERROR_MESSAGE);
                else{
                    DAO.insertQuestion(c);
                    JOptionPane.showMessageDialog(this, "Successfully insert question!", "Alert", JOptionPane.INFORMATION_MESSAGE);
                    ID+=1;
                    int id=Integer.parseInt(IDField.getText())+1;
                    IDField.setText(String.valueOf(id));
                }

            }

        } catch (Exception e){
            e.printStackTrace();
        }
        showQuestion();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void ModifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyButtonActionPerformed
        // TODO add your handling code here:
        String ID = IDField.getText();
        String CourseCode = CourseCodeField.getText();
        String Question = QuestionField.getText();
        String Option1 = Option1Field.getText();
        String Option2 = Option2Field.getText();
        String Option3 = Option3Field.getText();
        String Option4 = Option4Field.getText();
        String Answer = AnswerField.getText();
        int Grade = Integer.parseInt(GradeField.getText());

        try {
            if (ID.equals("")){
                JOptionPane.showMessageDialog(this, "ID is null!", "Error", JOptionPane.INFORMATION_MESSAGE);
                IDField.setBackground(new Color(255, 123, 123));
            } else if (CourseCodeField.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Course Code is null!", "Error", JOptionPane.INFORMATION_MESSAGE);
                CourseCodeField.setBackground(new Color(255, 123, 123));
            } else if (QuestionField.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Question is null!", "Error", JOptionPane.INFORMATION_MESSAGE);
                QuestionField.setBackground(new Color(255, 123, 123));
            } else if (Option1Field.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Option A is null!", "Error", JOptionPane.INFORMATION_MESSAGE);
                Option1Field.setBackground(new Color(255, 123, 123));
            } else if (Option3Field.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Option B is null!", "Error", JOptionPane.INFORMATION_MESSAGE);
                Option3Field.setBackground(new Color(255, 123, 123));
            } else if (Option3Field.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Option C is null!", "Error", JOptionPane.INFORMATION_MESSAGE);
                Option3Field.setBackground(new Color(255, 123, 123));
            } else if (Option4Field.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Option D is null!", "Error", JOptionPane.INFORMATION_MESSAGE);
                Option4Field.setBackground(new Color(255, 123, 123));
            } else if (AnswerField.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Answer is null!", "Error", JOptionPane.INFORMATION_MESSAGE);
                AnswerField.setBackground(new Color(255, 123, 123));
            } else if (GradeField.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Grade is null!", "Error", JOptionPane.INFORMATION_MESSAGE);
                GradeField.setBackground(new Color(255, 123, 123));
            } else {
                Question c = new Question();

                IDField.setBackground(null);
                CourseCodeField.setBackground(null);
                QuestionField.setBackground(null);
                Option1Field.setBackground(null);
                Option3Field.setBackground(null);
                Option3Field.setBackground(null);
                Option4Field.setBackground(null);
                AnswerField.setBackground(null);
                GradeField.setBackground(null);

                c.setId(ID);
                c.setCourse(CourseCode);
                c.setQuestions(Question);
                c.setOption1(Option1);
                c.setOption2(Option2);
                c.setOption3(Option3);
                c.setOption4(Option4);
                c.setAnswer(Answer);
                c.setGrade(Grade);
                
                System.out.println(Option2);

                if (DAO.check(ID, 1) == false) JOptionPane.showMessageDialog(this, "ID does not exist!", "Error", JOptionPane.INFORMATION_MESSAGE);
                else{
                    DAO.modify(c);
                    JOptionPane.showMessageDialog(this, "Successfully modify question!", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        showQuestion();
    }//GEN-LAST:event_ModifyButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
        String ID = IDField.getText();
        if (DAO.check(ID, 1) == false) {
            JOptionPane.showMessageDialog(this, "ID is not existed!", "Error", JOptionPane.ERROR_MESSAGE);
            IDField.setBackground(new Color(255, 123, 123));
        }
        else {
            IDField.setBackground(null);
            DAO.removeQuestions(ID);
            JOptionPane.showMessageDialog(this, "Sucessfully deleted!", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }
        showQuestion();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void tblQuestionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuestionsMouseClicked
        DefaultTableModel model = (DefaultTableModel) tblQuestions.getModel();
        int selectedRowIndex = tblQuestions.getSelectedRow();
        QuestionField.setText(model.getValueAt(selectedRowIndex, 1).toString());
        AnswerField.setText(model.getValueAt(selectedRowIndex, 2).toString());
        IDField.setText(model.getValueAt(selectedRowIndex, 4).toString());
        CourseCodeField.setText(model.getValueAt(selectedRowIndex, 0).toString());
        GradeField.setText(model.getValueAt(selectedRowIndex, 3).toString());
        Option1Field.setText(model.getValueAt(selectedRowIndex, 5).toString());
        Option2Field.setText(model.getValueAt(selectedRowIndex, 6).toString());
        Option3Field.setText(model.getValueAt(selectedRowIndex, 7).toString());
        Option4Field.setText(model.getValueAt(selectedRowIndex, 8).toString());
    }//GEN-LAST:event_tblQuestionsMouseClicked

    private void Option2FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Option2FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Option2FieldActionPerformed

    private void Option1FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Option1FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Option1FieldActionPerformed

    private void QuestionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuestionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuestionFieldActionPerformed

    private void CourseCodeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CourseCodeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CourseCodeFieldActionPerformed

    private void IDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JTextField AnswerField;
    private javax.swing.JTextField CourseCodeField;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTextField GradeField;
    private javax.swing.JTextField IDField;
    private javax.swing.JButton ModifyButton;
    private javax.swing.JTextField Option1Field;
    private javax.swing.JTextField Option2Field;
    private javax.swing.JTextField Option3Field;
    private javax.swing.JTextField Option4Field;
    private javax.swing.JTextField QuestionField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblQuestions;
    // End of variables declaration//GEN-END:variables
}