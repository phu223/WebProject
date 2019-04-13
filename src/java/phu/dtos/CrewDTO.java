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
public class CrewDTO implements Serializable{
    private String gearCode, pilotCode;

    public CrewDTO(String gearCode, String pilotCode) {
        this.gearCode = gearCode;
        this.pilotCode = pilotCode;
    }

    public String getGearCode() {
        return gearCode;
    }

    public void setGearCode(String gearCode) {
        this.gearCode = gearCode;
    }

    public String getPilotCode() {
        return pilotCode;
    }

    public void setPilotCode(String pilotCode) {
        this.pilotCode = pilotCode;
    }
    
}
