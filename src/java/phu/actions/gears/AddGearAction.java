/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.gears;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import phu.daos.GearDAO;

/**
 *
 * @author Tachibana Kanade
 */
public class AddGearAction {

    private String gearCode, gearName, type, status;
    private int slotAvailable, weaponSlot;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

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

    public int getWeaponSlot() {
        return weaponSlot;
    }

    public void setWeaponSlot(int weaponSlot) {
        this.weaponSlot = weaponSlot;
    }

    public AddGearAction() {
    }

    public String execute() {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession sessions = request.getSession();
        try {
            GearDAO dao = new GearDAO();
            boolean result = dao.addGear(gearCode, gearName, type, status, slotAvailable, weaponSlot);
            if (result) {
                sessions.setAttribute("gearError", "");
                return SUCCESS;
            } else {
                sessions.setAttribute("gearError", "this gear is created");
                return FAIL;
            }
        } catch (ClassNotFoundException | SQLException e) {
            sessions.setAttribute("gearError", "this gear is created");
            return FAIL;
        }

    }

}
