package org.web.arba.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.web.arba.mapper.MapperArticle;
import org.web.arba.model.ModelArticle;
import org.web.arba.model.ModelVote;

@Repository
public class DaoArticle implements MapperArticle {
    
    @Resource(name="org.web.arba.mapper.MapperArticle")
    MapperArticle mapper;

    @Override
    public int articleCount() throws Exception {
        return mapper.articleCount();
    }

    @Override
    public List<ModelArticle> getArticleAll() throws Exception {
        return mapper.getArticleAll();
    }

    @Override
    public int getArticleTotalRecord(Map<String, String> article_param) throws Exception {
        return mapper.getArticleTotalRecord(article_param);
    }

    @Override
    public List<ModelArticle> getArticleOfBoard(Map<String, String> article_param) throws Exception {
        return mapper.getArticleOfBoard(article_param);
    }

    @Override
    public ModelArticle getArticleOne(Map<String, String> article_param) throws Exception {
        return mapper.getArticleOne(article_param);
    }

    @Override
    public int insertArticle(ModelArticle article_param) throws Exception {
        return mapper.insertArticle(article_param);
    }

    @Override
    public int getArticleMAXSubno(String board_id) throws Exception {
        return mapper.getArticleMAXSubno(board_id);
    }

    @Override
    public int increaseHit(ModelArticle article_param) throws Exception {
        return mapper.increaseHit(article_param);
    }

    @Override
    public int updateArticle(ModelArticle article_param) throws Exception {
        return mapper.updateArticle(article_param);
    }

    @Override
    public int deleteArticle(ModelArticle article_param) throws Exception {
        return mapper.deleteArticle(article_param);
    }

    @Override
    public int checkVote(ModelVote vote_param) throws Exception {
        return mapper.checkVote(vote_param);
    }
    
    @Override
    public int getArticleVoteCount(ModelVote vote_param) throws Exception {
        return mapper.getArticleVoteCount(vote_param);
    }

    @Override
    public int insertVote(ModelVote vote_param) throws Exception {
        return mapper.insertVote(vote_param);
    }

    @Override
    public int deleteVote(ModelVote vote_param) throws Exception {
        return mapper.deleteVote(vote_param);
    }

    @Override
    public int getArticleOfBoardInArticle(Map<String, String> article_param) throws Exception {
        return mapper.getArticleOfBoardInArticle(article_param);
    }

}
