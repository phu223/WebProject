/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.mission;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import phu.daos.MissionDAO;

/**
 *
 * @author Tachibana Kanade
 */
public class AddPilotToMissionAction {

    private String missionCode, pilotCode;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public String getMissionCode() {
        return missionCode;
    }

    public void setMissionCode(String missionCode) {
        this.missionCode = missionCode;
    }

    public String getPilotCode() {
        return pilotCode;
    }

    public void setPilotCode(String pilotCode) {
        this.pilotCode = pilotCode;
    }

    public AddPilotToMissionAction() {
    }

    public String execute() throws Exception {
        MissionDAO dao = new MissionDAO();
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession sessions = request.getSession();
        missionCode = (String) sessions.getAttribute("missionCode");
        boolean check = dao.searchMissionDetail(missionCode, pilotCode);
        if (check) {
            sessions.setAttribute("error", "This pilot is already in");
            return FAIL;
        } else {
            boolean result = dao.addPilotForMission(missionCode, pilotCode);
            if (result) {
                sessions.setAttribute("error", "");
                return SUCCESS;
            } else {
                sessions.setAttribute("error", "This pilot is already in");
                return FAIL;
            }
        }
    }
}
