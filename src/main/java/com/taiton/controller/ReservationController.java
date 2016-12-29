package com.taiton.controller;

import com.taiton.entity.EmployeeEntity;
import com.taiton.entity.MessageEntity;
import com.taiton.service.employee.EmployeeService;
import com.taiton.service.message.MessageService;
import com.taiton.validator.MessageValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;


/**
 * Created by Taiton on 10/25/2016.
 */
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    MessageService messageService;

    @Autowired
    MessageValidator messageValidator;

    @PostMapping("/addMessage")
    public ResponseEntity<MessageEntity> addMessage(@RequestBody MessageEntity message, BindingResult bindingResult) {
        message.setBoardroomlistIdBoardroomList(14);
        messageValidator.validate(message, bindingResult);
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else if (messageService.save(message)) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/employeeList.json")
    public List<EmployeeEntity> fetchEmployeeList() {
        List<EmployeeEntity> employeeEntities = employeeService.findAll();
        return employeeEntities;
    }

    @GetMapping("/messagesList.json/{date}")
    public ResponseEntity<List<MessageEntity>> fetchMessagesList(@PathVariable("date") Date date) {
        List<MessageEntity> messageEntities = messageService.findByDate(date);
        if (!messageEntities.isEmpty())
            return new ResponseEntity<>(messageEntities, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/update")
    public void updateRailwayStation(@RequestBody MessageEntity message) {
        messageService.save(message);
    }

}
