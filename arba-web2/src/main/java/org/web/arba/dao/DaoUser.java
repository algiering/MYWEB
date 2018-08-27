package org.web.arba.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.web.arba.mapper.MapperUser;
import org.web.arba.model.ModelUser;

@Repository
public class DaoUser implements MapperUser {

    @Resource(name="org.web.arba.mapper.MapperUser")
    MapperUser mapper;

    @Override
    public Integer insertUser(ModelUser userParam) throws Exception {
        return mapper.insertUser(userParam);
    }

    @Override
    public String login(ModelUser userParam) throws Exception {
        return mapper.login(userParam);
    }

    @Override
    public Integer idCheck(String user_id) throws Exception {
        return mapper.idCheck(user_id);
    }
    
}
