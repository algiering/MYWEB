package org.web.arba.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.web.arba.mapper.MapperComment;
import org.web.arba.model.ModelComment;

@Repository
public class DaoComment implements MapperComment {
    
    @Resource(name="org.web.arba.mapper.MapperComment")
    MapperComment mapper;

    @Override
    public int insertComment(ModelComment comment_param) throws Exception {
        return mapper.insertComment(comment_param);
    }

    @Override
    public List<ModelComment> getCommentList(int article_no) throws Exception {
        return mapper.getCommentList(article_no);
    }

    @Override
    public int updateComment(ModelComment comment_param) throws Exception {
        return mapper.updateComment(comment_param);
    }

    @Override
    public int deleteComment(int comment_no) throws Exception {
        return mapper.deleteComment(comment_no);
    }
    
    
}
