package org.web.arba.svr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.web.arba.dao.DaoComment;
import org.web.arba.mapper.MapperComment;
import org.web.arba.model.ModelComment;

@Service
public class ServiceComment implements MapperComment {
    
    @Autowired
    DaoComment dao;

    @Override
    public int insertComment(ModelComment comment_param) throws Exception {
        int result = -1;
        result = dao.insertComment(comment_param);
        return result;
    }

    @Override
    public List<ModelComment> getCommentList(int article_no) throws Exception {
        List<ModelComment> result = null;
        result = dao.getCommentList(article_no);
        return result;
    }

    @Override
    public int updateComment(ModelComment comment_param) throws Exception {
        int result = -1;
        result = dao.updateComment(comment_param);
        return result;
    }

    @Override
    public int deleteComment(int comment_no) throws Exception {
        int result = -1;
        result = dao.deleteComment(comment_no);
        return result;
    }
    
}
