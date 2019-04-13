/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.gears;

import java.util.List;
import phu.daos.GearDAO;
import phu.dtos.GearDTO;

/**
 *
 * @author Tachibana Kanade
 */
public class SearchGearAction4 {

    private String gearCode;
    private List<GearDTO> list2;

    public String getGearCode() {
        return gearCode;
    }

    public void setGearCode(String gearCode) {
        this.gearCode = gearCode;
    }

    public List<GearDTO> getList2() {
        return list2;
    }

    public void setList2(List<GearDTO> list) {
        this.list2 = list;
    }
    private final String SUCCESS = "success";

    public SearchGearAction4() {
    }

    public String execute() throws Exception {

        GearDAO dao = new GearDAO();

        list2 = dao.searchGearByCode(gearCode);
        return SUCCESS;

    }
}
