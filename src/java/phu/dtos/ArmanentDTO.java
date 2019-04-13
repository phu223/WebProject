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
public class ArmanentDTO implements Serializable{
    private String gearCode,weaponCode;
    private int quantity;

    public ArmanentDTO(String gearCode, String weaponCode, String pilotCode, int quantity) {
        this.gearCode = gearCode;
        this.weaponCode = weaponCode;
        
        this.quantity = quantity;
    }

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

    

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ArmanentDTO(String gearCode, String weaponCode, int quantity) {
        this.gearCode = gearCode;
        this.weaponCode = weaponCode;
        this.quantity = quantity;
    }

    
    
}
