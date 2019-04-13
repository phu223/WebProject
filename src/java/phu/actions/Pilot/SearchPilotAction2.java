/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.Pilot;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import phu.daos.PilotDAO;
import phu.dtos.PilotDTO;

/**
 *
 * @author Tachibana Kanade
 */
public class SearchPilotAction2 implements Serializable{

    private String searchPilot, searchPilotFollow;
    private List<PilotDTO> list;

    public List<PilotDTO> getList() {
        return list;
    }

    public void setList(List<PilotDTO> list) {
        this.list = list;
    }
    private final String SUCCESS = "success";

    public String getSearchPilot() {
        return searchPilot;
    }

    public void setSearchPilot(String searchPilot) {
        this.searchPilot = searchPilot;
    }

    public String getSearchPilotFollow() {
        return searchPilotFollow;
    }

    public void setSearchPilotFollow(String searchPilotFollow) {
        this.searchPilotFollow = searchPilotFollow;
    }

    public SearchPilotAction2() {
    }
    
    public String execute() throws Exception {
        PilotDAO dao = new PilotDAO();
        try{
        switch (searchPilotFollow) {
            case "rank":
                list = dao.searchByPilotRank(searchPilot);
                break;
            case "pilot name":
                list = dao.searchByPilotName(searchPilot);
                break;
            case "status":
                list = dao.searchByPilotStatus(searchPilot);
                break;
            default:
                break;
        }
        }catch(ClassNotFoundException | SQLException | NamingException e){
            
        }
        return SUCCESS;
    }

}
