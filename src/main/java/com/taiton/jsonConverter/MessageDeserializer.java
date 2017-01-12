package com.taiton.jsonConverter;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.taiton.entity.MessageEntity;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;
import java.sql.Time;
import java.sql.Date;


/**
 * Created by Taiton on 12/22/2016.
 */
public class MessageDeserializer extends JsonDeserializer<MessageEntity> {

    @Override
    public MessageEntity deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        MessageEntity message = new MessageEntity();
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        /*String requestedDateStr = node.get("requestedDate").asText();
        String requestedTimeStr = node.get("requestedTime").asText();
        String durationTimeStr = node.get("durationTime").asText();

        DateTimeFormatter formatterDate = DateTimeFormat.forPattern("yyyy, MM, dd");
        DateTime requestedDate = formatterDate.parseDateTime(requestedDateStr);

        DateTimeFormatter formatterTime = DateTimeFormat.forPattern("hh:mm");
        DateTime requestedTime = formatterTime.parseDateTime(requestedTimeStr);
        DateTime durationTime = formatterTime.parseDateTime(durationTimeStr);
*/
        Date requestedDate = Date.valueOf(node.get("requestedDate").asText());
        //  Такое себе, потом переделать
        Time requestedTime = Time.valueOf(node.get("startTime").asText() + ":00");
        Time durationTime = Time.valueOf(node.get("endTime").asText() + ":00");

        int idEmployee = node.get("employee").asInt();

        ///int idMessage = node.get("idMessage").asInt();

        //message.setIdMessage(idMessage);
        message.setRequestedDate(requestedDate);
        message.setRequestedTime(requestedTime);
        message.setDurationTime(durationTime);
        message.setEmployeeIdEmployee(idEmployee);
        return message;
    }

}
