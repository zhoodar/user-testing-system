package kg.djedai.app.models;

/**
 * @author Zhoodar
 * @since 14.08.2016.
 */
public class TestConfig extends Base {

    private int durationOfQuiz;
    private int quantityOfQuestions;
    private String isActive;

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

}
