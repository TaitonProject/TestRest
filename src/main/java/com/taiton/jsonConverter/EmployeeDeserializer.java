package com.taiton.jsonConverter;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.taiton.entity.EmployeeEntity;

import java.io.IOException;


/**
 * Created by Taiton on 12/22/2016.
 */
public class EmployeeDeserializer extends JsonDeserializer<EmployeeEntity> {

    @Override
    public EmployeeEntity deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        EmployeeEntity employee = new EmployeeEntity();
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        String employeeString = node.get("employee").asText();

        String[] employeeParse = employeeString.split(employeeString);

        employee.setIdEmployee(Integer.getInteger(employeeParse[0]));
        employee.setName(employeeParse[1]);
        return employee;
    }

}
