package com.taiton.jsonConverter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.taiton.entity.EmployeeEntity;

import java.io.IOException;

/**
 * Created by jsdev on 12/23/16.
 */
public class EmployeeSerializer extends JsonSerializer<EmployeeEntity> {

    @Override
    public void serialize(EmployeeEntity employee, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("employee", employee.getIdEmployee().toString() + " " + employee.getName());
        jsonGenerator.writeEndObject();

    }
}
