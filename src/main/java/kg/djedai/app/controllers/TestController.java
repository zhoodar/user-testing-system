package kg.djedai.app.controllers;

import kg.djedai.app.models.Test;
import kg.djedai.app.service.DAOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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
}
