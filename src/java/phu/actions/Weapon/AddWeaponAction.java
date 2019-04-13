/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.Weapon;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import phu.daos.WeaponDAO;

/**
 *
 * @author Tachibana Kanade
 */
public class AddWeaponAction {

    private String weaponCode, weaponName, useFor, weaponType;
    private float firePower;
    private int storeQuantity;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public String getWeaponCode() {
        return weaponCode;
    }

    public void setWeaponCode(String weaponCode) {
        this.weaponCode = weaponCode;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getUseFor() {
        return useFor;
    }

    public void setUseFor(String useFor) {
        this.useFor = useFor;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public float getFirePower() {
        return firePower;
    }

    public void setFirePower(float firePower) {
        this.firePower = firePower;
    }

    public int getStoreQuantity() {
        return storeQuantity;
    }

    public void setStoreQuantity(int storeQuantity) {
        this.storeQuantity = storeQuantity;
    }

    public AddWeaponAction() {
    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession sessions = request.getSession();
        try {
            WeaponDAO dao = new WeaponDAO();
            boolean result = dao.addWeapon(weaponCode, weaponName, firePower, storeQuantity, useFor, weaponType);
            if (result) {
                sessions.setAttribute("weaponError", "");
                return SUCCESS;
            } else {
                sessions.setAttribute("weaponError", "this weapon is already in stock");
                return FAIL;
            }
        } catch (ClassNotFoundException | SQLException e) {
            sessions.setAttribute("weaponError", "this weapon is already in stock");
            return FAIL;
        }

    }

}
