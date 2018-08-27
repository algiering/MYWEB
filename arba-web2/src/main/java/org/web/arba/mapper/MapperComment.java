package org.web.arba.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.web.arba.model.ModelComment;

@Repository("org.web.arba.mapper.MapperComment")
public interface MapperComment {
    
    public int insertComment(ModelComment comment_param) throws Exception;
    
    public List<ModelComment> getCommentList(int article_no) throws Exception;
    
    public int updateComment(ModelComment comment_param) throws Exception;
    
    public int deleteComment(int comment_no) throws Exception;
    
}
