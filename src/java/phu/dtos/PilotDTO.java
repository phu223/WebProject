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
public class PilotDTO implements Serializable{
    private String pilotCode, pilotName,rank,status;

    public PilotDTO(String pilotCode, String pilotName) {
        this.pilotCode = pilotCode;
        this.pilotName = pilotName;
    }

    public PilotDTO(String pilotCode, String pilotName, String rank, String status) {
        this.pilotCode = pilotCode;
        this.pilotName = pilotName;
        this.rank = rank;
        this.status = status;
    }

    public String getPilotCode() {
        return pilotCode;
    }

    public void setPilotCode(String pilotCode) {
        this.pilotCode = pilotCode;
    }

    public String getPilotName() {
        return pilotName;
    }

    public void setPilotName(String pilotName) {
        this.pilotName = pilotName;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
