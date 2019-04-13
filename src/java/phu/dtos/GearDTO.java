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
public class GearDTO implements Serializable {

    public GearDTO(String gearCode) {
        this.gearCode = gearCode;
    }

    private String gearCode, gearName, type, status;
    private int slotAvailable, weaponSlot;

    public GearDTO(String gearCode, String gearName, int slotAvailable, int weaponSlot) {
        this.gearCode = gearCode;
        this.gearName = gearName;
        this.slotAvailable = slotAvailable;
        this.weaponSlot = weaponSlot;
    }

    public GearDTO(String gearCode, String gearName) {
        this.gearCode = gearCode;
        this.gearName = gearName;
    }

    public int getWeaponSlot() {
        return weaponSlot;
    }

    public void setWeaponSlot(int weaponSlot) {
        this.weaponSlot = weaponSlot;
    }

    public GearDTO(String gearCode, String gearName, String type, String status, int slotAvailable, int weaponSlot) {
        this.gearCode = gearCode;
        this.gearName = gearName;
        this.type = type;
        this.status = status;
        this.slotAvailable = slotAvailable;
        this.weaponSlot = weaponSlot;
    }

    public GearDTO(String gearCode, String gearName, String type, String status, int slotAvailable) {
        this.gearCode = gearCode;
        this.gearName = gearName;
        this.type = type;
        this.status = status;
        this.slotAvailable = slotAvailable;
    }

    public String getGearCode() {
        return gearCode;
    }

    public void setGearCode(String gearCode) {
        this.gearCode = gearCode;
    }

    public String getGearName() {
        return gearName;
    }

    public void setGearName(String gearName) {
        this.gearName = gearName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSlotAvailable() {
        return slotAvailable;
    }

    public void setSlotAvailable(int slotAvailable) {
        this.slotAvailable = slotAvailable;
    }

}
