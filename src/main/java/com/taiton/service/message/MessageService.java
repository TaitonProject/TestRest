package com.taiton.service.message;

import com.taiton.entity.MessageEntity;

import java.sql.Date;
import java.util.List;

/**
 * Created by Taiton on 11/6/2016.
 */
public interface MessageService {
    boolean save(MessageEntity message);

    List<MessageEntity> findAll();

    void delete(MessageEntity message);

    List<MessageEntity> findByDate(Date date);

    void updateMessage(MessageEntity message);
}
