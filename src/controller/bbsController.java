package controller;

import bbs.entity.Forum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import bbs.dao.impl.forumDaoImpl;



@Controller
public class bbsController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public @ResponseBody String Hello() {
        return "Hello, SpringMVC.";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody String index() {

        return "forum index";
    }
}
