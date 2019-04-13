/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.mission;

import phu.daos.MissionDAO;

/**
 *
 * @author Tachibana Kanade
 */
public class UpdateMissionAction {
    private String missionCode, missionName, status;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
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
    public UpdateMissionAction() {
    }
    
    public String execute() throws Exception {
        MissionDAO dao = new MissionDAO();
        boolean result = dao.updateMission(missionCode, missionName, status);
        if (result) {
            return SUCCESS;
        }else{
            return FAIL;
        }
        
    }
    
}
