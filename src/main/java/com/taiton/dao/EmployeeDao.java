package com.taiton.dao;

import com.taiton.entity.EmployeeEntity;
import com.taiton.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jsdev on 12/27/16.
 */
@Transactional
public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer> {

}
