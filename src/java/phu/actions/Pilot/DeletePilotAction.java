/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.Pilot;

import phu.daos.CrewDAO;
import phu.daos.PilotDAO;
import phu.daos.SoidlerDAO;

/**
 *
 * @author Tachibana Kanade
 */
public class DeletePilotAction {

    private String pilotCode;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public String getPilotCode() {
        return pilotCode;
    }

    public void setPilotCode(String pilotCode) {
        this.pilotCode = pilotCode;
    }

    public DeletePilotAction() {
    }

    public String execute() throws Exception {
        PilotDAO dao = new PilotDAO();
        SoidlerDAO daos = new SoidlerDAO();
        boolean result = dao.deletePilot(pilotCode);
        if (result) {
            boolean check = daos.sendSoidlerToReserve(pilotCode, "Reserve");
            if (check) {
                CrewDAO daoss = new CrewDAO();
                boolean check2 = daoss.deleteCrewman(pilotCode);
                if (check2) {
                    return SUCCESS;
                } else {
                    return FAIL;
                }
            }else{
                CrewDAO daoss = new CrewDAO();
                boolean check2 = daoss.deleteCrewman(pilotCode);
                if (check2) {
                    return SUCCESS;
                } else {
                    return FAIL;
                }
            }
        }
        return SUCCESS;
    }

}
