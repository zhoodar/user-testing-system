package kg.djedai.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Zhoodar
 * @since 03.08.2016.
 */
@Controller
public class MainController {

    @RequestMapping (value = "/",method = RequestMethod.GET)
    public String main(){
        return "index";
    }

    @RequestMapping(value = "/testing",method = RequestMethod.GET)
    public String testing(){
        return "testing/tests";
    }
}
