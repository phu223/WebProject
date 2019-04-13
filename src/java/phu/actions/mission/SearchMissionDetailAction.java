/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.mission;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import phu.daos.MissionDAO;
import phu.dtos.MissionDetailDTO;

/**
 *
 * @author Tachibana Kanade
 */
public class SearchMissionDetailAction {

    private String missionCode;
    private List<MissionDetailDTO> list;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public String getMissionCode() {
        return missionCode;
    }

    public void setMissionCode(String missionCode) {
        this.missionCode = missionCode;
    }

    public List<MissionDetailDTO> getList() {
        return list;
    }

    public void setList(List<MissionDetailDTO> list) {
        this.list = list;
    }

    public SearchMissionDetailAction() {
    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession sessions = request.getSession();
        if (missionCode != null) {
            MissionDAO dao = new MissionDAO();
            list = dao.searchByMissionDetailCode(missionCode);
            sessions.setAttribute("missionCode", missionCode);
            return SUCCESS;
        } else {
            missionCode = (String) sessions.getAttribute("missionCode");
            MissionDAO dao = new MissionDAO();
            list = dao.searchByMissionDetailCode(missionCode);
            sessions.setAttribute("missionCode", missionCode);
            return SUCCESS;
        }

    }

}
