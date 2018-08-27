package org.web.arba.svr;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web.arba.dao.DaoArticle;
import org.web.arba.mapper.MapperArticle;
import org.web.arba.model.ModelArticle;
import org.web.arba.model.ModelVote;

@Service
public class ServiceArticle implements MapperArticle {

    @Autowired
    DaoArticle dao;

    @Override
    @Transactional
    public int articleCount() throws Exception {
        int result = -1;
        result = dao.articleCount();
        return result;
    }

    @Override
    @Transactional
    public List<ModelArticle> getArticleAll() throws Exception {
        List<ModelArticle> result = null;
        result = dao.getArticleAll();
        return result;
    }

    @Override
    @Transactional
    public int getArticleTotalRecord(Map<String, String> article_param) throws Exception {
        int result = -1;
        result = dao.getArticleTotalRecord(article_param);
        return result;
    }

    @Override
    @Transactional
    public List<ModelArticle> getArticleOfBoard(Map<String, String> article_param) throws Exception {
        List<ModelArticle> result = null;
        result = dao.getArticleOfBoard(article_param);
        return result;
    }

    @Override
    @Transactional
    public ModelArticle getArticleOne(Map<String, String> article_param) throws Exception {
        ModelArticle result = null;
        result = dao.getArticleOne(article_param);
        return result;
    }

    @Override
    public int insertArticle(ModelArticle article_param) throws Exception {
        int result = -1;
        result = dao.insertArticle(article_param);
        return result;
    }

    @Override
    public int getArticleMAXSubno(String board_id) throws Exception {
        int result = -1;
        result = dao.getArticleMAXSubno(board_id);
        return result;
    }

    @Override
    public int increaseHit(ModelArticle article_param) throws Exception {
        int result = -1;
        result = dao.increaseHit(article_param);
        return result;
    }

    @Override
    public int updateArticle(ModelArticle article_param) throws Exception {
        int result = -1;
        result = dao.updateArticle(article_param);
        return result;
    }

    @Override
    public int deleteArticle(ModelArticle article_param) throws Exception {
        int result = -1;
        result = dao.deleteArticle(article_param);
        return result;
    }

    @Override
    public int checkVote(ModelVote vote_param) throws Exception {
        int result = -1;
        result = dao.checkVote(vote_param);
        return result;
    }

    @Override
    public int getArticleVoteCount(ModelVote vote_param) throws Exception {
        int result = -1;
        result = dao.getArticleVoteCount(vote_param);
        return result;
    }

    @Override
    public int insertVote(ModelVote vote_param) throws Exception {
        int result = -1;
        result = dao.insertVote(vote_param);
        return result;
    }

    @Override
    public int deleteVote(ModelVote vote_param) throws Exception {
        int result = -1;
        result = dao.deleteVote(vote_param);
        return result;
    }

    @Override
    public int getArticleOfBoardInArticle(Map<String, String> article_param) throws Exception {
        int result = -1;
        result = dao.getArticleOfBoardInArticle(article_param);
        return result;
    }

}
