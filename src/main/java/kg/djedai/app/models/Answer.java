package kg.djedai.app.models;

/**
 * @author Zhoodar
 * @since 28.07.2016.
 */
public class Answer extends Base {

    private Question question;
    private String text;
    private int isCorrect;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(int isCorrect) {
        this.isCorrect = isCorrect;
    }

}
