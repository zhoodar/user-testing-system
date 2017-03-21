package kg.djedai.app.controllers;

import kg.djedai.app.models.Test;
import kg.djedai.app.service.DAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * @author Zhoodar
 * @since 03.08.2016.
 */
@Controller
public class StudentController {

    @Autowired
    private DAOFactory factory;

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public String main(ModelMap model){
        List<Test> tests = (List<Test>) this.factory.testDAO.getAll();
        List<Test> activeTests = tests.stream().filter(test -> test.getTestConfig().getIsActive().equals("true")).collect(Collectors.toCollection(CopyOnWriteArrayList::new));
        model.addAttribute("tests",activeTests);
        return "student/index";
    }
}
