package kg.djedai.app.controllers;

import kg.djedai.app.service.DAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        model.addAttribute("tests",this.factory.testDAO.getAll());
        return "student/index";
    }
}
