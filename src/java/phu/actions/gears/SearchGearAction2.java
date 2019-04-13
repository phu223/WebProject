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
public class SearchGearAction2 {

    private String searchGear, searchGearFollow;
    private List<GearDTO> list;

    public String getSearchGear() {
        return searchGear;
    }

    public void setSearchGear(String searchGear) {
        this.searchGear = searchGear;
    }

    public String getSearchGearFollow() {
        return searchGearFollow;
    }

    public void setSearchGearFollow(String searchGearFollow) {
        this.searchGearFollow = searchGearFollow;
    }

    public List<GearDTO> getList() {
        return list;
    }

    public void setList(List<GearDTO> list) {
        this.list = list;
    }
    private final String SUCCESS = "success";

    public SearchGearAction2() {
    }

    public String execute() throws Exception {

        GearDAO dao = new GearDAO();

        switch (searchGearFollow) {
            case "gear name":
                list = dao.searchGearNameForPilot(searchGear);
                break;
            case "weapon slot":
                list = dao.searchGearWeaponSlotForPilot(Integer.parseInt(searchGear));
                break;
            default:
                break;
        }
        return SUCCESS;

    }
}
