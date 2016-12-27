package com.taiton.service.message;

import com.taiton.entity.MessageEntity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by Taiton on 11/6/2016.
 */
public interface MessageService {
    List<MessageEntity> findByDate(Date date);

    int findBookedTime(Date date, int id, Time startTime, Time endTime);

    boolean save(MessageEntity employeeEntity);

    void delete(int id);

    void delete(MessageEntity employeeEntity);

    MessageEntity findOne(int id);

    List<MessageEntity> findAll();

}
