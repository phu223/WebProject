/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.Weapon;

import static com.sun.activation.registries.LogSupport.log;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import phu.daos.WeaponDAO;
import phu.dtos.WeaponDTO;

/**
 *
 * @author Tachibana Kanade
 */
public class SearchWeaponAction {

    private String searchWeapon, searchWeaponType;
    private List<WeaponDTO> list;
    private final String SUCCESS = "success";

    public String getSearchWeaponType() {
        return searchWeaponType;
    }

    public void setSearchWeaponType(String searchWeaponType) {
        this.searchWeaponType = searchWeaponType;
    }

    public SearchWeaponAction() {
    }

    @Action("/searchWeapon")
    public String execute() throws Exception {
        try {
//            HttpServletRequest request = ServletActionContext.getRequest();
//            HttpSession sessions = request.getSession(false);
//            String rank = (String) sessions.getAttribute("rank");
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpSession sessions = request.getSession();
            sessions.setAttribute("weaponError", "");
            WeaponDAO dao = new WeaponDAO();
            switch (searchWeaponType) {
                case "weapon name":
                    list = dao.searchByWeaponName(searchWeapon);
                    break;
                case "weapon type":
                    list = dao.searchByWeaponType(searchWeapon);
                    break;
                case "use for":
                    list = dao.searchByWeaponUse(searchWeapon);
                    break;
                case "":
                    list = dao.searchByWeaponName(searchWeapon);
                default:
                    break;
            }

        } catch (ClassNotFoundException | SQLException | NamingException e) {
            log(" " + e.getMessage());
        }
        return SUCCESS;

    }

    public String getSearchWeapon() {
        return searchWeapon;
    }

    public void setSearchWeapon(String searchWeapon) {
        this.searchWeapon = searchWeapon;
    }

    public List<WeaponDTO> getList() {
        return list;
    }
}
