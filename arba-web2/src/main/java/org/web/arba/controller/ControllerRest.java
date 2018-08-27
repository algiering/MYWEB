package org.web.arba.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.web.arba.common.WebConstant;
import org.web.arba.model.ModelComment;
import org.web.arba.model.ModelFile;
import org.web.arba.model.ModelVote;
import org.web.arba.svr.ServiceArticle;
import org.web.arba.svr.ServiceComment;
import org.web.arba.svr.ServiceFile;
import org.web.arba.svr.ServiceUser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerRest {
    
    @Autowired
    ServiceArticle svr_article;
    
    @Autowired
    ServiceUser svr_user;
    
    @Autowired
    ServiceFile svr_file;
    
    @Autowired
    ServiceComment svr_comment;
    
    @RequestMapping(value = "/vote", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public int Vote(@RequestBody ModelVote data
            , HttpSession session) {
        String user_id = (String) session.getAttribute(WebConstant.SESSION_NAME);
        data.setUser_id(user_id);
        int result = -2;
        try {
            result = svr_article.checkVote(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (result==0) {
            try {
                result = svr_article.insertVote(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return result;
    }
    
    @RequestMapping(value = "/unvote", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public int UnVote(@RequestBody ModelVote data
            , HttpSession session) {
        String user_id = (String) session.getAttribute(WebConstant.SESSION_NAME);
        data.setUser_id(user_id);
        int result = -2;
        try {
            result = svr_article.checkVote(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (result==1) {
            try {
                result = svr_article.deleteVote(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return result;
    }
    
    @RequestMapping(value = "/filedelete", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public int FileDelete(@RequestBody ModelFile data) {
        
        int file_no = data.getFile_no();
        
        int file_result = -2;
        try {
            file_result = svr_file.deleteFileOne(file_no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return file_result;
    }
    
    @RequestMapping(value = "/comment_write", method = RequestMethod.POST)
    @Transactional
    public ModelAndView CommentWrite(@RequestBody ModelComment comment, HttpSession session) {
        ModelAndView mav = new ModelAndView(); 
        
        int comment_result = -2;
        String user_id = "";
        user_id = (String) session.getAttribute(WebConstant.SESSION_NAME);
        comment.setUser_id(user_id);
        try {
            comment_result = svr_comment.insertComment(comment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Date comment_regdate = new Date();
        comment.setComment_regdate(comment_regdate);
        if (comment_result==1) {
            mav.addObject("commentadd", comment);
            mav.setViewName("commentadd");
        }

        return mav;
    }
    
    @RequestMapping(value = "/comment_edit", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public int CommentEdit(@RequestBody ModelComment comment) {
        
        int comment_result = -2;
        try {
            comment_result = svr_comment.updateComment(comment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return comment_result;
    }
    
    @RequestMapping(value = "/comment_delete", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public int CommentDelete(@RequestBody int comment_no) {
        
        int comment_result = -2;
        try {
            comment_result = svr_comment.deleteComment(comment_no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comment_result;
    }
    
    @RequestMapping(value = "/id_check", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public int IdCheck(@RequestBody String user_id) {
        
        int user_result = -2;
        try {
            user_result = svr_user.idCheck(user_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return user_result;
    }
    
}
