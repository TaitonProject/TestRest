package com.taiton.service.message;

import com.taiton.entity.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taiton.dao.MessageDao;
import java.sql.Date;
import java.sql.Time;
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

    public boolean save(MessageEntity message) {

        message.setArrivalTime(Timestamp.valueOf(LocalDateTime.now()));
        if (messageDao.findBookedTime(message.getRequestedDate(),
                message.getBoardroomlistIdBoardroomList(),
                message.getRequestedTime(),
                message.getDurationTime()) == 0){
            messageDao.save(message);
            return true;
        }
        return false;
    }

    @Override
    public void delete(int id) {
        messageDao.delete(id);
    }

    @Override
    public void delete(MessageEntity employeeEntity) {
        messageDao.delete(employeeEntity);
    }

    @Override
    public MessageEntity findOne(int id) {
        return messageDao.findOne(id);
    }

    @Override
    public List<MessageEntity> findAll() {
        return messageDao.findAll();
    }

    @Override
    public List<MessageEntity> findByDate(Date date) {
        return messageDao.findByDate(date);
    }

    @Override
    public int findBookedTime(Date date, int id, Time startTime, Time endTime) {
        return messageDao.findBookedTime(date, id, startTime, endTime);
    }
}
