package com.taiton.controller;

import com.taiton.entity.EmployeeEntity;
import com.taiton.entity.MessageEntity;
import com.taiton.exceptions.ResourceNotFoundException;
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
/*
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new MessageValidator());
    }*/



    @PostMapping("/addMessage")
    public ResponseEntity<String> addMessage(@RequestBody MessageEntity message, BindingResult bindingResult) {
        message.setBoardroomlistIdBoardroomList(14);
        messageValidator.validate(message, bindingResult);
        if (!bindingResult.hasErrors())
        {
            if (messageService.save(message)) {
                return ResponseEntity.ok("Ok!");
                //выкинуть ошибку
            }
            //return "Добавление прошло успещно";
        } else {
            throw new ResourceNotFoundException();
        }
        return ResponseEntity.badRequest().body("Bad Request");
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

}
