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
        String requestedDateString = node.get("requestedDate").asText();
        String requestedTimeString = node.get("requestedTime").asText();
        String durationTimeString = node.get("durationTime").asText();

        int idEmployee = node.get("employeeIdEmployee").get("idEmployee").asInt();

        SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatterTime = new SimpleDateFormat("hh:mm");
        Date requestedDate = null;
        Time requestedTime = null;
        Time durationTime = null;

        try {
            requestedDate = new Date(formatterDate.parse(requestedDateString).getTime());
            requestedTime = new Time(formatterTime.parse(requestedTimeString).getTime());
            durationTime = new Time(formatterTime.parse(durationTimeString).getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }
/*
        Time myTime = java.sql.Time.valueOf(requestedTimeString + ":00");

        LocalTime localtimeDuration = myTime.toLocalTime();
        localtimeDuration = localtimeDuration.plusMinutes(requestedTime.getMinutes()).plusHours(requestedTime.getHours());
*/
        message.setRequestedDate(requestedDate);
        message.setRequestedTime(requestedTime);
        //message.setDurationTime(Time.valueOf(localtimeDuration));
        message.setDurationTime(durationTime);
        message.setEmployeeIdEmployee(idEmployee);
        return message;
    }

}
