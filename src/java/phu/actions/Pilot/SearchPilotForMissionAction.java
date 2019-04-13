/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.Pilot;

import java.io.Serializable;
import java.util.List;
import phu.daos.PilotDAO;
import phu.dtos.PilotDTO;

/**
 *
 * @author Tachibana Kanade
 */
public class SearchPilotForMissionAction implements Serializable {

    private String searchPilot;
    private List<PilotDTO> list;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public String getSearchPilot() {
        return searchPilot;
    }

    public void setSearchPilot(String searchPilot) {
        this.searchPilot = searchPilot;
    }

    public List<PilotDTO> getList() {
        return list;
    }

    public void setList(List<PilotDTO> list) {
        this.list = list;
    }

    public SearchPilotForMissionAction() {
    }

    public String execute() throws Exception {
        PilotDAO dao = new PilotDAO();

        list = dao.searchByPilotNameStatus(searchPilot);
        return SUCCESS;
    }

}
