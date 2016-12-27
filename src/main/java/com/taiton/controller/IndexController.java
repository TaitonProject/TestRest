package com.taiton.controller;

import com.taiton.entity.EmployeeEntity;
import com.taiton.entity.MessageEntity;
import com.taiton.service.employee.EmployeeService;
import com.taiton.service.message.MessageService;
import com.taiton.validator.MessageValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;


/**
 * Created by Taiton on 10/25/2016.
 */
@RestController
public class IndexController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    MessageService messageService;

    @Autowired
    MessageValidator messageValidator;

/*    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new MessageValidator());
    }*/


    @PostMapping("/addMessage")
    public void addMessage(@RequestBody MessageEntity message, BindingResult bindingResult) {

        messageValidator.validate(message, bindingResult);
        if (!bindingResult.hasErrors()) {
            if (!messageService.save(message)) {
                //выкинуть ошибку
                String g = "g";
            }
            String gh = "gr";
        }
    }

    @GetMapping("/employeeList.json")
    public List<EmployeeEntity> fetchEmployeeList() {
        List<EmployeeEntity> employeeEntities = employeeService.findAll();
        return employeeEntities;
    }

    @GetMapping("/messagesList.json/{date}")
    public List<MessageEntity> fetchMessagesList(@PathVariable("date") Date date) {
        List<MessageEntity> messageEntities = messageService.findByDate(date);
        return messageEntities;
    }

    @PutMapping(value = "/update")
    public void updateRailwayStation(@RequestBody MessageEntity message) {
        messageService.save(message);
    }


/*
    Query query = getSession().createQuery("FROM MessageEntity as m WHERE (m.requestedDate = :messageInput_requestDate)" +
            "and (m.boardroomlistIdBoardroomList = :messageInput_boardroomid) and" +
            "((:mIstart > m.requestedTime and :mIstart < m.durationTime) or" +
            "(:mIend < m.durationTime and :mIend > m.requestedTime) or" +
            "(:mIstart < m.requestedTime and :mIend > m.durationTime))")
            .setParameter("messageInput_requestDate", messageInput.getRequestedDate(), TemporalType.DATE).
                    setParameter("messageInput_boardroomid", messageInput.getBoardroomlistIdBoardroomList())
            .setParameter("mIstart", messageInput.getRequestedTime(), TemporalType.TIME)
            .setParameter("mIend", messageInput.getDurationTime(), TemporalType.TIME);
*/


}
