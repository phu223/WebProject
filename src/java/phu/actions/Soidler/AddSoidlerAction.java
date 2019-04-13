/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.Soidler;

import java.io.Serializable;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import phu.daos.SoidlerDAO;

/**
 *
 * @author Tachibana Kanade
 */
public class AddSoidlerAction implements Serializable {

    private String username, password, fullname, rank;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public AddSoidlerAction() {
    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession sessions = request.getSession();
        try {
            SoidlerDAO dao = new SoidlerDAO();
            boolean result = dao.addSoidler(username, password, fullname, rank);
            if (result) {
                sessions.setAttribute("soidlerError", "");
                return SUCCESS;
            } else {
                sessions.setAttribute("soidlerError", "this user already exist");
                return FAIL;
            }
        } catch (ClassNotFoundException | SQLException e) {
            sessions.setAttribute("soidlerError", "this user already exist");
            return FAIL;
        }

    }

}
