/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.Weapon;

import phu.daos.WeaponDAO;

/**
 *
 * @author Tachibana Kanade
 */
public class WeaponUpdateAction {

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

    public WeaponUpdateAction() {
    }

    public String execute() throws Exception {
        WeaponDAO dao = new WeaponDAO();
        boolean result = dao.updateWeapon(weaponCode, weaponName, firePower, storeQuantity, useFor, weaponType);
        if (result) {
            return SUCCESS;
        }else{
            return FAIL;
        }
    }

}
