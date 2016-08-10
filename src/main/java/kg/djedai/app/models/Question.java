package kg.djedai.app.models;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Zhoodar
 * @since 28.07.2016.
 */
public class Question extends Base {

    private String text;
    private int complexity;
    private Test test;
    private String addition;
    private List<Answer>  answers = new CopyOnWriteArrayList<>();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
