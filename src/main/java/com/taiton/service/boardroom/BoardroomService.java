package com.taiton.service.boardroom;

import com.taiton.entity.BoardroomlistEntity;
import com.taiton.entity.EmployeeEntity;

import java.util.List;

/**
 * Created by Taiton on 11/6/2016.
 */
public interface BoardroomService {
    void save(BoardroomlistEntity boardroomlistEntity);

    void delete(int id);

    void delete(BoardroomlistEntity boardroomlistEntity);

    BoardroomlistEntity find(int id);

    List<BoardroomlistEntity> findAll();
}
