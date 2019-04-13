/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.mission;

import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import phu.daos.MissionDAO;
import phu.dtos.MissionDTO;

/**
 *
 * @author Tachibana Kanade
 */
public class SearchMissionAction {

    private String searchMission, searchMissionBy;
    List<MissionDTO> list;
    private final String SUCCESS = "success";

    public List<MissionDTO> getList() {
        return list;
    }

    public void setList(List<MissionDTO> list) {
        this.list = list;
    }

    public String getSearchMission() {
        return searchMission;
    }

    public void setSearchMission(String searchMission) {
        this.searchMission = searchMission;
    }

    public String getSearchMissionBy() {
        return searchMissionBy;
    }

    public void setSearchMissionBy(String searchMissionBy) {
        this.searchMissionBy = searchMissionBy;
    }

    public SearchMissionAction() {
    }

    public String execute() throws Exception {
        MissionDAO dao = new MissionDAO();
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession sessions = request.getSession();
        sessions.setAttribute("error", "");
        try {
            switch (searchMissionBy) {
                case "mission name":
                    list = dao.searchByMissionName(searchMission);
                    break;

                case "status":
                    list = dao.searchByMissionStatus(searchMission);
                    break;
            }
        } catch (ClassNotFoundException | SQLException | NamingException e) {

        }
        return SUCCESS;
    }

}
