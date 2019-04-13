/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.mission;

import java.sql.Date;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import phu.daos.MissionDAO;

/**
 *
 * @author Tachibana Kanade
 */
public class AddMissionAction {

    private String missionCode, missionName, status, type, startDate;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public AddMissionAction() {
    }

    public String execute() {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession sessions = request.getSession();
        try {
            MissionDAO dao = new MissionDAO();
            Date date = null;
            try {
                date = Date.valueOf(startDate);
            } catch (Exception e) {
                sessions.setAttribute("dateError", "date error");
                return FAIL;
            }
            boolean result = dao.addMission(missionCode, missionName, date, status, type);
            if (result) {
                sessions.setAttribute("missionError", "");
                return SUCCESS;
                
            } else {
                sessions.setAttribute("missionError", "this mission is created");
                return FAIL;
            }
        } catch (ClassNotFoundException | SQLException e) {
            sessions.setAttribute("missionError", "this mission is created");
            return FAIL;
        }

    }

}
