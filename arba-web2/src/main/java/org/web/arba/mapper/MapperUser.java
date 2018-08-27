package org.web.arba.mapper;

import org.springframework.stereotype.Repository;
import org.web.arba.model.ModelUser;

@Repository("org.web.arba.mapper.MapperUser")
public interface MapperUser {
    
    public Integer insertUser(ModelUser userParam) throws Exception;
    
    public String login(ModelUser userParam) throws Exception;
    
    public Integer idCheck(String user_id) throws Exception;

}
