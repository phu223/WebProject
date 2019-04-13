/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions;

import com.opensymphony.xwork2.ActionContext;
import static com.sun.activation.registries.LogSupport.log;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import phu.daos.LoginDAO;
import javax.servlet.http.HttpSession;
import phu.daos.CrewDAO;
import phu.daos.GearDAO;
import phu.daos.MissionDAO;
import phu.daos.PilotDAO;
import phu.dtos.ArmanentDTO;
import phu.dtos.CrewDTO;
import phu.dtos.GearDTO;
import phu.dtos.MissionDTO;
import phu.dtos.MissionDetailDTO;
import phu.dtos.PilotDTO;

/**
 *
 * @author Tachibana Kanade
 */
public class LoginAction {

    private String username="", password="";
    private List<PilotDTO> list;
    private List<ArmanentDTO> list2;
    private List<CrewDTO> list3;
    private List<GearDTO> list4;
    private List<MissionDetailDTO> list5;
    private List<MissionDTO> list6;

    public List<MissionDetailDTO> getList5() {
        return list5;
    }

    public void setList5(List<MissionDetailDTO> list5) {
        this.list5 = list5;
    }

    public List<MissionDTO> getList6() {
        return list6;
    }

    public void setList6(List<MissionDTO> list6) {
        this.list6 = list6;
    }

    public List<GearDTO> getList4() {
        return list4;
    }

    public void setList4(List<GearDTO> list4) {
        this.list4 = list4;
    }

    public List<CrewDTO> getList3() {
        return list3;
    }

    public void setList3(List<CrewDTO> list3) {
        this.list3 = list3;
    }

    public List<ArmanentDTO> getList2() {
        return list2;
    }

    public void setList2(List<ArmanentDTO> list2) {
        this.list2 = list2;
    }

    public List<PilotDTO> getList() {
        return list;
    }

    public void setList(List<PilotDTO> list) {
        this.list = list;
    }
    private final String SUCCESSCOMMANDERCONFIRM = "CommanderLoginSuccess";
    private final String SUCCESSWEAPONENGINEER = "WeaponEngineerLoginSuccess";
    private final String SUCCESSPILOT = "PilotLoginSuccess";

    private final String SUCCESSRESERVE = "ReserveLoginSuccess";
    private final String FAIL = "fail";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginAction() {
    }

    public String execute() throws NamingException {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession sessions = request.getSession();
        Map session = ActionContext.getContext().getSession();
        String url = FAIL;
        try {
            LoginDAO dao = new LoginDAO();
            MissionDAO daoM = new MissionDAO();
            CrewDAO daoss = new CrewDAO();
            GearDAO daoG = new GearDAO();
            PilotDAO daoP = new PilotDAO();
            String result = dao.checkLogin(username, password);
            String fullname = null;
            String gearCode = null;
            switch (result) {
                case "Commander":
                    url = SUCCESSCOMMANDERCONFIRM;
                    break;
                case "Weapon Engineer":
                    fullname = dao.checkName(username, password);
                    url = SUCCESSWEAPONENGINEER;
                    break;
                case "Pilot":
                    String pilotRank = dao.checkPilotRank(username);
                    fullname = dao.checkName(username, password);
                    if (pilotRank.equals("Pilot")) {
                        list = daoP.getPilotName(username);
                        gearCode = daoss.searchPilotGear(username);
                        fullname = daoP.checkPilot(username);

                        list4 = daoG.searchGearNameByCode(gearCode);
                        fullname = dao.checkName(username, password);

                        list3 = daoss.searchGearPilots(gearCode);
                        list5 = daoM.searchByMissionDetailByPilotCode(username);

                        list6 = daoM.searchFullByMissionCode(daoM.searchMissionCode(username));
                        url = SUCCESSPILOT;
                    }
                    break;
                case "Reserve":
                    url = SUCCESSRESERVE;
                    break;
                default:
                    sessions.setAttribute("userError", "invalid username password");
                    url = FAIL;
                    break;
            }
            session.put("username", username);
            sessions.setAttribute("fullname", fullname);
            sessions.setAttribute("username", username);
            sessions.setAttribute("gearCode", gearCode);
            sessions.setAttribute("rank", result);
        } catch (ClassNotFoundException | SQLException e) {
            log("ERROR");
        }
        return url;
    }

}
