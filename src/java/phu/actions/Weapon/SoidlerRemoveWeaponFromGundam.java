/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.Weapon;

import phu.daos.ArmanentDAO;

/**
 *
 * @author Tachibana Kanade
 */
public class SoidlerRemoveWeaponFromGundam {

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

    public SoidlerRemoveWeaponFromGundam() {
    }

    public String execute() throws Exception {
        ArmanentDAO dao = new ArmanentDAO();
        
        int quantity = dao.checkQuantity(gearCode, weaponCode);
        if (quantity == 1) {
            boolean result = dao.deleteWeaponFromGundam(gearCode);
            if (result) {
                return SUCCESS;
            } else {
                return SUCCESS;
            }
        } else {
            boolean result = dao.updateWeaponFromGundam(gearCode, weaponCode, quantity - 1);
            if (result) {
                return SUCCESS;
            } else {
                return SUCCESS;
            }
        }
        
    }

}
