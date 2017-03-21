package kg.djedai.app.controllers;

import kg.djedai.app.models.*;
import kg.djedai.app.service.DAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Zhoodar
 * @since 03.08.2016.
 */
@Controller
public class TeacherController {

    @Autowired
    private DAOFactory factory;

    @RequestMapping(value = "/teacher",method = RequestMethod.GET)
    public String main(UsernamePasswordAuthenticationToken authenticationToken, ModelMap model){
        Teacher teacher = getTeacherByAuthentication(authenticationToken);
        model.addAttribute("tests",this.factory.testDAO.getByIdOfInnerElement(teacher.getId()));
        model.addAttribute("teacher", teacher);
        return "teacher/index";
    }

    @RequestMapping(value = "/teacher/add/test",method = RequestMethod.GET)
    public String getAddTest(UsernamePasswordAuthenticationToken authenticationToken, ModelMap model){
        Teacher teacher = getTeacherByAuthentication(authenticationToken);
        model.addAttribute("categories",this.factory.categoryDAO.getAll());
        model.addAttribute("teacher", teacher);
        return "teacher/createTest";
    }

    private Teacher getTeacherByAuthentication(UsernamePasswordAuthenticationToken authenticationToken){
        int userID = Integer.parseInt(authenticationToken.getDetails().toString());
        return this.factory.teacherDAO.read(userID);
    }

    @RequestMapping(value = "/teacher/add/test",method = RequestMethod.POST)
    public String addTest(UsernamePasswordAuthenticationToken authenticationToken,
                          HttpServletRequest request, ModelMap model) {
        Teacher teacher = getTeacherByAuthentication(authenticationToken);
        Test test = new Test();
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int categoryId = Integer.parseInt(request.getParameter("category"));
        test.setName(name);
        test.setDescription(description);
        test.setTeacher(teacher);
        test.setCategory(this.factory.categoryDAO.read(categoryId));
        test.setTestConfig(createDefaultConfig());
        this.factory.testDAO.create(test);
        model.addAttribute("test",test);
        model.addAttribute("teacher",teacher);
        return "teacher/QuestionAnswer";

    }

    private TestConfig createDefaultConfig() {
        TestConfig config = new TestConfig();
        config.setQuantityOfQuestions(10);
        config.setDurationOfQuiz(20);
        config.setIsActive("false");
        this.factory.testConfigDAO.create(config);
        return config;
    }

    @RequestMapping(value ="/teacher/add/question/test",method = RequestMethod.GET)
    public String getAddQuestionToTest(@RequestParam(value = "id", required = true) String paramId,
                                       UsernamePasswordAuthenticationToken authenticationToken,
                                       ModelMap model){
        int testId= Integer.parseInt(paramId);
        Teacher teacher = getTeacherByAuthentication(authenticationToken);
        model.addAttribute("test",factory.testDAO.read(testId));
        model.addAttribute("teacher",teacher);
        return "teacher/QuestionAnswer";

    }

    @RequestMapping(value = "/teacher/add/test/question",method = RequestMethod.POST)
    public String addQuestionToTest(HttpServletRequest request,
                                    UsernamePasswordAuthenticationToken authenticationToken,
                                    ModelMap model){
        Teacher teacher = getTeacherByAuthentication(authenticationToken);
        int testId = Integer.parseInt(request.getParameter("testId"));
        Test test = factory.testDAO.read(testId);
        String questionName = request.getParameter("question");
        int questionTypeId = Integer.parseInt( request.getParameter("questionType"));
        int complexity = Integer.parseInt(request.getParameter("complexity"));
        int point = Integer.parseInt(request.getParameter("point"));
        Question question = createQuestion(questionName,point,complexity,questionTypeId,test);

        factory.questionDAO.create(question);
        addAnswerToQuestion(request,question);
        model.addAttribute("test",test);
        model.addAttribute("teacher",teacher);
        return "teacher/QuestionAnswer";
    }

    private Question createQuestion(String questionName, int point, int complexity, int questionTypeId, Test test) {
        Question question = new Question();
        question.setText(questionName);
        question.setPoint(point);
        question.setComplexity(complexity);
        question.setQuestionType(factory.questionTypeDAO.read(questionTypeId));
        question.setTest(test);
        return question;
    }

    private void addAnswerToQuestion(final HttpServletRequest request,final Question question){
        List<Answer> answers = new CopyOnWriteArrayList<>();
        int correctOption = Integer.parseInt(request.getParameter("isCorrect"));
        int optionCounter=1;
        for(int i=0; i<4; i++){
            answers.add(new Answer());
            answers.get(i).setQuestion(question);
            if(request.getParameter("option"+optionCounter)!=null)
                answers.get(i).setText(request.getParameter("option"+optionCounter));
            if(correctOption==optionCounter) {
                answers.get(i).setIsCorrect(1);
            } else {
                answers.get(i).setIsCorrect(0);
            }
            optionCounter++;
        }
        for(Answer answer:answers){
            factory.answerDAO.create(answer);
        }
    }

    @RequestMapping(value = "/teacher/set/config/test",method = RequestMethod.GET)
    public String getSetConfigTest(@RequestParam(value = "id",required = true)String param,ModelMap model){
        int testId = Integer.parseInt(param);
        model.addAttribute("test",factory.testDAO.read(testId));
        return "teacher/configTest";
    }

    @RequestMapping(value = "/teacher/set/config",method = RequestMethod.POST)
    public String SetConfigTest(@RequestParam("testId")String param1,
                                @RequestParam("duration")String param2,
                                @RequestParam("isActive")String isActive,
                                @RequestParam("quantity")String param3 ){
        int testId = Integer.parseInt(param1);
        int duration = Integer.parseInt(param2);
        int quantity = Integer.parseInt(param3);
        Test test = this.factory.testDAO.read(testId);
        TestConfig testConfig = test.getTestConfig();

        testConfig.setDurationOfQuiz(duration);
        testConfig.setIsActive(isActive);
        testConfig.setQuantityOfQuestions(quantity);
        factory.testConfigDAO.update(testConfig);
        return "redirect:/teacher";
    }

    @RequestMapping(value = "/teacher/results",method = RequestMethod.GET)
    public String getResults(){
        return "teacher/allresults";
    }
}
