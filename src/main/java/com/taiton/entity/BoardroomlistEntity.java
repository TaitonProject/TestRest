package com.taiton.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

/**
 * Created by Taiton on 12/22/2016.
 */
@Entity
@Table(name = "boardroomlist", schema = "heroku_f53d154873f59df", catalog = "")
public class BoardroomlistEntity implements Serializable{
    private Integer idBoardroomList;
    private Time openningTime;
    private Time closingTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBoardroomList", nullable = false)
    public Integer getIdBoardroomList() {
        return idBoardroomList;
    }

    public void setIdBoardroomList(Integer idBoardroomList) {
        this.idBoardroomList = idBoardroomList;
    }

    @Basic
    @Column(name = "openningTime", nullable = false)
    public Time getOpenningTime() {
        return openningTime;
    }

    public void setOpenningTime(Time openningTime) {
        this.openningTime = openningTime;
    }

    @Basic
    @Column(name = "closingTime", nullable = false)
    public Time getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Time closingTime) {
        this.closingTime = closingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoardroomlistEntity that = (BoardroomlistEntity) o;

        if (idBoardroomList != null ? !idBoardroomList.equals(that.idBoardroomList) : that.idBoardroomList != null)
            return false;
        if (openningTime != null ? !openningTime.equals(that.openningTime) : that.openningTime != null) return false;
        if (closingTime != null ? !closingTime.equals(that.closingTime) : that.closingTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBoardroomList != null ? idBoardroomList.hashCode() : 0;
        result = 31 * result + (openningTime != null ? openningTime.hashCode() : 0);
        result = 31 * result + (closingTime != null ? closingTime.hashCode() : 0);
        return result;
    }
}
