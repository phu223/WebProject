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
import phu.daos.CrewDAO;
import phu.daos.WeaponDAO;
import phu.dtos.CrewDTO;
import phu.dtos.WeaponDTO;

/**
 *
 * @author Tachibana Kanade
 */
public class SearchWeaponAction2 {

    private String searchWeapon, searchWeaponType;
    private List<WeaponDTO> list;
    private List<CrewDTO> list2;

    public List<CrewDTO> getList2() {
        return list2;
    }

    public void setList2(List<CrewDTO> list2) {
        this.list2 = list2;
    }
    private final String SUCCESS = "success";

    public String getSearchWeaponType() {
        return searchWeaponType;
    }

    public void setSearchWeaponType(String searchWeaponType) {
        this.searchWeaponType = searchWeaponType;
    }

    public SearchWeaponAction2() {
    }

    public String execute() throws Exception {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpSession sessions = request.getSession(false);
            String username = (String) sessions.getAttribute("username");
            CrewDAO daos = new CrewDAO();

            WeaponDAO dao = new WeaponDAO();
            switch (searchWeaponType) {
                case "weapon name":
                    list = dao.searchByWeaponNameForPilot(searchWeapon);
                    list2 = daos.searchGearByPilotCode(username);
                    break;
                case "weapon type":
                    list = dao.searchByWeaponTypeForPilot(searchWeapon);
                    list2 = daos.searchGearByPilotCode(username);
                    break;
                case "use for":
                    list = dao.searchByWeaponUseForPilot(searchWeapon);
                    list2 = daos.searchGearByPilotCode(username);
                    break;
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
