/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.dtos;

import java.io.Serializable;

/**
 *
 * @author Tachibana Kanade
 */
public class WeaponDTO implements Serializable{
    private String weaponCode, weaponName, useFor, weaponType;
    private float firePower;
    private int storeQuantity;

    public WeaponDTO(String weaponCode, String weaponName, String useFor, String weaponType, float firePower, int storeQuantity) {
        this.weaponCode = weaponCode;
        this.weaponName = weaponName;
        this.useFor = useFor;
        this.weaponType = weaponType;
        this.firePower = firePower;
        this.storeQuantity = storeQuantity;
    }

    public WeaponDTO(String weaponCode, String weaponName, String useFor, String weaponType, float firePower) {
        this.weaponCode = weaponCode;
        this.weaponName = weaponName;
        this.useFor = useFor;
        this.weaponType = weaponType;
        this.firePower = firePower;
    }

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
    
}
