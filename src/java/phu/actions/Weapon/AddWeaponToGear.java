/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.Weapon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import phu.daos.ArmanentDAO;
import phu.daos.GearDAO;

/**
 *
 * @author Tachibana Kanade
 */
public class AddWeaponToGear {

    private String gearCode, weaponCode;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    public String getGearCode() {
        return gearCode;
    }

    public void setGearCode(String gearCode) {
        this.gearCode = gearCode;
    }

    public String getWeaponCode() {
        return weaponCode;
    }

    public void setWeaponCode(String weaponCode) {
        this.weaponCode = weaponCode;
    }

    public AddWeaponToGear() {
    }

    public String execute() throws Exception {
        ArmanentDAO dao = new ArmanentDAO();
        GearDAO daoG = new GearDAO();
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession sessions = request.getSession();
        gearCode = (String) sessions.getAttribute("gearCode");
        boolean check = dao.checkArma(gearCode, weaponCode);
        if (check) {
            int quantity = dao.checkQuantity(gearCode, weaponCode);
            int limit = daoG.checkGearLimit(gearCode);
            if (quantity == limit) {
                sessions.setAttribute("limitation", "this gear had reach the limit of load");
                return FAIL;
            } else {
                boolean result = dao.updateWeaponFromGundam(gearCode, weaponCode, quantity + 1);
                if (result) {
                    sessions.setAttribute("limitation", "");
                    return SUCCESS;
                } else {
                    return FAIL;
                }
            }
        } else {
            boolean result = dao.addWeaponToGundam(gearCode, weaponCode);
            if (result) {
                sessions.setAttribute("limitation", "");
                return SUCCESS;
            } else {
                return FAIL;
            }
        }

    }

}
