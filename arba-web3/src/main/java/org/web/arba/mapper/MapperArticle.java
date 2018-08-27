package org.web.arba.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.web.arba.model.ModelArticle;
import org.web.arba.model.ModelVote;

@Repository("org.web.arba.mapper.MapperArticle")
public interface MapperArticle {
    
    public int articleCount() throws Exception;
    
    public List<ModelArticle> getArticleAll() throws Exception;
    
    public int getArticleTotalRecord(Map<String, String> article_param) throws Exception;
    
    public List<ModelArticle> getArticleOfBoard(Map<String, String> article_param) throws Exception;
    
    public int getArticleOfBoardInArticle(Map<String, String> article_param) throws Exception;
    
    public ModelArticle getArticleOne(Map<String, String> article_param) throws Exception;

    public int insertArticle(ModelArticle article_param) throws Exception;
    
    public int getArticleMAXSubno(String board_id) throws Exception;
    
    public int increaseHit(ModelArticle article_param) throws Exception;
    
    public int updateArticle(ModelArticle article_param) throws Exception;
    
    public int deleteArticle(ModelArticle article_param) throws Exception;
    
    public int checkVote(ModelVote vote_param) throws Exception;
    
    public int getArticleVoteCount(ModelVote vote_param) throws Exception;
    
    public int insertVote(ModelVote vote_param) throws Exception;
    
    public int deleteVote(ModelVote vote_param) throws Exception;
}
