package kg.djedai.app.service;

import kg.djedai.app.models.*;
import kg.djedai.app.storage.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Zhoodar
 * @since 04.08.2016.
 */

@Service
public class DAOFactory {

    public final DAO<User> userDAO;
    public final DAO<Student> studentDAO;
    public final DAO<Teacher> teacherDAO;
    public final DAO<Test> testDAO;
    public final DAO<Question> questionDAO;
    public final DAO<Answer> answerDAO;
    public final DAO<Group> groupDAO;
    public final DAO<Result> resultDAO;
    public final DAO<GuestUser> guestUserDAO;
    public final DAO<Category> categoryDAO;
    public final DAO<QuestionType> questionTypeDAO;
    public final DAO<TestConfig> testConfigDAO;

    @Autowired
   public DAOFactory(DAO<User> userDAO, DAO<Student> studentDAO, DAO<Teacher> teacherDAO, DAO<Test> testDAO, DAO<Question> questionDAO, DAO<Answer> answerDAO, DAO<Group> groupDAO, DAO<Result> resultDAO, DAO<GuestUser> guestUserDAO, DAO<Category> categoryDAO, DAO<QuestionType> questionTypeDAO, DAO<TestConfig> testConfigDAO) {
        this.userDAO = userDAO;
        this.studentDAO = studentDAO;
        this.teacherDAO = teacherDAO;
        this.testDAO = testDAO;
        this.questionDAO = questionDAO;
        this.answerDAO = answerDAO;
        this.groupDAO = groupDAO;
        this.resultDAO = resultDAO;
        this.guestUserDAO = guestUserDAO;
        this.categoryDAO = categoryDAO;
        this.questionTypeDAO = questionTypeDAO;
        this.testConfigDAO = testConfigDAO;
    }
}
