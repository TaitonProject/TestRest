package com.taiton.jsonConverter;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.taiton.entity.MessageEntity;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Taiton on 12/22/2016.
 */
public class MessageDeserializer extends JsonDeserializer<MessageEntity> {

    @Override
    public MessageEntity deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        MessageEntity message = new MessageEntity();
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        Date requestedDate = Date.valueOf(node.get("requestedDate").asText());
        //  Такое себе, потом переделать
        Time requestedTime = Time.valueOf(node.get("requestedTime").asText() + ":00");
        Time durationTime = Time.valueOf(node.get("durationTime").asText() + ":00");

        int idEmployee = node.get("employeeIdEmployee").get("idEmployee").asInt();

        message.setRequestedDate(requestedDate);
        message.setRequestedTime(requestedTime);
        message.setDurationTime(durationTime);
        message.setEmployeeIdEmployee(idEmployee);
        return message;
    }

}
