package org.web.arba.svr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web.arba.dao.DaoUser;
import org.web.arba.mapper.MapperUser;
import org.web.arba.model.ModelUser;

@Service
public class ServiceUser implements MapperUser {
    
    @Autowired
    DaoUser dao;

    @Override
    public Integer insertUser(ModelUser userParam) throws Exception {
        int result = -1;
        result = dao.insertUser(userParam);
        return result;
    }

    @Override
    public String login(ModelUser userParam) throws Exception {
        String result = "";
        result = dao.login(userParam);
        return result;
    }

    @Override
    public Integer idCheck(String user_id) throws Exception {
        int result = -1;
        result = dao.idCheck(user_id);
        return result;
    }
    
}
