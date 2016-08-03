package kg.djedai.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Zhoodar
 * @since 03.08.2016.
 */
@Controller
public class StudentController {

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public String main(){
        return "student/index";
    }
}
