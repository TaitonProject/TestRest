package com.taiton.dao.message;

import com.taiton.dao.AbstractDao;
import com.taiton.entity.MessageEntity;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;

/**
 * Created by Taiton on 12/24/2016.
 */
@Repository("messageDao")
public class MessageDaoImpl extends AbstractDao implements MessageDao {

    @Override
    @Transactional
    public boolean save(MessageEntity message) {
        if (findMessageListBookedTime(message).isEmpty()) {
            persist(message);
            return true;
        }
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public MessageEntity find(int id) {
        TypedQuery query = getSession().createQuery("from MessageEntity as e where e.id = :id", MessageEntity.class).
                setParameter("id", id);
        MessageEntity message = (MessageEntity) query.getSingleResult();
        return message;
    }

    @Override
    @Transactional
    public void delete(int id) {
        delete(find(id));
    }

    @Override
    @Transactional
    public void delete(MessageEntity message) {
        delete(message);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MessageEntity> findAll() {
        Query query = getSession().createQuery("from MessageEntity ");
        return query.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<MessageEntity> findMessageListBookedTime(MessageEntity messageInput) {
        TypedQuery<MessageEntity> query = getSession().createQuery("FROM MessageEntity as m WHERE (m.requestedDate = :messageInput_requestDate)" +
                "and (m.boardroomlistIdBoardroomList = :messageInput_boardroomid) and" +
                "((:mIstart > m.requestedTime and :mIstart < m.durationTime) or" +
                "(:mIend < m.durationTime and :mIend > m.requestedTime) or" +
                "(:mIstart < m.requestedTime and :mIend > m.durationTime))", MessageEntity.class)
                .setParameter("messageInput_requestDate", messageInput.getRequestedDate(), TemporalType.DATE).
                        setParameter("messageInput_boardroomid", messageInput.getBoardroomlistIdBoardroomList())
                .setParameter("mIstart", messageInput.getRequestedTime(), TemporalType.TIME)
                .setParameter("mIend", messageInput.getDurationTime(), TemporalType.TIME);

        List<MessageEntity> results = query.getResultList();
        return results;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MessageEntity> findByDate(Date date) {
        Query query = getSession().createQuery("from MessageEntity as m where m.requestedDate =  :date")
                .setParameter("date", date);
        return query.list();
    }

    @Override
    @Transactional
    public void updateMessage(MessageEntity message) {
        MessageEntity messageEntity = find(message.getIdMessage());
        if (messageEntity != null && save(messageEntity))
            persist(message);
    }

}
