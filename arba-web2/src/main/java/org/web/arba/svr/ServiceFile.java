package org.web.arba.svr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web.arba.dao.DaoFile;
import org.web.arba.mapper.MapperFile;
import org.web.arba.model.ModelFile;

@Service
public class ServiceFile implements MapperFile {
    
    @Autowired
    DaoFile dao;

    @Override
    public int insertFile(ModelFile fileParam) throws Exception {
        int result = -1;
        result = dao.insertFile(fileParam);
        return result;
    }

    @Override
    public List<ModelFile> getFileName(Integer article_no) throws Exception {
        List<ModelFile> result = null;
        result = dao.getFileName(article_no);
        return result;
    }

    @Override
    public ModelFile getFileOne(Integer file_no) throws Exception {
        ModelFile result = null;
        result = dao.getFileOne(file_no);
        return result;
    }

    @Override
    public int deleteFileOne(Integer file_no) throws Exception {
        int result = -1;
        result = dao.deleteFileOne(file_no);
        return result;
    }
    
}
