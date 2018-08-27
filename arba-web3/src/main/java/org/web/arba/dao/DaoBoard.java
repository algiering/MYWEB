package org.web.arba.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.web.arba.mapper.MapperBoard;

@Repository
public class DaoBoard implements MapperBoard {
    
    @Resource(name="org.web.arba.mapper.MapperBoard")
    MapperBoard mapper;

    @Override
    public String getBoardName(String board_id) throws Exception {
        return mapper.getBoardName(board_id);
    }

}
