package com.taiton.dao.employee;

import com.taiton.entity.EmployeeEntity;

import java.util.List;

/**
 * Created by Taiton on 12/24/2016.
 */
public interface EmployeeDao {
    EmployeeEntity find(int id);

    boolean save(EmployeeEntity employee);

    void delete(int id);

    void delete(EmployeeEntity employee);

    List<EmployeeEntity> findAll();
}
