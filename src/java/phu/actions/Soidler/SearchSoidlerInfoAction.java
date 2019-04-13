/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.Soidler;

import java.util.List;
import phu.daos.SoidlerDAO;
import phu.dtos.SoidlerDTO;

/**
 *
 * @author Tachibana Kanade
 */
public class SearchSoidlerInfoAction {
    private String username, fullname, rank;

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
    private List<SoidlerDTO> list;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    

    public List<SoidlerDTO> getList() {
        return list;
    }

    public void setList(List<SoidlerDTO> list) {
        this.list = list;
    }
    private final String SUCCESS = "success";
    public SearchSoidlerInfoAction() {
    }
    
    public String execute() throws Exception {
        SoidlerDAO dao = new SoidlerDAO();
        list=dao.searchBySoidlerInfo(username,fullname,rank);
        return SUCCESS;
    }
    
}
