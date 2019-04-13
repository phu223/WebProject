/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.gears;

import phu.daos.CrewDAO;
import phu.daos.GearDAO;

/**
 *
 * @author Tachibana Kanade
 */
public class SoidlerRemoveGear {
    private String gearCode;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    public String getGearCode() {
        return gearCode;
    }

    public void setGearCode(String gearCode) {
        this.gearCode = gearCode;
    }
    public SoidlerRemoveGear() {
    }
    
    public String execute() throws Exception {
        CrewDAO dao = new CrewDAO();
        boolean result= dao.deleteCrew(gearCode);
        if (result) {
            GearDAO daoG = new GearDAO();
            boolean check=daoG.updateGearStatusToAvailable(gearCode);
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
