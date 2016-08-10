package kg.djedai.app.models;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Zhoodar
 * @since 28.07.2016.
 */
public class Test extends Base {

    private String name;
    private Group group;
    private Category category;
    private Teacher teacher;
    private List<Question> questions = new CopyOnWriteArrayList<>();

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
