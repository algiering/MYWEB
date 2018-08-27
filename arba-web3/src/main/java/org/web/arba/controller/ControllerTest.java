package org.web.arba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerTest {
    
    @RequestMapping("/chat")
    public ModelAndView Chat() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("chat");
        
        return mav;
    }
    
}
