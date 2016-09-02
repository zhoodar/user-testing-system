package kg.djedai.app.controllers;

import kg.djedai.app.service.DAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;


/**
 * @author Zhoodar
 * @since 03.08.2016.
 */
@Controller
public class MainController {

    @Autowired
    private DAOFactory factory;

    @RequestMapping (value = "/",method = RequestMethod.GET)
    public String main(){
        return "index";
    }

    @RequestMapping(value = "/testing/available/tests",method = RequestMethod.GET)
    public String getTests(ModelMap model){
        model.addAttribute("tests",this.factory.testDAO.getAll());
        return "testing/availableTests";
    }

    @RequestMapping(value = "/testing/examination/test",method = RequestMethod.GET)
    public String getTestById(@RequestParam("id")int id,ModelMap model){
        model.addAttribute("test",this.factory.testDAO.read(id));
        return "testing/test";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error",required = false)String error,
                              @RequestParam(value = "logout",required = false)String logout){
        ModelAndView model = new ModelAndView();
        if(error!=null){
            model.addObject("error","Invalid login or password! Please try again! ");
        }
        if(logout!=null){
            model.setViewName("redirect:/");
            return model;
        }
        model.setViewName("authenticate/login");
        return model;
    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public String accessDenied(Principal user, ModelMap model){
        if(user!=null){
            model.addAttribute("errorMsg","Доступ запрещён "+user.getName()+", у вас нет прав доступа к этой странице!");
        }else {
            model.addAttribute("errorMsg","Доступ запрещён У вас нет прав доступа к этой странице!");
        }
        return "authenticate/accessDenied";
    }



    @RequestMapping(value = "/example")
    public String getExample(){
        return "teacher/QuestionAnswer";
    }



}
