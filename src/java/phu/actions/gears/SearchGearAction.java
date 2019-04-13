/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.gears;

import static com.sun.activation.registries.LogSupport.log;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import phu.daos.GearDAO;
import phu.dtos.GearDTO;

/**
 *
 * @author Tachibana Kanade
 */
public class SearchGearAction {

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

    public SearchGearAction() {
    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession sessions = request.getSession();
        sessions.setAttribute("gearError", "");
        try {
            GearDAO dao = new GearDAO();
            switch (searchGearFollow) {
                case "gear name":
                    list = dao.searchGearName(searchGear);
                    break;
                case "gear type":
                    list = dao.searchGearType(searchGear);
                    break;
                case "status":
                    list = dao.searchGearStatus(searchGear);
                    break;
                case "weapon slot":
                    list = dao.searchGearWeaponSlot(Integer.parseInt(searchGear));
                default:
                    break;
            }

        } catch (SQLException e) {
            log(" " + e.getMessage());
        }
        return SUCCESS;

    }
}
