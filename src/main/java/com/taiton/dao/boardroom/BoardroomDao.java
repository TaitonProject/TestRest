package com.taiton.dao.boardroom;

import com.taiton.entity.BoardroomlistEntity;

import java.util.List;

/**
 * Created by Taiton on 12/25/2016.
 */
public interface BoardroomDao {
    BoardroomlistEntity find(int id);

    void save(BoardroomlistEntity boardroomlistEntity);

    void delete(int id);

    void delete(BoardroomlistEntity boardroomlistEntity);

    List<BoardroomlistEntity> findAll();
}
