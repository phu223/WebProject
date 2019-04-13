/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.Pilot;

import com.opensymphony.xwork2.ActionSupport;
import phu.daos.PilotDAO;
import phu.daos.SoidlerDAO;

/**
 *
 * @author Tachibana Kanade
 */
public class PilotUpdateAction extends ActionSupport{

    private String pilotCode, pilotName, rank, status;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public String getPilotCode() {
        return pilotCode;
    }

    public void setPilotCode(String pilotCode) {
        this.pilotCode = pilotCode;
    }

    public String getPilotName() {
        return pilotName;
    }

    public void setPilotName(String pilotName) {
        this.pilotName = pilotName;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    public PilotUpdateAction() {
    }

    @Override
    public void validate() {
        super.validate(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public String execute() throws Exception {
        PilotDAO dao = new PilotDAO();
        boolean result = dao.updatePilot(pilotCode, pilotName, rank, status);
        if (result) {
            SoidlerDAO daos= new SoidlerDAO();
            boolean check = daos.updateSoidlerPilot(pilotCode, pilotName);
            if (check) {
                return SUCCESS;
            }else{
                return FAIL;
            }
        }else{
            return FAIL;
        }
    }

}
