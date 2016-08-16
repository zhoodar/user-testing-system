package kg.djedai.app.models;

import java.util.Date;

/**
 * @author Zhoodar
 * @since 28.07.2016.
 */
public class Result extends Base {

    private Student student;
    private String result;
    private int score;
    private Test test;
    private Date date;


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
