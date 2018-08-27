package org.web.arba.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.web.arba.model.ModelFile;

@Repository("org.web.arba.mapper.MapperFile")
public interface MapperFile {
    
    public int insertFile(ModelFile fileParam) throws Exception;
    
    public List<ModelFile> getFileName(Integer article_no) throws Exception;
    
    public ModelFile getFileOne(Integer file_no) throws Exception;
    
    public int deleteFileOne(Integer file_no) throws Exception;

}
