/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.border.Border;
import java.lang.Math;
import org.apache.poi.hdgf.chunks.Chunk;

/**
 *
 * @author Dai Phuc
 */
public class TakeExamFrame extends javax.swing.JFrame {

    public CreateExamPanel CreateExamTab;
    public String answer;
    public String studentID = Application.ID;
    public int QuestionID = 1;
    public int no = -1;
    public int min = 0;
    public int sec = 0;
    public int mark = 0;
    public boolean temp = true;
    public int totalMark;

    public double firstNum;
    public double secondNum;
    public String math;
    public boolean turn;

    int i = 0;

    List<String> answerList = new ArrayList(100);
    List<String> studentAnswerList = new ArrayList(100);
    List<String> markList = DAO.getMark(Application.ExamID);

    Timer time;

    List<String> IDList = new ArrayList<>();

    public String studentAnswer = "";

    public TakeExamFrame() {

        initComponents();
        QuestionLabel.setEditable(false);
        QuestionPane.setMaximumSize(new Dimension(100, 25));

        System.out.println(answerList);
        NameTestField.setText(Application.ExamNameTest);
        SubjectField.setText(Application.ExamCourseName);
        ClassCodeField.setText(Application.ExamClassCode);

        NameTestField.setText(Application.ExamNameTest);
        SubjectField.setText(Application.ExamCourseName);
        ClassCodeField.setText(Application.ExamClassCode);

        for (int i = 0; i < 100; i++) {
            answerList.add("0");
        }

        DAO.GetMaxID(Application.ExamID);
        DAO.GetTotalMark(Application.ExamID);

        IDList = DAO.findIDQuestion(Application.ExamID);

        for (int i = 0; i < IDList.size(); i++) {
            studentAnswerList.add("0");
        }
        for (int i = 0; i < IDList.size(); i++) {
            String a = DAO.getAnswer(String.valueOf(IDList.get(i)));
            answerList.set(i, a);
        }

        System.out.println(studentAnswerList + ", " + Application.ExamID);

        totalMark = Application.TotalMark;

        getQuestion();
        System.out.println(mark + " " + Application.grade + " " + no + " " + Application.answer + " ");

        this.setLocationRelativeTo(null);

        time = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                Minutes.setText(String.valueOf(min));
                Seconds.setText(String.valueOf(sec));

                if (sec == 59) {
                    sec = -1;
                    min++;
                    if (min == Application.ExamTime) {
                        time.stop();
                        studentAnswerList.set(no, studentAnswer);
                        checkAnswer(3);
                        submit();
                    }

                }
                sec++;
            }
        });

//        int a = Application.ExamTime * 1000;
//        System.out.println("This is : " + a);
        time.start();
    }

    public void submit() {
//        DAO.submit();

        JOptionPane.showMessageDialog(this, "Your mark is " + mark + "/" + totalMark, "Alert", JOptionPane.INFORMATION_MESSAGE);
        DAO.updateResult(mark);
        CloseFrame();
    }

    public void getQuestion() {

        OptionA.setSelected(false);
        OptionB.setSelected(false);
        OptionC.setSelected(false);
        OptionD.setSelected(false);

        no += 1;
        No.setText(String.valueOf(no + 1) + ":");
        DAO.GetExamQuestion(Application.ExamID, IDList.get(no));

        QuestionLabel.setText(Application.questions);
        OptionA.setText(Application.option1);
        OptionB.setText(Application.option2);
        OptionC.setText(Application.option3);
        OptionD.setText(Application.option4);
        answer = Application.answer;

        temp = true;
        if (no == 0) {
            BackButton.setVisible(false);
        } else {
            BackButton.setVisible(true);
        }

    }

    public void getQuestion2() {

        OptionA.setSelected(false);
        OptionB.setSelected(false);
        OptionC.setSelected(false);
        OptionD.setSelected(false);

        no -= 1;
        No.setText(String.valueOf(no + 1) + ":");
        DAO.GetExamQuestion(Application.ExamID, IDList.get(no));

        QuestionLabel.setText(Application.questions);
        OptionA.setText(Application.option1);
        OptionB.setText(Application.option2);
        OptionC.setText(Application.option3);
        OptionD.setText(Application.option4);
        answer = Application.answer;
        temp = false;

//        QuestionLabel.setEditable(false);
//        QuestionLabel.setLineWrap(true);
//        QuestionLabel.setWrapStyleWord(true);
    }

    public void CloseFrame() {
        this.dispose();
    }

    public void checkAnswer(int id) {

        if (id == 1) {

//            if (studentAnswer.equals(Application.answer)) {
//                mark += Application.grade;
//            }
//            System.out.println(mark + " " + Application.grade + " " + IDList.get(no) + " " + Application.answer + " ");
//        int questionID = Integer.parseInt(Application.QuestionExam_questionID);
            QuestionID += 1;
//            Application.QuestionExam_questionID = String.valueOf(QuestionID);

        } else if (id == 2) {

//            if (studentAnswer.equals(Application.answer)) {
//                mark -= Application.grade;
//            }
            System.out.println(mark + " " + Application.grade + " "
                    + IDList.get(no) + " " + Application.answer + " "
                    + QuestionID);
            QuestionID -= 1;
        } else if (id == 3) {

            for (int i = 0; i < Math.min(answerList.size(), studentAnswerList.size()); i++) {
                if (answerList.get(i).equals(studentAnswerList.get(i))) {
                    mark += Integer.parseInt(markList.get(i));
                }
            }

            System.out.println(mark);

        }

        if (String.valueOf(QuestionID).equals(String.valueOf(IDList.size()))) {
            NextButton.setVisible(false);
        } else {
            NextButton.setVisible(true);
        }
        if (no == 1) {
            BackButton.setVisible(false);
        }

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
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        NameTestField = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        SubjectField = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ClassCodeField = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        No = new javax.swing.JLabel();
        OptionA = new javax.swing.JCheckBox();
        OptionB = new javax.swing.JCheckBox();
        OptionC = new javax.swing.JCheckBox();
        OptionD = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        Minutes = new javax.swing.JLabel();
        Seconds = new javax.swing.JLabel();
        TimeLabel3 = new javax.swing.JLabel();
        NextButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        SubmitButton = new javax.swing.JButton();
        LoadingBar = new javax.swing.JProgressBar();
        CalculatorPane = new javax.swing.JPanel();
        Screen = new javax.swing.JTextField();
        No07 = new javax.swing.JButton();
        No08 = new javax.swing.JButton();
        No09 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        AllButton = new javax.swing.JButton();
        No04 = new javax.swing.JButton();
        No05 = new javax.swing.JButton();
        No06 = new javax.swing.JButton();
        MultipleButton = new javax.swing.JButton();
        DivideButton = new javax.swing.JButton();
        No01 = new javax.swing.JButton();
        No02 = new javax.swing.JButton();
        No03 = new javax.swing.JButton();
        PlusButton = new javax.swing.JButton();
        MinusButton = new javax.swing.JButton();
        No00 = new javax.swing.JButton();
        NoPoint = new javax.swing.JButton();
        Equal = new javax.swing.JButton();
        hideButton = new javax.swing.JButton();
        QuestionPane = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        QuestionLabel = new javax.swing.JEditorPane();
        CalculatorButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(971, 560));

        jPanel2.setBackground(new java.awt.Color(251, 154, 59));

        jLabel6.setBackground(new java.awt.Color(51, 204, 0));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 0));
        jLabel6.setText("Name:");

        NameTestField.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        NameTestField.setText("jLabel3");

        jLabel8.setBackground(new java.awt.Color(51, 204, 0));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 204, 0));
        jLabel8.setText("Subject:");

        SubjectField.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        SubjectField.setText("jLabel3");

        jLabel9.setBackground(new java.awt.Color(51, 204, 0));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 204, 0));
        jLabel9.setText("Class Code: ");

        ClassCodeField.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        ClassCodeField.setText("jLabel3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NameTestField)
                .addGap(36, 36, 36)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SubjectField)
                .addGap(28, 28, 28)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ClassCodeField)
                .addContainerGap(325, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ClassCodeField))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SubjectField)
                        .addComponent(NameTestField)))
                .addGap(20, 20, 20))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(959, 550));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("Question");

        No.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        No.setText("No");

        OptionA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        OptionA.setText("jCheckBox1");
        OptionA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionAActionPerformed(evt);
            }
        });

        OptionB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        OptionB.setText("jCheckBox1");
        OptionB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionBActionPerformed(evt);
            }
        });

        OptionC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        OptionC.setText("jCheckBox1");
        OptionC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionCActionPerformed(evt);
            }
        });

        OptionD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        OptionD.setText("jCheckBox1");
        OptionD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionDActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(51, 204, 0));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 0));
        jLabel7.setText("Time");

        Minutes.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        Minutes.setForeground(new java.awt.Color(255, 51, 0));
        Minutes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        Seconds.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        Seconds.setForeground(new java.awt.Color(255, 51, 0));
        Seconds.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        TimeLabel3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        TimeLabel3.setText(":");

        NextButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/applicationIcon/next-button.png"))); // NOI18N
        NextButton.setText("Next");
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        BackButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/applicationIcon/back.png"))); // NOI18N
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        SubmitButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SubmitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/applicationIcon/submit.png"))); // NOI18N
        SubmitButton.setText("Submit");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });

        LoadingBar.setForeground(Color.red);
        LoadingBar.setBackground(new java.awt.Color(255, 102, 102));
        LoadingBar.setForeground(new java.awt.Color(255, 0, 0));

        CalculatorPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Screen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Screen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScreenActionPerformed(evt);
            }
        });

        No07.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        No07.setText("7");
        No07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No07ActionPerformed(evt);
            }
        });

        No08.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        No08.setText("8");
        No08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No08ActionPerformed(evt);
            }
        });

        No09.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        No09.setText("9");
        No09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No09ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setText("D");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        AllButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AllButton.setText("A");
        AllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllButtonActionPerformed(evt);
            }
        });

        No04.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        No04.setText("4");
        No04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No04ActionPerformed(evt);
            }
        });

        No05.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        No05.setText("5");
        No05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No05ActionPerformed(evt);
            }
        });

        No06.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        No06.setText("6");
        No06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No06ActionPerformed(evt);
            }
        });

        MultipleButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MultipleButton.setText("X");
        MultipleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MultipleButtonActionPerformed(evt);
            }
        });

        DivideButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DivideButton.setText("/");
        DivideButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DivideButtonActionPerformed(evt);
            }
        });

        No01.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        No01.setText("1");
        No01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No01ActionPerformed(evt);
            }
        });

        No02.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        No02.setText("2");
        No02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No02ActionPerformed(evt);
            }
        });

        No03.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        No03.setText("3");
        No03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No03ActionPerformed(evt);
            }
        });

        PlusButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PlusButton.setText("+");
        PlusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlusButtonActionPerformed(evt);
            }
        });

        MinusButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MinusButton.setText("-");
        MinusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinusButtonActionPerformed(evt);
            }
        });

        No00.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        No00.setText("0");
        No00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No00ActionPerformed(evt);
            }
        });

        NoPoint.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NoPoint.setText(".");
        NoPoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoPointActionPerformed(evt);
            }
        });

        Equal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Equal.setText("=");
        Equal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EqualActionPerformed(evt);
            }
        });

        hideButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        hideButton.setText("O");
        hideButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CalculatorPaneLayout = new javax.swing.GroupLayout(CalculatorPane);
        CalculatorPane.setLayout(CalculatorPaneLayout);
        CalculatorPaneLayout.setHorizontalGroup(
            CalculatorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CalculatorPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CalculatorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Screen)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CalculatorPaneLayout.createSequentialGroup()
                        .addComponent(No07, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(No08, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(No09, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CalculatorPaneLayout.createSequentialGroup()
                        .addComponent(No04, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(No05, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(No06, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MultipleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DivideButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CalculatorPaneLayout.createSequentialGroup()
                        .addGroup(CalculatorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CalculatorPaneLayout.createSequentialGroup()
                                .addComponent(No00, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NoPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CalculatorPaneLayout.createSequentialGroup()
                                .addComponent(No01, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(No02, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CalculatorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CalculatorPaneLayout.createSequentialGroup()
                                .addComponent(No03, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PlusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MinusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CalculatorPaneLayout.createSequentialGroup()
                                .addComponent(Equal, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hideButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CalculatorPaneLayout.setVerticalGroup(
            CalculatorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CalculatorPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Screen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CalculatorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(No07)
                    .addComponent(No08)
                    .addComponent(No09)
                    .addComponent(jButton4)
                    .addComponent(AllButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CalculatorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(No04)
                    .addComponent(No05)
                    .addComponent(No06)
                    .addComponent(MultipleButton)
                    .addComponent(DivideButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CalculatorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(No01)
                    .addComponent(No02)
                    .addComponent(No03)
                    .addComponent(PlusButton)
                    .addComponent(MinusButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CalculatorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(No00)
                    .addComponent(NoPoint)
                    .addComponent(Equal)
                    .addComponent(hideButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        QuestionPane.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        QuestionLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(QuestionLabel);

        javax.swing.GroupLayout QuestionPaneLayout = new javax.swing.GroupLayout(QuestionPane);
        QuestionPane.setLayout(QuestionPaneLayout);
        QuestionPaneLayout.setHorizontalGroup(
            QuestionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuestionPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        QuestionPaneLayout.setVerticalGroup(
            QuestionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuestionPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        CalculatorButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CalculatorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/applicationIcon/calculator.png"))); // NOI18N
        CalculatorButton.setText("Calculator");
        CalculatorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculatorButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Minutes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TimeLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Seconds, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap(201, Short.MAX_VALUE)
                                .addComponent(NextButton)
                                .addGap(89, 89, 89)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(SubmitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(63, 63, 63)
                                .addComponent(CalculatorButton))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(No)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(QuestionPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(12, 12, 12)))
                        .addGap(1, 1, 1)
                        .addComponent(CalculatorPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LoadingBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OptionD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OptionB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OptionA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OptionC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(No))
                            .addComponent(QuestionPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CalculatorPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(OptionA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OptionB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OptionC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OptionD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NextButton)
                    .addComponent(BackButton)
                    .addComponent(CalculatorButton))
                .addGap(18, 18, 18)
                .addComponent(SubmitButton)
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Minutes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Seconds, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TimeLabel3))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoadingBar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OptionBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionBActionPerformed
        // TODO add your handling code here:
        if (OptionB.isSelected()) {

            studentAnswer = "B";
            OptionA.setSelected(false);
            OptionC.setSelected(false);
            OptionD.setSelected(false);
        }
    }//GEN-LAST:event_OptionBActionPerformed

    private void OptionCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionCActionPerformed
        // TODO add your handling code here:
        if (OptionC.isSelected()) {

            studentAnswer = "C";
            OptionA.setSelected(false);
            OptionB.setSelected(false);
            OptionD.setSelected(false);
        }
    }//GEN-LAST:event_OptionCActionPerformed

    private void OptionDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionDActionPerformed
        // TODO add your handling code here:
        if (OptionD.isSelected()) {

            studentAnswer = "D";
            OptionA.setSelected(false);
            OptionC.setSelected(false);
            OptionB.setSelected(false);
        }
    }//GEN-LAST:event_OptionDActionPerformed

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        // TODO add your handling code here:
        studentAnswerList.set(no, studentAnswer);
        System.out.println(no + ", " + studentAnswer);
        checkAnswer(1);
        getQuestion();

        //        System.out.println(Application.ExamID + " " + Application.Max + " " + QuestionID + " " + mark + " " +
        //        Application.answer + " " + studentAnswer);
    }//GEN-LAST:event_NextButtonActionPerformed

    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("AnswerList: " + answerList);
        System.out.println(mark);
        studentAnswerList.set(no, studentAnswer);
        System.out.println("student answer List: " + studentAnswerList);

        int response = JOptionPane.showConfirmDialog(this, "Do you want to submit?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            checkAnswer(3);
            DAO.updateResult(mark);
            JOptionPane.showMessageDialog(this, "Your mark is " + mark + "/" + totalMark, "Alert", JOptionPane.INFORMATION_MESSAGE);
            CloseFrame();
            time.stop();
        }

    }//GEN-LAST:event_SubmitButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed

        checkAnswer(2);
        getQuestion2();

//        System.out.println(mark + " " + Application.grade + " " + IDList.get(no) + " " + Application.answer + " ");
    }//GEN-LAST:event_BackButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void No01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No01ActionPerformed
        // TODO add your handling code here:
        if (turn == false) {
            Screen.setText("");
            turn = true;
        }
        Screen.setText(Screen.getText() + "1");
    }//GEN-LAST:event_No01ActionPerformed

    private void OptionAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionAActionPerformed
        // TODO add your handling code here:
        if (OptionA.isSelected()) {

            studentAnswer = "A";
            OptionB.setSelected(false);
            OptionC.setSelected(false);
            OptionD.setSelected(false);

        }
    }//GEN-LAST:event_OptionAActionPerformed

    private void CalculatorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculatorButtonActionPerformed
        // TODO add your handling code here:
        CalculatorPane.setVisible(true);
    }//GEN-LAST:event_CalculatorButtonActionPerformed

    private void No02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No02ActionPerformed
        // TODO add your handling code here:
        if (turn == false) {
            Screen.setText("");
            turn = true;
        }
        Screen.setText(Screen.getText() + "2");
    }//GEN-LAST:event_No02ActionPerformed

    private void No03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No03ActionPerformed
        // TODO add your handling code here:
        if (turn == false) {
            Screen.setText("");
            turn = true;
        }
        Screen.setText(Screen.getText() + "3");
    }//GEN-LAST:event_No03ActionPerformed

    private void No04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No04ActionPerformed
        // TODO add your handling code here:
        if (turn == false) {
            Screen.setText("");
            turn = true;
        }
        Screen.setText(Screen.getText() + "4");
    }//GEN-LAST:event_No04ActionPerformed

    private void No05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No05ActionPerformed
        // TODO add your handling code here:
        if (turn == false) {
            Screen.setText("");
            turn = true;
        }
        Screen.setText(Screen.getText() + "5");
    }//GEN-LAST:event_No05ActionPerformed

    private void No06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No06ActionPerformed
        // TODO add your handling code here:
        if (turn == false) {
            Screen.setText("");
            turn = true;
        }
        Screen.setText(Screen.getText() + "6");
    }//GEN-LAST:event_No06ActionPerformed

    private void No07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No07ActionPerformed
        // TODO add your handling code here:
        if (turn == false) {
            Screen.setText("");
            turn = true;
        }
        Screen.setText(Screen.getText() + "7");
    }//GEN-LAST:event_No07ActionPerformed

    private void No08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No08ActionPerformed
        // TODO add your handling code here:
        if (turn == false) {
            Screen.setText("");
            turn = true;
        }
        Screen.setText(Screen.getText() + "8");
    }//GEN-LAST:event_No08ActionPerformed

    private void No09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No09ActionPerformed
        // TODO add your handling code here:
        if (turn == false) {
            Screen.setText("");
            turn = true;
        }
        Screen.setText(Screen.getText() + "9");
    }//GEN-LAST:event_No09ActionPerformed

    private void No00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No00ActionPerformed
        // TODO add your handling code here:
        if (turn == false) {
            Screen.setText("");
            turn = true;
        }
        Screen.setText(Screen.getText() + "0");
    }//GEN-LAST:event_No00ActionPerformed

    private void NoPointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoPointActionPerformed
        // TODO add your handling code here:
        Screen.setText(Screen.getText() + ".");
    }//GEN-LAST:event_NoPointActionPerformed

    private void EqualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EqualActionPerformed
        // TODO add your handling code here:

        double a = 0;
        secondNum = Float.parseFloat(Screen.getText());

        if (math.equals("plus")) {
            a = firstNum + secondNum;
        } else if (math.equals("minus")) {
            a = firstNum - secondNum;
        } else if (math.equals("divide")) {
            a = firstNum / secondNum;
        } else if (math.equals("multiple")) {
            a = firstNum * secondNum;
        }

        Screen.setText(String.valueOf(a));
        turn = false;
    }//GEN-LAST:event_EqualActionPerformed

    private void AllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllButtonActionPerformed
        // TODO add your handling code here:
        Screen.setText("");
        firstNum = 0;
        secondNum = 0;
        math = "";
    }//GEN-LAST:event_AllButtonActionPerformed

    private void hideButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hideButtonActionPerformed
        // TODO add your handling code here:
        CalculatorPane.setVisible(false);
    }//GEN-LAST:event_hideButtonActionPerformed

    private void PlusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlusButtonActionPerformed
        // TODO add your handling code here:
        math = "add";
        firstNum = Float.parseFloat(Screen.getText());
        Screen.setText("");
    }//GEN-LAST:event_PlusButtonActionPerformed

    private void MinusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinusButtonActionPerformed
        // TODO add your handling code here:
        math = "minus";
        firstNum = Float.parseFloat(Screen.getText());
        Screen.setText("");
    }//GEN-LAST:event_MinusButtonActionPerformed

    private void DivideButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DivideButtonActionPerformed
        // TODO add your handling code here:
        math = "divide";
        firstNum = Float.parseFloat(Screen.getText());
        Screen.setText("");
    }//GEN-LAST:event_DivideButtonActionPerformed

    private void ScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScreenActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_ScreenActionPerformed

    private void MultipleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MultipleButtonActionPerformed
        // TODO add your handling code here:
        math = "multiple";
        firstNum = Float.parseFloat(Screen.getText());
        Screen.setText("");
    }//GEN-LAST:event_MultipleButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        TakeExamFrame tk = new TakeExamFrame();
        tk.setVisible(true);

        int a = Application.ExamTime * 1000;
        try {

            for (int i = 0; i <= a; i++) {
                System.out.println("this is: " + a);
                Thread.sleep(25);
                tk.LoadingBar.setValue(i);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                tk.dispose();
                tk.setVisible(false);
                new LoginFrame().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AllButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JButton CalculatorButton;
    private javax.swing.JPanel CalculatorPane;
    private javax.swing.JLabel ClassCodeField;
    private javax.swing.JButton DivideButton;
    private javax.swing.JButton Equal;
    private javax.swing.JProgressBar LoadingBar;
    private javax.swing.JButton MinusButton;
    private javax.swing.JLabel Minutes;
    private javax.swing.JButton MultipleButton;
    private javax.swing.JLabel NameTestField;
    private javax.swing.JButton NextButton;
    private javax.swing.JLabel No;
    private javax.swing.JButton No00;
    private javax.swing.JButton No01;
    private javax.swing.JButton No02;
    private javax.swing.JButton No03;
    private javax.swing.JButton No04;
    private javax.swing.JButton No05;
    private javax.swing.JButton No06;
    private javax.swing.JButton No07;
    private javax.swing.JButton No08;
    private javax.swing.JButton No09;
    private javax.swing.JButton NoPoint;
    private javax.swing.JCheckBox OptionA;
    private javax.swing.JCheckBox OptionB;
    private javax.swing.JCheckBox OptionC;
    private javax.swing.JCheckBox OptionD;
    private javax.swing.JButton PlusButton;
    private javax.swing.JEditorPane QuestionLabel;
    private javax.swing.JPanel QuestionPane;
    private javax.swing.JTextField Screen;
    private javax.swing.JLabel Seconds;
    private javax.swing.JLabel SubjectField;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JLabel TimeLabel3;
    private javax.swing.JButton hideButton;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
