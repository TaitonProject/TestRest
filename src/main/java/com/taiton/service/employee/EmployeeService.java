package com.taiton.service.employee;

import com.taiton.entity.BoardroomlistEntity;
import com.taiton.entity.EmployeeEntity;

import java.util.List;

/**
 * Created by Taiton on 11/6/2016.
 */
public interface EmployeeService {
    void save(EmployeeEntity employeeEntity);

    void delete(int id);

    void delete(EmployeeEntity employeeEntity);

    EmployeeEntity find(int id);

    List<EmployeeEntity> findAll();
}
