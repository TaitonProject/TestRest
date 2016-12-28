package com.taiton.dao;

import com.taiton.entity.BoardroomlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jsdev on 12/27/16.
 */
@Transactional
public interface BoardroomDao extends JpaRepository<BoardroomlistEntity, Integer> {
}
