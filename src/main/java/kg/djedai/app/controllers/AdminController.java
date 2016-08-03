package kg.djedai.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Zhoodar
 * @since 03.08.2016.
 */
@Controller
public class AdminController {

    @RequestMapping(value = "/administration?key=secret",method = RequestMethod.GET)
    public String main(){
        return "admin/index";
    }
}
