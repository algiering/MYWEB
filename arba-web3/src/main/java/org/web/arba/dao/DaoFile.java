package org.web.arba.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.web.arba.mapper.MapperFile;
import org.web.arba.model.ModelFile;

@Repository
public class DaoFile implements MapperFile {
    
    @Resource(name="org.web.arba.mapper.MapperFile")
    MapperFile mapper;

    @Override
    public int insertFile(ModelFile fileParam) throws Exception {
        return mapper.insertFile(fileParam);
    }

    @Override
    public List<ModelFile> getFileName(Integer article_no) throws Exception {
        return mapper.getFileName(article_no);
    }

    @Override
    public ModelFile getFileOne(Integer file_no) throws Exception {
        return mapper.getFileOne(file_no);
    }

    @Override
    public int deleteFileOne(Integer file_no) throws Exception {
        return mapper.deleteFileOne(file_no);
    }

    
}
