package org.web.arba.svr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web.arba.dao.DaoBoard;
import org.web.arba.mapper.MapperBoard;

@Service
public class ServiceBoard implements MapperBoard {
    
    @Autowired
    DaoBoard dao;

    @Override
    @Transactional
    public String getBoardName(String board_id) throws Exception {
        String result = null;
        result = dao.getBoardName(board_id);
        return result;
    }
    
}
