package com.taiton.service.employee;

import com.taiton.dao.employee.EmployeeDao;
import com.taiton.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taiton on 11/6/2016.
 */
@Service

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public void save(EmployeeEntity employee) {
        employeeDao.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeDao.delete(id);
    }

    @Override
    public void delete(EmployeeEntity employeeEntity) {
        employeeDao.delete(employeeEntity);
    }

    @Override
    public EmployeeEntity find(int id) {
        return employeeDao.find(id);
    }

    @Override
    @Transactional
    public List<EmployeeEntity> findAll() {
        return employeeDao.findAll();
    }
}
