/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.Soidler;

import phu.daos.PilotDAO;
import phu.daos.SoidlerDAO;

/**
 *
 * @author Tachibana Kanade
 */
public class DeleteSoidlerAction {

    private String username, rank;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public DeleteSoidlerAction() {
    }

    public String execute() throws Exception {
        SoidlerDAO dao = new SoidlerDAO();
        PilotDAO daos = new PilotDAO();
        boolean check = daos.deletePilot(username);
        if (check) {
            boolean result = dao.deleteSoidler(username);
            if (result) {
                return SUCCESS;
            } else {
                return FAIL;
            }

        } else {
            boolean result = dao.deleteSoidler(username);
            if (result) {
                return SUCCESS;
            } else {
                return FAIL;
            }
        }

    }

}
