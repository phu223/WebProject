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
public class DeleteMissionAction {

    private String missionCode;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    public String getMissionCode() {
        return missionCode;
    }

    public void setMissionCode(String missionCode) {
        this.missionCode = missionCode;
    }

    public DeleteMissionAction() {
    }

    public String execute() throws Exception {
        MissionDAO dao = new MissionDAO();
        boolean result = dao.deleteMissionDetail(missionCode);
        if (result) {
            boolean check = dao.deleteMission(missionCode);
            if (check) {
                return SUCCESS;
            } else {
                return FAIL;
            }
        } else {
            boolean check = dao.deleteMission(missionCode);
            if (check) {
                return SUCCESS;
            } else {
                return FAIL;
            }
        }
    }

}
