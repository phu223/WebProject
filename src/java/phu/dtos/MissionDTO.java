/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.dtos;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Tachibana Kanade
 */
public class MissionDTO implements Serializable {

    private String missionCode, missionName, status, type;
    private Date startDate;

    

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public MissionDTO(String missionCode, String missionName, String status, String type, Date startDate) {
        this.missionCode = missionCode;
        this.missionName = missionName;
        this.status = status;
        this.type = type;
        this.startDate = startDate;
    }

    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MissionDTO(String missionCode, String missionName, String status, Date date) {
        this.missionCode = missionCode;
        this.missionName = missionName;
        this.status = status;

    }

    public MissionDTO(String missionCode, String missionName, String status) {
        this.missionCode = missionCode;
        this.missionName = missionName;
        this.status = status;
    }

    public MissionDTO(String missionCode) {
        this.missionCode = missionCode;
    }

    public String getMissionCode() {
        return missionCode;
    }

    public void setMissionCode(String missionCode) {
        this.missionCode = missionCode;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
