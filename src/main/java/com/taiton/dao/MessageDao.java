package com.taiton.dao;

import com.taiton.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by jsdev on 12/27/16.
 */
@Transactional
public interface MessageDao extends JpaRepository<MessageEntity, Integer> {
    @Query(value = "select * from message as m where m.requestedDate = :date order by m.requestedTime", nativeQuery = true)
    List<MessageEntity> findByDate(@Param("date") Date date);

    @Query(value = "select count(*) from message as m where (m.requestedDate = :messageInput_requestDate) " +
            "and (m.boardroomlist_idBoardroomList = :messageInput_boardroomid) and" +
            "((:mIstart > m.requestedTime and :mIstart < m.durationTime) or" +
            "(:mIend < m.durationTime and :mIend > m.requestedTime) or" +
            "(:mIstart < m.requestedTime and :mIend > m.durationTime))", nativeQuery = true)
    int findBookedTime(@Param("messageInput_requestDate") Date date,
                                       @Param("messageInput_boardroomid") int id,
                                       @Param("mIstart") Time startTime,
                                       @Param("mIend") Time endTime);
    @Modifying
    @Transactional
    @Query("delete from MessageEntity as m where m.employeeIdEmployee = :id")
    void deleteByEmployee_idEmployee(@Param("id") int id);

}
