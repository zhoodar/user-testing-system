package kg.djedai.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Zhoodar
 * @since 03.08.2016.
 */
@Controller
public class AdminController {

    @RequestMapping(value = "/administration",method = RequestMethod.GET)
    public String main(@RequestParam(value = "key",required = true)String key){
        return "admin/index";
    }

    @RequestMapping(value = "/administration/groups",method = RequestMethod.GET)
    public String getGroups(){
        return "admin/students/groups";
    }

    @RequestMapping(value = "/administration/groups/students",method = RequestMethod.GET)
    public String getStudents(){
        return "admin/students/students";
    }

    @RequestMapping(value = "/administration/teachers",method = RequestMethod.GET)
    public String getTeachers(){
        return "admin/teachers/teachers";
    }

    @RequestMapping(value = "/administration/tests",method = RequestMethod.GET)
    public String getTests(){
        return "admin/teachers/tests";
    }

    @RequestMapping(value = "/administration/add/students",method = RequestMethod.GET)
    public String getAddStudents(){
        return "admin/students/addStudent";
    }

    @RequestMapping(value = "/administration/add/teacher",method = RequestMethod.GET)
    public String getAddTeacher(){
        return "admin/teachers/addTeacher";
    }
}
