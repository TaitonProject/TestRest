package com.taiton.dao.message;

import com.taiton.entity.MessageEntity;

import java.sql.Date;
import java.util.List;

/**
 * Created by Taiton on 12/24/2016.
 */
public interface MessageDao {
    MessageEntity find(int id);

    boolean save(MessageEntity message);

    void delete(int id);

    void delete(MessageEntity message);

    List<MessageEntity> findAll();

    List<MessageEntity> findMessageListBookedTime(MessageEntity message);

    List<MessageEntity> findByDate(Date date);

    void updateMessage(MessageEntity message);
}
