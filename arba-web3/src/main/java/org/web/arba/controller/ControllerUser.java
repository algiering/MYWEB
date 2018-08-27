package org.web.arba.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.web.arba.common.WebConstant;
import org.web.arba.model.ModelUser;
import org.web.arba.svr.ServiceUser;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/page")
@Controller
public class ControllerUser {
    
    @Autowired
    ServiceUser svr_user;
    
    @RequestMapping(value = "/membership", method = RequestMethod.GET)
    @Transactional
    public ModelAndView Membership(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("membership");
        
        if(session.getAttribute(WebConstant.SESSION_NAME)!=null) {
            mav.addObject("login_check", true);
        } else {
            mav.addObject("login_check", false);
        }
        
        return mav;
    }
    
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    @Transactional
    public ModelAndView Welcome(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("aftermember");
        
        if(session.getAttribute(WebConstant.SESSION_NAME)!=null) {
            mav.addObject("login_check", true);
        } else {
            mav.addObject("login_check", false);
        }
        
        return mav;
    }
    
    @RequestMapping(value = "/membership_rest", method = RequestMethod.POST)
    @Transactional
    public RedirectView Membership_rest(@RequestParam(value="user_id") String user_id
            , @RequestParam(value="user_passwd") String user_passwd
            , @RequestParam(value="user_phone") String user_phone
            , @RequestParam(value="user_email1") String user_email1
            , @RequestParam(value="user_email2") String user_email2) {
        RedirectView redirect = new RedirectView();
        redirect.setUrl("/welcome");
        
        BCryptPasswordEncoder passwdEncorder = new BCryptPasswordEncoder();
        user_passwd = passwdEncorder.encode(user_passwd);
        
        ModelUser userParam = new ModelUser();
        userParam.setUser_id(user_id);
        userParam.setUser_passwd(user_passwd);
        userParam.setUser_phone(user_phone);
        userParam.setUser_email(user_email1 + "@" + user_email2);
        
        int resultUser = -2;
        try {
            resultUser = svr_user.insertUser(userParam);
        } catch (Exception e) {
        }
        
        return redirect;
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @Transactional
    public ModelAndView Login(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        
        if(session.getAttribute(WebConstant.SESSION_NAME)!=null) {
            mav.addObject("login_check", true);
        } else {
            mav.addObject("login_check", false);
        }
        
        return mav;
    }
    
    @RequestMapping(value = "/login_rest", method = RequestMethod.POST)
    @Transactional
    public RedirectView Login_rest(@RequestParam(value="user_id") String user_id
            , @RequestParam(value="user_passwd") String user_passwd
            , HttpSession session) {
        RedirectView redirect = new RedirectView();
        
        ModelUser userParam = new ModelUser();
        userParam.setUser_id(user_id);
        String encodedPasswd = "";
        try {
            encodedPasswd = svr_user.login(userParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        BCryptPasswordEncoder passwdEncorder = new BCryptPasswordEncoder();
        boolean passmatch = passwdEncorder.matches(user_passwd, encodedPasswd);
        
        int result = -2;
        
        if(passmatch) {
            result = 1;
            session.setAttribute(WebConstant.SESSION_NAME, user_id);
            redirect.setUrl("/");
        }
        else {
            result = -1;
            redirect.setUrl("/loginfail");
        }
        
        return redirect;
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @Transactional
    public RedirectView Logout(HttpSession session) {
        RedirectView redirect = new RedirectView();
        redirect.setUrl("/");
        
        if(session.getAttribute(WebConstant.SESSION_NAME)!=null) {
            session.removeAttribute(WebConstant.SESSION_NAME);
        }
        
        return redirect;
    }
    
    @RequestMapping(value = "/loginfail", method = RequestMethod.GET)
    @Transactional
    public ModelAndView LoginFail(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("loginfail");
        
        if(session.getAttribute(WebConstant.SESSION_NAME)!=null) {
            mav.addObject("login_check", true);
        } else {
            mav.addObject("login_check", false);
        }
        
        return mav;
    }

}
