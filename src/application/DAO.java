/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

/**
 *
 * @author Dai Phuc
 */
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
//import javax.activation.*;
//import javax.activation.*;  

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DAO {

    public static List<Course> findAll() {

        List<Course> CourseList = new ArrayList<>();

        Connection conn = null;
        Statement statement = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "select * from course";
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                Course c = new Course();
                c.setCourseName(rs.getString("courseName"));
                c.setCourseCode(rs.getString("courseCode"));
                c.setClassCode(rs.getString("classCode"));
                c.setTutor(rs.getString("tutor"));
                c.setAmount(rs.getInt("amount"));
                c.setCredits(rs.getInt("credits"));

                CourseList.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return CourseList;

    }

    public static List<QuestionExam> findQuestionExam(String ID) {

        List<QuestionExam> QuestionExamList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "select * from questionExam where IDTest = ?";
            statement = conn.prepareCall(sql);

            statement.setString(1, ID);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                QuestionExam q = new QuestionExam();
                q.setID(resultSet.getString("IDTest"));
                q.setQuestionID(resultSet.getString("questionID"));
                QuestionExamList.add(q);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return QuestionExamList;
    }

    public static List<Question> findQuestion() {

        List<Question> QuestionList = new ArrayList<>();

        Connection conn = null;
        Statement statement = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "select * from questions";
            statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                Question q = new Question();

                q.setCourse(resultSet.getString("course"));
                q.setQuestions(resultSet.getString("questions"));
                q.setAnswer(resultSet.getString("answer"));
                q.setGrade(resultSet.getInt("grade"));
                q.setId(resultSet.getString("id"));
                q.setOption1(resultSet.getString("option1"));
                q.setOption2(resultSet.getString("option2"));
                q.setOption3(resultSet.getString("option3"));
                q.setOption4(resultSet.getString("option4"));

                QuestionList.add(q);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return QuestionList;
    }

    public static List<Question> findRandomQuestion(int mark3, int mark4, int mark5) {

        List<Question> QuestionList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "select * from (select * from questions where grade = '3' order by rand() limit ?) as a\n"
                    + "	union \n"
                    + "	select * from (select * from questions where grade = '4' order by rand() limit ?) as b\n"
                    + "	union\n"
                    + "	select * from (select * from questions where grade = '5' order by rand() limit ?) as c;";
            statement = conn.prepareCall(sql);

            statement.setInt(1, mark3);
            statement.setInt(2, mark4);
            statement.setInt(3, mark5);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Question q = new Question();

                q.setCourse(resultSet.getString("course"));
                q.setQuestions(resultSet.getString("questions"));
                q.setAnswer(resultSet.getString("answer"));
                q.setGrade(resultSet.getInt("grade"));
                q.setId(resultSet.getString("id"));
                q.setOption1(resultSet.getString("option1"));
                q.setOption2(resultSet.getString("option2"));
                q.setOption3(resultSet.getString("option3"));
                q.setOption4(resultSet.getString("option4"));

                insertQuestionExam(Application.ExamID, q.getId());

                QuestionList.add(q);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return QuestionList;
    }

    public static List<Course> findAllClass() {

        List<Course> CourseList = new ArrayList<>();

        Connection conn = null;
        Statement statement = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "select distinct courseName, tutor, credits, class.classCode, class.courseCode, amount from class "
                    + "inner join course on class.courseCode = course.courseCode where userID = '" + Application.ID + "'";
            statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                Course c = new Course();
                c.setCourseName(rs.getString("courseName"));
                c.setCourseCode(rs.getString("courseCode"));
                c.setClassCode(rs.getString("classCode"));
                c.setTutor(rs.getString("tutor"));
                c.setAmount(rs.getInt("amount"));
                c.setCredits(rs.getInt("credits"));

                CourseList.add(c);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return CourseList;

    }

    public static List<Exam> findAllExam() {

        List<Exam> ExamList = new ArrayList<>();

        Connection conn = null;
        Statement statement = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "select nameTest, ID, courseName, tutor, exam.classCode, exam.courseCode, length from exam "
                    + "inner join class on class.classCode = exam.classCode and class.courseCode = exam.courseCode where userID = '" + Application.ID + "'";
            statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                Exam c = new Exam();
                c.setNameTest(rs.getString("nameTest"));
                c.setCourseName(rs.getString("courseName"));
                c.setCourseCode(rs.getString("courseCode"));
                c.setClassCode(rs.getString("classCode"));
                c.setTutor(rs.getString("tutor"));
                c.setLength(rs.getInt("length"));
                c.setID(rs.getString("ID"));

                ExamList.add(c);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ExamList;

    }

    public static List<User> findTutorUser() {

        List<User> UserList = new ArrayList<>();

        Connection conn = null;
        Statement statement = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "select * from user where id like 't%';";
            statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                User c = new User();
                c.setUserName(rs.getString("userName"));
                c.setGender(rs.getString("gender"));
                c.setDOB(rs.getString("DOB"));
                c.setEmail(rs.getString("email"));
                c.setPhone(rs.getString("phone"));
                c.setID(rs.getString("ID"));

                UserList.add(c);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return UserList;

    }

    public static List<Course> findTutorClass(String ID) {
        List<Course> CourseList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "select * from course where tutor like ?";
            statement = conn.prepareCall(sql);

            statement.setString(1, "%" + ID + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Course c = new Course();
                c.setCourseName(resultSet.getString("courseName"));
                c.setTutor(resultSet.getString("tutor"));
                c.setCredits(resultSet.getInt("credits"));
                c.setClassCode(resultSet.getString("classCode"));
                c.setCourseCode(resultSet.getString("courseCode"));
                c.setAmount(resultSet.getInt("amount"));

                CourseList.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return CourseList;
    }

    public static List<Course> findByFullName(String search) {

        List<Course> CourseList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "select * from course where courseName like ? or courseCode like ?";
            statement = conn.prepareCall(sql);

            statement.setString(1, "%" + search + "%");
            statement.setString(2, "%" + search + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Course c = new Course();
                c.setCourseName(resultSet.getString("courseName"));
                c.setTutor(resultSet.getString("tutor"));
                c.setCredits(resultSet.getInt("credits"));
                c.setClassCode(resultSet.getString("classCode"));
                c.setCourseCode(resultSet.getString("courseCode"));
                c.setAmount(resultSet.getInt("amount"));

                CourseList.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return CourseList;

    }

    public static boolean search(String searchString) {

        Connection conn = null;
        PreparedStatement statement = null;

        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "select courseName from course where courseName = ? or courseCode = ?";
            statement = conn.prepareCall(sql);

            statement.setString(1, searchString);
            statement.setString(2, searchString);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

//    public static boolean 
    public static int login(String ID, String pass) {

        Connection conn = null;
        PreparedStatement statement = null;
        int res = 1;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?allowPublicKeyRetrieval=true&user=root&useSSL=false&password=daiphucprohehe");
            PreparedStatement passnew = conn.prepareStatement("select * from user where ID = '" + ID + "' and pass = '" + pass + "'", ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = passnew.executeQuery();
            if (!rs.isBeforeFirst()) {
                res = 0;
            } else if (rs.next()) {

                Application.userName = rs.getString("userName");
                Application.ID = rs.getString("ID");
                Application.email = rs.getString("email");
                Application.phone = rs.getString("phone");
                Application.password = rs.getString("pass");
                Application.DOB = rs.getString("DOB");
                Application.gender = rs.getString("gender");
                Application.job = rs.getString("job");
                Application.Email = rs.getString("email");
                Application.image = rs.getBytes("image");

                if (Application.job.equals("tutor")) {
                    res = 1;
                } else if (Application.job.equals("student")) {
                    res = 2;
                } else if (Application.job.equals("admin")) {
                    res = 3;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void getOpiton(String Id) {

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?allowPublicKeyRetrieval=true&user=root&useSSL=false&password=daiphucprohehe");
            PreparedStatement passnew = conn.prepareStatement("select * from questions where ID = Id",
                    ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = passnew.executeQuery();

            Application.option1 = rs.getString("option1");
            Application.option2 = rs.getString("option2");
            Application.option3 = rs.getString("option3");
            Application.option4 = rs.getString("option4");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int register(String name, String gender, String DOB, String email, String phone, String ID, String pass, byte[] image) {

        Connection conn = null;
        PreparedStatement statement = null;
        int res = 1;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            PreparedStatement passnew = conn.prepareStatement("call add_acc_user(?, ?, ?, ?, ?, ?, ?, ?, ?)", ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            passnew.setString(1, name);
            passnew.setString(2, gender);
            passnew.setString(3, DOB);
            passnew.setString(4, email);
            passnew.setString(5, phone);
            passnew.setString(6, ID);
            passnew.setString(7, pass);
            passnew.setString(8, "student");
            passnew.setBytes(9, image);
            ResultSet rs = passnew.executeQuery();

            Application.userName = name;
            Application.gender = gender;
            Application.DOB = DOB;
            Application.email = email;
            Application.phone = phone;
            Application.ID = ID;
            Application.password = pass;
            Application.job = "student";
            Application.image = image;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static boolean check(String ID) {

        Connection conn = null;
        PreparedStatement statement = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            PreparedStatement passnew = conn.prepareStatement("select * from class where userID = ? and courseCode = ?", ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            passnew.setString(1, ID);
            passnew.setString(2, Application.courseCode);
            ResultSet rs = passnew.executeQuery();

            if (rs.isBeforeFirst()) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void add() {

        Connection conn = null;
        PreparedStatement statement = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            PreparedStatement passnew = conn.prepareStatement("call add_class(?, ?, ?)", ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            passnew.setString(1, Application.ID);
            passnew.setString(2, Application.classCode);
            passnew.setString(3, Application.courseCode);

            ResultSet rs = passnew.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void remove() {

        Connection conn = null;
        PreparedStatement statement = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            PreparedStatement passnew = conn.prepareStatement("call remove_class(?, ?)", ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            passnew.setString(1, Application.ID);
            passnew.setString(2, Application.courseCode);

            ResultSet rs = passnew.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void insert(Course c) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?allowPublicKeyRetrieval=true &user=root&useSSL=false&password=daiphucprohehe");
            String sql = "call insert_course(?, ?, ?, ?, ?, ?);";
            statement = conn.prepareCall(sql);

            statement.setString(1, c.getCourseName());
            statement.setString(2, c.getTutor());
            statement.setInt(3, c.getCredits());
            statement.setString(4, c.getClassCode());
            statement.setString(5, c.getCourseCode());
            statement.setInt(6, c.getAmount());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Noi ket khong thanh cong " + e.getMessage());
        }
    }

    public static void insertQuestion(Question q) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?allowPublicKeyRetrieval=true &user=root&useSSL=false&password=daiphucprohehe");
            String sql = "call insert_question(?, ?, ?, ?, ?, ?, ?, ?, ?);";
            statement = conn.prepareCall(sql);

            statement.setString(1, q.getId());
            statement.setString(2, q.getQuestions());
            statement.setString(3, q.getOption1());
            statement.setString(4, q.getOption2());
            statement.setString(5, q.getOption3());
            statement.setString(6, q.getOption4());
            statement.setString(7, q.getAnswer());
            statement.setInt(8, q.getGrade());
            statement.setString(9, q.getCourse());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Noi ket khong thanh cong " + e.getMessage());
        }
    }

    public static void insertExam(Exam e) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?allowPublicKeyRetrieval=true &user=root&useSSL=false&password=daiphucprohehe");
            String sql = "call insert_exam(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            statement = conn.prepareCall(sql);

            statement.setString(1, e.getCourseName());
            statement.setString(2, e.getTutor());
            statement.setString(3, e.getClassCode());
            statement.setString(4, e.getCourseCode());
            statement.setInt(5, e.getLength());
            statement.setString(6, e.getNameTest());
            statement.setString(7, Application.ID);
            statement.setString(8, "0");
            statement.setString(9, null);
            statement.setString(10, e.getID());
            statement.setString(11, null);

            statement.executeUpdate();

        } catch (Exception t) {
            t.printStackTrace();
            System.out.println("Noi ket khong thanh cong " + t.getMessage());
        }
    }

    public static boolean checkUser(String id, String pass) {

        Connection conn = null;
        PreparedStatement statement = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            PreparedStatement passnew = conn.prepareStatement("select * from user where ID = ? or pass = ?", ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            passnew.setString(1, id);
            passnew.setString(2, pass);
            ResultSet rs = passnew.executeQuery();

            if (rs.next()) {

                return false;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean check(String ID, int choice) {

        Connection conn = null;
        PreparedStatement passnew = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            if (choice == 1) {

                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
                passnew = conn.prepareStatement("select * from questions where id = ?", ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);

            } else if (choice == 2) {

                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
                passnew = conn.prepareStatement("select * from exam where id = ?", ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);

            } else if (choice == 3) {

                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
                passnew = conn.prepareStatement("select * from questionExam where questionID = ?", ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);

            }

            passnew.setString(1, ID);
            ResultSet rs = passnew.executeQuery();

            if (rs.isBeforeFirst()) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void modify(Question q) {

        Connection conn = null;
        PreparedStatement statement = null;

        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "update questions set id = ?, questions = ?, option1 = ?, option2 = ?, option3 = ?, "
                    + "option4 = ?, answer = ?, grade = ?, course = ? where id = ?";
            statement = conn.prepareCall(sql);

            statement.setString(1, q.getId());
            statement.setString(2, q.getQuestions());
            statement.setString(3, q.getOption1());
            statement.setString(4, q.getOption2());
            statement.setString(5, q.getOption3());
            statement.setString(6, q.getOption4());
            statement.setString(7, q.getAnswer());
            statement.setInt(8, q.getGrade());
            statement.setString(9, q.getCourse());
            statement.setString(10, q.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Noi ket khong thanh cong " + e.getMessage());
        }
    }

    public static void removeCourse(String ClassCode, String CourseCode) {

        Connection conn = null;
        PreparedStatement statement = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            PreparedStatement passnew = conn.prepareStatement("call remove_course(?, ?)", ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            passnew.setString(1, CourseCode);
            passnew.setString(2, ClassCode);

            ResultSet rs = passnew.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void removeQuestions(String id) {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "call QuestionDelete(?)";
            statement = conn.prepareCall(sql);
            statement.setString(1, id);
            statement.execute();
        } catch (Exception e) {
            System.out.println("Noi ket khong thanh cong " + e.getMessage());
        }
    }

    public static void findCourseName(String id) {

        Connection conn = null;
        PreparedStatement statement = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            PreparedStatement passnew = conn.prepareStatement("select * from exam where ID = ?", ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            passnew.setString(1, id);
            ResultSet rs = passnew.executeQuery();

            if (rs.next()) {

                Application.ExamID = rs.getString("ID");
                Application.ExamNameTest = rs.getString("nameTest");
                Application.ExamCourseName = rs.getString("courseName");
                Application.ExamClassCode = rs.getString("classCode");
                Application.ExamCourseCode = rs.getString("courseCode");
                Application.ExamTime = rs.getInt("length");
                Application.Activate = rs.getInt("activate");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Exam> findExam(String id) {

        List<Exam> ExamList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement statement = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "select * from exam where IDTutor like ?;";
            statement = conn.prepareCall(sql);

            statement.setString(1, id);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                Exam c = new Exam();
                c.setNameTest(rs.getString("nameTest"));
                c.setCourseName(rs.getString("courseName"));
                c.setCourseCode(rs.getString("courseCode"));
                c.setClassCode(rs.getString("classCode"));
                c.setTutor(rs.getString("tutor"));
                c.setLength(rs.getInt("length"));
                c.setID(rs.getString("ID"));
                c.setActivate(rs.getString("activate"));
                c.setTime(rs.getString("time"));
                c.setDate(rs.getString("date"));

                ExamList.add(c);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ExamList;
    }

    public static void getTimeDate(String ID) {

        Connection conn = null;
        PreparedStatement statement = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            PreparedStatement passnew = conn.prepareStatement("select time, date from exam where id = ?", ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            passnew.setString(1, Application.ExamID);
            ResultSet rs = passnew.executeQuery();

            if (rs.next()) {

                Application.ExamTimeStart = rs.getString("time");
                Application.ExamDate = rs.getString("date");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteExam(String ID) {

        Connection conn = null;
        PreparedStatement statement = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            PreparedStatement passnew = conn.prepareStatement("call remove_Exam(?)", ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            passnew.setString(1, Application.ExamID);

            ResultSet rs = passnew.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void insertQuestionExam(String IDTest, String questionID) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?allowPublicKeyRetrieval=true &user=root&useSSL=false&password=daiphucprohehe");
            String sql = "call insert_questionExam(?, ?);";
            statement = conn.prepareCall(sql);

            statement.setString(1, IDTest);
            statement.setString(2, questionID);

            statement.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Noi ket khong thanh cong " + e.getMessage());
        }
    }

    public static void removeQuestionsExam(String IDTest, String ID) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            PreparedStatement passnew = conn.prepareStatement("call QuestionExamDelete(?, ?);", ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            passnew.setString(1, IDTest);
            passnew.setString(2, ID);

            ResultSet rs = passnew.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clear(String IDTest) {

        Connection conn = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            PreparedStatement passnew = conn.prepareStatement("delete from questionExam where IDTest = ?;", ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            passnew.setString(1, IDTest);

            passnew.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void insertDate(String StudentID, String IDTest) {

        Connection conn = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            PreparedStatement passnew = conn.prepareStatement("insert into result values(?, ?, null, current_timestamp()); ", ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            passnew.setString(1, StudentID);
            passnew.setString(2, IDTest);

            passnew.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static String findQuestion2(String ID){
//        
//        Connection conn = null;
//        PreparedStatement statement = null;
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?allowPublicKeyRetrieval=true&user=root&useSSL=false&password=daiphucprohehe");
//            PreparedStatement passnew = conn.prepareStatement("select questions from questions where ID = ?",
//                    ResultSet.CONCUR_UPDATABLE);
//
//            passnew.setString(1, ID);
//            ResultSet rs = passnew.executeQuery();
//            
//            rs.getString("questions") = Application.questions;
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        return ID;
//    }
    //CreateExamPanel
    public static List<Question> findQuestionExam2(String ID) {

        List<Question> QuestionList = new ArrayList<>();

        Connection conn = null; 
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "select * from questions as q inner join questionExam as qe on \n"
                    + "	q.id = qe.questionID where IDTest = ?;";
            statement = conn.prepareCall(sql);

            statement.setString(1, ID);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Question q = new Question();
                q.setIDTest(resultSet.getString("IDTest"));
                q.setQuestions(resultSet.getString("questions"));
                q.setId(resultSet.getString("ID"));
                QuestionList.add(q);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return QuestionList;
    }
    
    public static String getAnswer(String IDQuestion) {
        
        String AnswerList = new String();
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            
            String sql = "select answer from questions as q inner join \n" +
"	questionExam as qe where questionID = ? and q.id = qe.questionID;";
            
            statement = conn.prepareCall(sql);

            statement.setString(1, IDQuestion);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                String r = new String();
                r = resultSet.getString("answer");
                AnswerList = r;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return AnswerList;
    }
    
    public static List<String> getMark(String ID) {
        
        List<String> MarkList = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            
            String sql = "select grade from questions as q inner join \n" +
"	questionExam as qe where idTest = ? and q.id = qe.questionID;";
            
            statement = conn.prepareCall(sql);

            statement.setString(1, ID);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                String r = new String();
                r = resultSet.getString("grade");
                MarkList.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return MarkList;
    }

    public static List<Result> findResult(String ID) {

        List<Result> ResultList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            
            String sql = "select * from result as r inner join\n"
                    + "	exam as e on r.testID = e.ID inner join\n"
                    + " user as u on r.studentID = u.ID where studentID = ? ;";
            
            statement = conn.prepareCall(sql);

            statement.setString(1, ID);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Result r = new Result();
                r.setStudent(resultSet.getString("userName"));
                r.setID(resultSet.getString("studentID"));
                r.setSubject(resultSet.getString("courseName"));
                r.setCourseCode(resultSet.getString("courseCode"));
                r.setTime(resultSet.getInt("length"));
                r.setClassCode(resultSet.getString("classCode"));
                r.setGrade(resultSet.getInt("mark"));
                r.setExamNameTest(resultSet.getString("nameTest"));
                r.setTutor(resultSet.getString("tutor"));
                r.setTimeStart(resultSet.getString("date"));
                ResultList.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultList;
    }

    public static List<Result> findResult2() {

        List<Result> ResultList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "select * from result as r inner join\n"
                    + "	exam as e on r.testID = e.ID inner join\n"
                    + "    user as u on r.studentID = u.ID;";
            statement = conn.prepareCall(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Result r = new Result();
                r.setStudent(resultSet.getString("userName"));
                r.setID(resultSet.getString("studentID"));
                r.setSubject(resultSet.getString("courseName"));
                r.setCourseCode(resultSet.getString("courseCode"));
                r.setTime(resultSet.getInt("length"));
                r.setClassCode(resultSet.getString("classCode"));
                r.setGrade(resultSet.getInt("mark"));
                r.setExamNameTest(resultSet.getString("nameTest"));
                r.setTutor(resultSet.getString("tutor"));
                ResultList.add(r);
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultList;
    }

    public static boolean findQuestion2(String id) {

        Connection conn = null;
        PreparedStatement statement = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            PreparedStatement passnew = conn.prepareStatement("select * from questions where ID = ?", ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            passnew.setString(1, id);
            ResultSet rs = passnew.executeQuery();

            if (rs.next()) {

                Application.questions = rs.getString("questions");
                Application.option1 = rs.getString("option1");
                Application.option2 = rs.getString("option2");
                Application.option3 = rs.getString("option3");
                Application.option4 = rs.getString("option4");
                Application.answer = rs.getString("answer");
                Application.courseCode = rs.getString("course");
                Application.grade = rs.getInt("grade");
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<String> findIDQuestion(String ID) {

        List<String> IDList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "select * from questionExam where IDTest = ?";

            statement = conn.prepareCall(sql);

            statement.setString(1, ID);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                IDList.add(resultSet.getString("questionID"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return IDList;

    }

    public static void GetExamQuestion(String ID, String IdQuestion) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?allowPublicKeyRetrieval=true&user=root&useSSL=false&password=daiphucprohehe");
            PreparedStatement passnew = conn.prepareStatement("select *, sum(grade) from questions as q inner join questionExam as qe on \n"
                    + "	q.id = qe.questionID where IDTest = ? and questionID = ?;", ResultSet.CONCUR_UPDATABLE);

            passnew.setString(1, ID);
            passnew.setString(2, String.valueOf(IdQuestion));

            ResultSet rs = passnew.executeQuery();

            if (rs.next()) {

                Application.questions = rs.getString("questions");
                Application.option1 = rs.getString("option1");
                Application.option2 = rs.getString("option2");
                Application.option3 = rs.getString("option3");
                Application.option4 = rs.getString("option4");
                Application.answer = rs.getString("answer");
                Application.grade = rs.getInt("grade");
                Application.TotalMark = rs.getInt("sum(grade)");
                Application.QuestionExam_questionID = rs.getString("questionID");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void GetMaxID(String ID) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?allowPublicKeyRetrieval=true&user=root&useSSL=false&password=daiphucprohehe");
            PreparedStatement passnew = conn.prepareStatement("select max(id) from questions as q inner join questionExam as qe on \n"
                    + "	q.id = qe.questionID where IDTest = ?;", ResultSet.CONCUR_UPDATABLE);

            passnew.setString(1, ID);
//            passnew.setString(2, ID);
            ResultSet rs = passnew.executeQuery();

            if (rs.next()) {

                Application.Max = Integer.parseInt(rs.getString("max(id)"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateResult(int mark) {

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?allowPublicKeyRetrieval=true &user=root&useSSL=false&password=daiphucprohehe");
            String sql = "call update_result(?, ?, ?);";
            statement = conn.prepareCall(sql);

            statement.setString(1, Application.ID);
            statement.setString(2, Application.ExamID);
            statement.setInt(3, mark);

            statement.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Noi ket khong thanh cong " + e.getMessage());
        }

    }

    public static boolean checkExam(String studentID, String ExamID) {

        Connection conn = null;
        PreparedStatement statement = null;

        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            String sql = "select * from result where studentID = ? and testID = ?";
            statement = conn.prepareCall(sql);

            statement.setString(1, studentID);
            statement.setString(2, ExamID);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return true;
            }
            return false;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public static void GetTotalMark(String ID) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?allowPublicKeyRetrieval=true&user=root&useSSL=false&password=daiphucprohehe");
            PreparedStatement passnew = conn.prepareStatement("select sum(grade) from questions as q inner join questionExam as qe on \n"
                    + "	q.id = qe.questionID where IDTest = ?;", ResultSet.CONCUR_UPDATABLE);

            passnew.setString(1, ID);

            ResultSet rs = passnew.executeQuery();

            if (rs.next()) {

                Application.TotalMark = rs.getInt("sum(grade)");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int totalQuesiton(String ID) {
        Connection conn = null;
        PreparedStatement statement = null;
        int res = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?allowPublicKeyRetrieval=true&user=root&useSSL=false&password=daiphucprohehe");
            PreparedStatement passnew = conn.prepareStatement("select count(grade) from questions where grade = ?;", ResultSet.CONCUR_UPDATABLE);

            passnew.setString(1, ID);

            ResultSet rs = passnew.executeQuery();

            if (rs.next()) {

                res = rs.getInt("count(grade)");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void eraseQuestion(String ID) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?user=root&useSSL=false&password=daiphucprohehe");
            PreparedStatement passnew = conn.prepareStatement("call eraseQuestion(?)", ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            passnew.setString(1, ID);

            ResultSet rs = passnew.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean sendingEmail(String email) throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;

        if (!email.equals("")) {

            String toEmail = "phucb1910688@student.ctu.eud.vn";
            String from = "phanbadaiphuc69@gamil.com";
            String password = "0918090705";

            Properties properties = System.getProperties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, password);
                }
            });

            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
                message.setSubject("Email of your grade in class: " + Application.course);
                message.setText("Hi, your grade is " + Application.grade + "\n" + "If you have any questions, feel free to ask.");
                Transport.send(message);
            } catch (Exception e) {
                e.printStackTrace();
            }

//            Message message = prepareMessage(session, Application.Email, toEmail);
            System.out.println("Message sent successfully");
            return true;
        }
        return false;

    }

    public static void send(String to, String sub, String msg, final String user, final String pass) {
        //create an instance of Properties Class   
        Properties props = new Properties();

        /* Specifies the IP address of your default mail server
     	   for e.g if you are using gmail server as an email sever
           you will pass smtp.gmail.com as value of mail.smtp host. 
           As shown here in the code. 
           Change accordingly, if your email id is not a gmail id
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        //below mentioned mail.smtp.port is optional
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        /* Pass Properties object(props) and Authenticator object   
           for authentication to Session instance 
         */
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        try {

            /* Create an instance of MimeMessage, 
 	      it accept MIME types and headers 
             */
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setContent(msg, "text/html");

            /* Transport class is used to deliver the message to the recipients */
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void exportExcelStudent() {

        JFileChooser excelFile = new JFileChooser("C:\\Users\\Dai Phuc\\Desktop");
        int excelChooser = excelFile.showSaveDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            int rownum = 0;

            XSSFWorkbook excel = new XSSFWorkbook();
            XSSFSheet excelSheet = excel.createSheet("Course");
            CellStyle style = excel.createCellStyle();
            XSSFFont font = excel.createFont();
            style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.index);
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle style2 = excel.createCellStyle();

            style2.setBorderBottom(BorderStyle.THIN);
            style2.setBorderTop(BorderStyle.THIN);
            style2.setBorderRight(BorderStyle.THIN);
            style2.setBorderLeft(BorderStyle.THIN);

            style.setBorderBottom(BorderStyle.THIN);
            style.setBorderTop(BorderStyle.THIN);
            style.setBorderRight(BorderStyle.THIN);
            style.setBorderLeft(BorderStyle.THIN);

            style.setFont(font);
            font.setBold(true);
//            font.setColor(HSSFColor.ORANGE.index);

            excelSheet.setColumnWidth(0, 25 * 256);
            excelSheet.setColumnWidth(1, 25 * 128);
            excelSheet.setColumnWidth(2, 25 * 256);

            XSSFRow excelRow = null;
            XSSFCell excelCell = null;

            excelRow = excelSheet.createRow(0);
//            excelRow.setRowStyle(style);

            XSSFCell excelCell1 = excelRow.createCell(0);
            excelCell1.setCellStyle(style);
            excelCell1.setCellValue("Course Name");

            XSSFCell excelCell2 = excelRow.createCell(1);
            excelCell2.setCellStyle(style);
            excelCell2.setCellValue("Name Test");

            XSSFCell excelCell3 = excelRow.createCell(2);
            excelCell3.setCellStyle(style);
            excelCell3.setCellValue("Tutor Name");

            XSSFCell excelCell4 = excelRow.createCell(3);
            excelCell4.setCellStyle(style);

            excelCell4.setCellValue("Course ID");
            XSSFCell excelCell5 = excelRow.createCell(4);
            excelCell5.setCellStyle(style);
            excelCell5.setCellValue("Class");

            XSSFCell excelCell6 = excelRow.createCell(5);
            excelCell6.setCellStyle(style);
            excelCell6.setCellValue("Grade");

            Result x = new Result();
            List<Result> rs = findResult2();

            for (Result i : rs) {

                excelRow = excelSheet.createRow(rownum + 1);

                excelCell = excelRow.createCell(0, CellType.STRING);
                excelCell.setCellStyle(style2);
                excelCell.setCellValue(i.getSubject().toString());

                excelCell = excelRow.createCell(1, CellType.STRING);
                excelCell.setCellStyle(style2);
                excelCell.setCellValue(i.getExamNameTest().toString());

                excelCell = excelRow.createCell(2, CellType.STRING);
                excelCell.setCellStyle(style2);
                excelCell.setCellValue(i.getTutor().toString());

                excelCell = excelRow.createCell(3, CellType.STRING);
                excelCell.setCellValue(i.getID().toString());
                excelCell.setCellStyle(style2);

                excelCell = excelRow.createCell(4, CellType.STRING);
                excelCell.setCellValue(i.getClassCode().toString());
                excelCell.setCellStyle(style2);

                excelCell = excelRow.createCell(5, CellType.STRING);
                excelCell.setCellValue(i.getGrade());

                excelCell.setCellStyle(style2);

                rownum++;
            }

            FileOutputStream excelaFIS;
            BufferedOutputStream excelBOU;

            try {

                excelaFIS = new FileOutputStream(excelFile.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelaFIS);
                excel.write(excelBOU);
                excelBOU.close();
                excel.close();
                JOptionPane.showMessageDialog(null, "Succesfully Exported");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void exportExcelTutor(JTable tbl) {

        JFileChooser excelFile = new JFileChooser("C:\\Users\\Dai Phuc\\Desktop");
        int excelChooser = excelFile.showSaveDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            int rownum = 0;

            XSSFWorkbook excel = new XSSFWorkbook();
            XSSFSheet excelSheet = excel.createSheet("Course");
            CellStyle style = excel.createCellStyle();
            XSSFFont font = excel.createFont();
            style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.index);
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle style2 = excel.createCellStyle();

            style2.setBorderBottom(BorderStyle.THIN);
            style2.setBorderTop(BorderStyle.THIN);
            style2.setBorderRight(BorderStyle.THIN);
            style2.setBorderLeft(BorderStyle.THIN);

            style.setBorderBottom(BorderStyle.THIN);
            style.setBorderTop(BorderStyle.THIN);
            style.setBorderRight(BorderStyle.THIN);
            style.setBorderLeft(BorderStyle.THIN);

            style.setFont(font);
            font.setBold(true);
//            font.setColor(HSSFColor.ORANGE.index);

            excelSheet.setColumnWidth(0, 25 * 256);
            excelSheet.setColumnWidth(1, 25 * 128);
            excelSheet.setColumnWidth(2, 25 * 256);

            XSSFRow excelRow = null;
            XSSFCell excelCell = null;

            excelRow = excelSheet.createRow(0);
//            excelRow.setRowStyle(style);

            XSSFCell excelCell1 = excelRow.createCell(0);
            excelCell1.setCellStyle(style);
            excelCell1.setCellValue("Student");

            XSSFCell excelCell2 = excelRow.createCell(1);
            excelCell2.setCellStyle(style);
            excelCell2.setCellValue("ID");

            XSSFCell excelCell3 = excelRow.createCell(2);
            excelCell3.setCellStyle(style);
            excelCell3.setCellValue("Subject");

            XSSFCell excelCell4 = excelRow.createCell(3);
            excelCell4.setCellStyle(style);
            excelCell4.setCellValue("Class ");

            XSSFCell excelCell5 = excelRow.createCell(4);
            excelCell5.setCellStyle(style);
            excelCell5.setCellValue("Mid Term");

            XSSFCell excelCell6 = excelRow.createCell(5);
            excelCell6.setCellStyle(style);
            excelCell6.setCellValue("Final");

            if (tbl.getRowCount() == 0) {

                System.out.println("Dont have data!");
                Result x = new Result();
                List<Result> rs = findResult2();

                String classCode = rs.get(0).getClassCode().toString();
                String courseCode = rs.get(0).getCourseCode().toString();

                for (Result i : rs) {

                    if (!classCode.equals(i.getClassCode().toString()) || !courseCode.equals(i.getCourseCode().toString())) {
                        rownum++;
                    }

                    excelRow = excelSheet.createRow(rownum + 1);

                    excelCell = excelRow.createCell(0, CellType.STRING);
                    excelCell.setCellStyle(style2);
                    excelCell.setCellValue(i.getStudent().toString());

                    excelCell = excelRow.createCell(1, CellType.STRING);
                    excelCell.setCellStyle(style2);
                    excelCell.setCellValue(i.getID().toString());

                    excelCell = excelRow.createCell(2, CellType.STRING);
                    excelCell.setCellStyle(style2);
                    excelCell.setCellValue(i.getSubject().toString());

                    excelCell = excelRow.createCell(3, CellType.STRING);
                    excelCell.setCellValue(i.getClassCode().toString());
                    classCode = i.getClassCode().toString();
                    excelCell.setCellStyle(style2);

                    excelCell = excelRow.createCell(4, CellType.STRING);
                    excelCell.setCellValue(i.getGrade());
                    excelCell.setCellStyle(style2);

                    courseCode = i.getCourseCode().toString();

                    rownum++;
                }
            }
            if (tbl.getRowCount() != 0 && tbl.getColumnCount() != 0) {

                for (int i = 0; i < tbl.getRowCount(); i++) {
                    excelRow = excelSheet.createRow(i + 1);
                    for (int j = 0; j < tbl.getColumnCount(); j++) {
                        System.out.println("Have data");
                        excelCell = excelRow.createCell(j);
                        excelCell.setCellValue(tbl.getValueAt(i, j).toString());

                    }

                }
            }

            System.out.println(tbl.getRowCount() + " " + tbl.getColumnCount());

            FileOutputStream excelaFIS;
            BufferedOutputStream excelBOU;

            try {

                excelaFIS = new FileOutputStream(excelFile.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelaFIS);
                excel.write(excelBOU);
                excelBOU.close();
                excel.close();
                JOptionPane.showMessageDialog(null, "Succesfully Exported");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void update(String userName, String gender, String DOB, String email, String phone, String password, String ID) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online?allowPublicKeyRetrieval=true&user=root&useSSL=false&password=daiphucprohehe");
            PreparedStatement passnew = conn.prepareStatement("update user set userName = ?, DOB = ?, email = ?"
                    + ", phone = ?, pass = ?, gender = ? where id = ?",
                    ResultSet.CONCUR_UPDATABLE);

            passnew.setString(1, userName);
            passnew.setString(2, DOB);
            passnew.setString(3, email);
            passnew.setString(4, phone);
            passnew.setString(5, password);
            passnew.setString(6, gender);
            passnew.setString(7, ID);

            passnew.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
