/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.gears;

import java.util.List;
import phu.daos.ArmanentDAO;
import phu.dtos.ArmanentDTO;

/**
 *
 * @author Tachibana Kanade
 */
public class SearchGearWeapon {

    private String gearCode;
    private List<ArmanentDTO> list;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    public List<ArmanentDTO> getList() {
        return list;
    }

    public void setList(List<ArmanentDTO> list) {
        this.list = list;
    }

    public String getGearCode() {
        return gearCode;
    }

    public void setGearCode(String gearCode) {
        this.gearCode = gearCode;
    }

    public SearchGearWeapon() {
    }

    public String execute() throws Exception {
        ArmanentDAO daos = new ArmanentDAO();
        list = daos.searchPilotGearWeapon(gearCode);
        return SUCCESS;
    }

}
