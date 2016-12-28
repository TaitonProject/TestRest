package com.taiton.service.employee;

import com.taiton.dao.EmployeeDao;
import com.taiton.dao.MessageDao;
import com.taiton.entity.EmployeeEntity;
import com.taiton.entity.MessageEntity;
import com.taiton.service.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taiton on 11/6/2016.
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageDao messageDao;

    @Override
    public void save(EmployeeEntity employee) {
        employeeDao.save(employee);
    }

    @Override
    public void saveAndFlush(EmployeeEntity employeeEntity) {
        employeeDao.saveAndFlush(employeeEntity);
    }

    @Override
    public void delete(int id) {
        messageDao.deleteByEmployee_idEmployee(id);
        //deleteAllMessages(id);
        employeeDao.delete(id);
    }

    @Override
    public void delete(EmployeeEntity employeeEntity) {
        employeeDao.delete(employeeEntity);
    }

    @Override
    public EmployeeEntity findOne(int id) {
        return employeeDao.findOne(id);
    }

    @Override
    public List<EmployeeEntity> findAll() {
        return employeeDao.findAll();
    }

}
