package kg.djedai.app.controllers;

import kg.djedai.app.models.Result;
import kg.djedai.app.models.Student;
import kg.djedai.app.models.Test;
import kg.djedai.app.service.DAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


/**
 * @author Zhoodar
 * @since 03.08.2016.
 */
@RestController
public class TestController {

    @Autowired
    private DAOFactory factory;

    @RequestMapping(value = "/testing/questions",method = RequestMethod.GET)
    public Test getQuestions(@RequestParam("id")int id){
        return this.factory.testDAO.read(id);
    }

    @RequestMapping(value = "testing/examination/submit", method = RequestMethod.POST)
    public void addResult(UsernamePasswordAuthenticationToken authenticationToken,
                          @RequestParam("testId")int testId,
                          @RequestParam("score")int score,
                          @RequestParam("result")String grade
                          ){
        int studentId = Integer.parseInt(authenticationToken.getDetails().toString());
        Student student = factory.studentDAO.read(studentId);
        Test test = factory.testDAO.read(testId);
        Date currentDate = new Date();
        Result result =  new Result();
        result.setTest(test);
        result.setDate(currentDate);
        result.setResult(grade);
        result.setStudent(student);
        result.setScore(score);
        factory.resultDAO.create(result);
    }
}
