/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.Soidler;

import static com.sun.activation.registries.LogSupport.log;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import phu.daos.SoidlerDAO;
import phu.dtos.SoidlerDTO;

/**
 *
 * @author Tachibana Kanade
 */
public class SearchSoidlerAction implements Serializable {

    private String searchSoidler, searchSoidlerFollow;
    private List<SoidlerDTO> list;
    private final String SUCCESS = "success";

    public String getSearchSoidler() {
        return searchSoidler;
    }

    public List<SoidlerDTO> getList() {
        return list;
    }

    public void setList(List<SoidlerDTO> list) {
        this.list = list;
    }

    public void setSearchSoidler(String searchSoidler) {
        this.searchSoidler = searchSoidler;
    }

    public String getSearchSoidlerFollow() {
        return searchSoidlerFollow;
    }

    public void setSearchSoidlerFollow(String searchSoidlerFollow) {
        this.searchSoidlerFollow = searchSoidlerFollow;
    }

    public SearchSoidlerAction() {
    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession sessions = request.getSession();
        sessions.setAttribute("soidlerError", "");
        SoidlerDAO dao = new SoidlerDAO();
        try {
            switch (searchSoidlerFollow) {
                case "rank":
                    list = dao.searchBySoidlerRank(searchSoidler);
                    break;
                case "fullname":
                    list = dao.searchBySoidlerName(searchSoidler);
                    break;

                default:
                    break;
            }

        } catch (ClassNotFoundException | SQLException | NamingException e) {
            log(" " + e.getMessage());
        }
        return SUCCESS;
    }

}
