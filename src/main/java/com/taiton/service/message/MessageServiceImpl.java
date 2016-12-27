package com.taiton.service.message;

import com.taiton.dao.message.MessageDao;
import com.taiton.entity.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


/**
 * Created by Taiton on 11/6/2016.
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Override
    public boolean save(MessageEntity message) {
        message.setBoardroomlistIdBoardroomList(14);
        message.setArrivalTime(Timestamp.valueOf(LocalDateTime.now()));
        message.setIdMessage(message.getIdMessage());
        if (messageDao.save(message))
            return true;
        return false;
    }

    @Override
    public List<MessageEntity> findAll() {
        return messageDao.findAll();
    }

    @Override
    public void delete(MessageEntity message) {
        delete(message);
    }

    @Override
    public List<MessageEntity> findByDate(Date date) {
        return messageDao.findByDate(date);
    }

    @Override
    public void updateMessage(MessageEntity message) {
        messageDao.updateMessage(message);
    }

}
