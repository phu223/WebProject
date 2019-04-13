/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.gears;

import java.util.List;
import phu.daos.ArmanentDAO;
import phu.daos.CrewDAO;
import phu.daos.GearDAO;
import phu.daos.PilotDAO;
import phu.dtos.CrewDTO;

/**
 *
 * @author Tachibana Kanade
 */
public class RemoveGearAction {

    private String gearCode;
    private List<CrewDTO> list;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    public List<CrewDTO> getList() {
        return list;
    }

    public void setList(List<CrewDTO> list) {
        this.list = list;
    }

    public String getGearCode() {
        return gearCode;
    }

    public void setGearCode(String gearCode) {
        this.gearCode = gearCode;
    }

    public RemoveGearAction() {
    }

    public String execute() throws Exception {
        GearDAO dao = new GearDAO();
        boolean result = dao.deleteGear(gearCode);
        if (result) {
            ArmanentDAO daos = new ArmanentDAO();
            boolean check1 = daos.deleteWeaponFromGundam(gearCode);
            if (check1) {
                CrewDAO daoss = new CrewDAO();
                list = daoss.searchGearPilots(gearCode);
                boolean check2 = daoss.deleteCrew(gearCode);
                if (check2) {
                    PilotDAO daoP = new PilotDAO();
                    for (CrewDTO crewDTO : list) {
                        daoP.updatePilot(crewDTO.getPilotCode(), "Available");
                    }
                    return SUCCESS;
                } else {
                    return SUCCESS;

                }
            } else {
                return SUCCESS;
            }
        } else {
            return SUCCESS;
        }
    }

}
