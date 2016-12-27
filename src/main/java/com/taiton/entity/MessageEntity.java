package com.taiton.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.taiton.jsonConverter.MessageDeserializer;
import com.taiton.jsonConverter.MessageSerializer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by Taiton on 12/23/2016.
 */
@JsonDeserialize(using = MessageDeserializer.class)
@JsonSerialize(using = MessageSerializer.class)
@Entity
@Table(name = "message", schema = "heroku_f53d154873f59df", catalog = "")
public class MessageEntity {
    private Integer idMessage;
    @NotNull
    private Time durationTime;
    @NotNull
    private Date requestedDate;
    @NotNull
    private Time requestedTime;
    private Timestamp arrivalTime;
    @NotNull
    private Integer employeeIdEmployee;
    private Integer boardroomlistIdBoardroomList;

    public MessageEntity(Integer idMessage, Time durationTime, Date requestedDate, Time requestedTime, Timestamp arrivalTime, Integer employeeIdEmployee, Integer boardroomlistIdBoardroomList) {
        this.idMessage = idMessage;
        this.durationTime = durationTime;
        this.requestedDate = requestedDate;
        this.requestedTime = requestedTime;
        this.arrivalTime = arrivalTime;
        this.employeeIdEmployee = employeeIdEmployee;
        this.boardroomlistIdBoardroomList = boardroomlistIdBoardroomList;
    }

    public MessageEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMessage", nullable = false)
    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    @Basic
    @Column(name = "durationTime", nullable = false)
    public Time getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(Time durationTime) {
        this.durationTime = durationTime;
    }

    @Basic
    @Column(name = "ArrivalTime", nullable = false)
    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity that = (MessageEntity) o;

        if (idMessage != null ? !idMessage.equals(that.idMessage) : that.idMessage != null) return false;
        if (durationTime != null ? !durationTime.equals(that.durationTime) : that.durationTime != null) return false;
        if (arrivalTime != null ? !arrivalTime.equals(that.arrivalTime) : that.arrivalTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMessage != null ? idMessage.hashCode() : 0;
        result = 31 * result + (durationTime != null ? durationTime.hashCode() : 0);
        result = 31 * result + (arrivalTime != null ? arrivalTime.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "Employee_idEmployee", nullable = false)
    public Integer getEmployeeIdEmployee() {
        return employeeIdEmployee;
    }

    public void setEmployeeIdEmployee(Integer employeeIdEmployee) {
        this.employeeIdEmployee = employeeIdEmployee;
    }

    @Basic
    @Column(name = "boardroomlist_idBoardroomList", nullable = false)
    public Integer getBoardroomlistIdBoardroomList() {
        return boardroomlistIdBoardroomList;
    }

    public void setBoardroomlistIdBoardroomList(Integer boardroomlistIdBoardroomList) {
        this.boardroomlistIdBoardroomList = boardroomlistIdBoardroomList;
    }

    @Basic
    @Column(name = "requestedDate", nullable = false)
    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    @Basic
    @Column(name = "requestedTime", nullable = false)
    public Time getRequestedTime() {
        return requestedTime;
    }

    public void setRequestedTime(Time requestedTime) {
        this.requestedTime = requestedTime;
    }

}
