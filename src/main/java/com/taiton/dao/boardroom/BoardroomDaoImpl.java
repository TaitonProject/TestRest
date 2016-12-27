package com.taiton.dao.boardroom;

import com.taiton.dao.AbstractDao;
import com.taiton.entity.BoardroomlistEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Taiton on 12/25/2016.
 */
@Repository("boardroomDao")
public class BoardroomDaoImpl extends AbstractDao implements BoardroomDao {
    @Override
    @Transactional
    public BoardroomlistEntity find(int id) {
        TypedQuery query = getSession().createQuery("from BoardroomlistEntity as b where b.idBoardroomList = id", BoardroomlistEntity.class);
        BoardroomlistEntity boardroomlistEntity = (BoardroomlistEntity) query.getSingleResult();
        return boardroomlistEntity;
    }

    @Override
    @Transactional
    public void save(BoardroomlistEntity boardroomlistEntity) {
        if (boardroomlistEntity != null)
            persist(boardroomlistEntity);
    }

    @Override
    @Transactional
    public void delete(int id) {
        delete(id);
    }

    @Override
    @Transactional
    public void delete(BoardroomlistEntity boardroomlistEntity) {
        delete(boardroomlistEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BoardroomlistEntity> findAll() {
        List<BoardroomlistEntity> boardroomlist = getSession().createQuery("from BoardroomlistEntity").list();
        return boardroomlist;
    }
}
