package com.taiton.jsonConverter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.taiton.entity.MessageEntity;
import com.taiton.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by jsdev on 12/23/16.
 */
public class MessageSerializer extends JsonSerializer<MessageEntity> {

    @Autowired
    EmployeeService employeeService;

    @Override
    public void serialize(MessageEntity message, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String requestedDate = new SimpleDateFormat("MM/dd/yyyy").format(message.getRequestedDate());
        String requestedTime = new SimpleDateFormat("HH:mm").format(message.getRequestedTime());
        String durationTime = new SimpleDateFormat("HH:mm").format(message.getDurationTime());
        String employeeName = employeeService.findOne(message.getEmployeeIdEmployee()).getName();
        String employeeIdName = employeeName + " " + message.getEmployeeIdEmployee();

        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("idMessage", message.getIdMessage());
        jsonGenerator.writeStringField("requestedDate", requestedDate);
        jsonGenerator.writeStringField("requestedTime", requestedTime);
        jsonGenerator.writeStringField("durationTime", durationTime);
        jsonGenerator.writeStringField("employee", employeeIdName);
        jsonGenerator.writeEndObject();

/*
        Если необходимо полностью объект сериализовать
        jsonGenerator.writeStringField("arrivalTime", arrivalTime);
        jsonGenerator.writeNumberField("employeeIdEmployee", message.getEmployeeIdEmployee());
        jsonGenerator.writeNumberField("boardroomlistIdBoardroomList", message.getBoardroomlistIdBoardroomList());
        jsonGenerator.writeStringField("employeeName", employeeService.find(message.getEmployeeIdEmployee()).getName());
                jsonGenerator.writeString(employeeDao.getOne(message.getEmployeeIdEmployee()).getName());
        jsonGenerator.writeNumberField("idMessage", message.getIdMessage());*/

    }
}
