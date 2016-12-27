package com.taiton.dao;

import com.taiton.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jsdev on 12/27/16.
 */
public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer> {
}
