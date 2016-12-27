package com.taiton.validator;

import com.taiton.entity.MessageEntity;
import com.taiton.service.boardroom.BoardroomService;
import com.taiton.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 * Created by Taiton on 12/23/2016.
 */
@Component("messageValidator")
public class MessageValidator implements Validator {

    @Autowired
    BoardroomService boardroomService;

    @Autowired
    EmployeeService employeeService;

    public MessageValidator(){};

    public MessageValidator(MessageEntity message) {
        if (message == null) {
            throw new IllegalArgumentException("The supplied [Validator] is " +
                    "required and must not be null.");
        } else if(employeeService.findOne(message.getEmployeeIdEmployee()) == null){
            throw new IllegalArgumentException("The supplied [Validator] is " +
                    "required and must not be null.");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return MessageEntity.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        //ValidationUtils.rejectIfEmpty(errors,"durationTime","message.empty");
        MessageEntity message = (MessageEntity) o;
        long g = message.getDurationTime().getTime();
        long closingTime = boardroomService.find(message.getBoardroomlistIdBoardroomList()).getClosingTime().getTime();
        long openningTime = boardroomService.find(message.getBoardroomlistIdBoardroomList()).getOpenningTime().getTime();
        long ggg = new Date(System.currentTimeMillis()).getTime();
        long fg = message.getRequestedDate().getTime();
        if(message.getRequestedTime().getTime() < openningTime){
            errors.reject("errorMessage","message.afterTime");
        } else if(message.getDurationTime().getTime() > closingTime){
            errors.reject("errorMessage","message.earlyTime");
        } else if(message.getRequestedDate().getTime() < new Date(System.currentTimeMillis()).getTime()){
            errors.reject("errorMessage","message.earlyDate");
        } else if(message.getDurationTime().getTime() <= message.getRequestedDate().getTime()){
            errors.reject("errorMessage","message.wrongInterval");
        }
    }

}
