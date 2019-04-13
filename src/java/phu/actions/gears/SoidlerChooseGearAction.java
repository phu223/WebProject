/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.gears;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import phu.daos.CrewDAO;
import phu.daos.GearDAO;

/**
 *
 * @author Tachibana Kanade
 */
public class SoidlerChooseGearAction {

    private String gearCode;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    public String getGearCode() {
        return gearCode;
    }

    public void setGearCode(String gearCode) {
        this.gearCode = gearCode;
    }

    public SoidlerChooseGearAction() {
    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession sessions = request.getSession();
        String pilotCode = (String) sessions.getAttribute("username");
        CrewDAO dao = new CrewDAO();
        boolean result = dao.pilotChooseGear(gearCode, pilotCode);
        if (result) {
            GearDAO daos = new GearDAO();
            boolean check = daos.updateGearStatus(gearCode);
            if (check) {
                return SUCCESS;
            } else {
                return FAIL;
            }

        } else {
            return FAIL;
        }
    }

}
