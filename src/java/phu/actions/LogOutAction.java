/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Tachibana Kanade
 */
public class LogOutAction {

    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public LogOutAction() {
    }

    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession sessions = request.getSession(false);
        Map session = ActionContext.getContext().getSession();
        session.clear();
        sessions.invalidate();
        return SUCCESS;
    }

}
