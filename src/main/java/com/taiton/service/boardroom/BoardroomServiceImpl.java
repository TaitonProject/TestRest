package com.taiton.service.boardroom;

import com.taiton.dao.boardroom.BoardroomDao;
import com.taiton.dao.employee.EmployeeDao;
import com.taiton.entity.BoardroomlistEntity;
import com.taiton.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taiton on 11/6/2016.
 */
@Service

public class BoardroomServiceImpl implements BoardroomService {

    @Autowired
    private BoardroomDao boardroomDao;

    @Override
    @Transactional
    public void save(BoardroomlistEntity boardroomlistEntity) {
        boardroomDao.save(boardroomlistEntity);
    }

    @Override
    public void delete(int id) {
        boardroomDao.delete(id);
    }

    @Override
    public void delete(BoardroomlistEntity boardroomlistEntity) {
        boardroomDao.delete(boardroomlistEntity);
    }

    @Override
    public BoardroomlistEntity find(int id) {
        return boardroomDao.find(id);
    }

    @Override
    @Transactional
    public List<BoardroomlistEntity> findAll() {
        return boardroomDao.findAll();
    }
}
