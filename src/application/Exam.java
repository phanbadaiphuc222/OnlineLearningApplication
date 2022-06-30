    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

/**
 *
 * @author Dai Phuc
 */
public class Exam {
    private String courseName, Tutor, classCode, courseCode, ID, IDTutor, Time, NameTest, Activate, date;
    private int length;

    public String getIDTutor() {
        return IDTutor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setIDTutor(String IDTutor) {
        this.IDTutor = IDTutor;
    }

    public String getActivate() {
        return Activate;
    }

    public void setActivate(String Activate) {
        this.Activate = Activate;
    }
    
    public Exam() {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.Tutor = Tutor;
        this.classCode = classCode;
        this.length=length;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getNameTest() {
        return NameTest;
    }

    public void setNameTest(String NameTest) {
        this.NameTest = NameTest;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTutor() {
        return Tutor;
    }

    public void setTutor(String tutor) {
        this.Tutor = tutor;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
