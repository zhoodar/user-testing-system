package kg.djedai.app.models;

/**
 * @author Zhoodar
 * @since 14.08.2016.
 */
public class TestConfig extends Base {

    private int durationOfQuiz;
    private int quantityOfQuestions;
    private String isActive;
    private Test test;

    public int getDurationOfQuiz() {
        return durationOfQuiz;
    }

    public void setDurationOfQuiz(int durationOfQuiz) {
        this.durationOfQuiz = durationOfQuiz;
    }

    public int getQuantityOfQuestions() {
        return quantityOfQuestions;
    }

    public void setQuantityOfQuestions(int quantityOfQuestions) {
        this.quantityOfQuestions = quantityOfQuestions;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String active) {
        isActive = active;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
