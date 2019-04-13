/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.Weapon;

import phu.daos.ArmanentDAO;
import phu.daos.WeaponDAO;

/**
 *
 * @author Tachibana Kanade
 */
public class DeleteWeaponAction {

    private String searchWeapon;
    private String weaponCode;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public String getSearchWeapon() {
        return searchWeapon;
    }

    public void setSearchWeapon(String searchWeapon) {
        this.searchWeapon = searchWeapon;
    }

    public String getWeaponCode() {
        return weaponCode;
    }

    public void setWeaponCode(String weaponCode) {
        this.weaponCode = weaponCode;
    }

    public DeleteWeaponAction() {
    }

    public String execute() throws Exception {
        ArmanentDAO daoA = new ArmanentDAO();
        WeaponDAO dao = new WeaponDAO();
        boolean result = daoA.deleteWeapon(weaponCode);
        if (result) {
            boolean check = dao.deleteWeapon(weaponCode);
            if (check) {
                return SUCCESS;
            } else {
                return FAIL;
            }

        } else {
            boolean check = dao.deleteWeapon(weaponCode);
            if (check) {
                return SUCCESS;
            } else {
                return FAIL;
            }
        }

    }

}
