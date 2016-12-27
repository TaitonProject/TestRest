package com.taiton.dao;

import com.taiton.entity.BoardroomlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jsdev on 12/27/16.
 */
public interface BoardroomDao extends JpaRepository<BoardroomlistEntity, Integer> {
}
