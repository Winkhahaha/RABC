package com.mineok.controller.api;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("${api-url}")   // 从yml中取
public class ApiController {

    @RequestMapping("/getPage")
    public ModelAndView getPage(ModelAndView model, String pageName) {
        model.setViewName(pageName);
        return model;
    }
}
