package kg.djedai.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Zhoodar
 * @since 03.08.2016.
 */
@Controller
public class TeacherController {

    @RequestMapping(value = "/teacher",method = RequestMethod.GET)
    public String main(){
        return "teacher/index";
    }
}
