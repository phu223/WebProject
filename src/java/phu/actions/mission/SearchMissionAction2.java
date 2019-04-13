/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.mission;

import java.util.List;
import phu.daos.MissionDAO;
import phu.dtos.MissionDTO;

/**
 *
 * @author Tachibana Kanade
 */
public class SearchMissionAction2 {

    private String missionCode;
    List<MissionDTO> list;
    private final String SUCCESS = "success";

    public List<MissionDTO> getList() {
        return list;
    }

    public void setList(List<MissionDTO> list) {
        this.list = list;
    }

    public String getMissionCode() {
        return missionCode;
    }

    public void setMissionCode(String missionCode) {
        this.missionCode = missionCode;
    }

    public SearchMissionAction2() {
    }

    public String execute() throws Exception {
        MissionDAO dao = new MissionDAO();
        list = dao.searchFullByMissionCode(missionCode);

        return SUCCESS;
    }

}
