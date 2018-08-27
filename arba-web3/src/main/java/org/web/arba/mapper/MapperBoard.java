package org.web.arba.mapper;

import org.springframework.stereotype.Repository;

@Repository("org.web.arba.mapper.MapperBoard")
public interface MapperBoard {
    
    public String getBoardName(String board_id) throws Exception;
    
}
