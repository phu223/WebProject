/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.actions.Soidler;

import java.sql.SQLException;
import javax.naming.NamingException;
import phu.daos.PilotDAO;
import phu.daos.SoidlerDAO;

/**
 *
 * @author Tachibana Kanade
 */
public class SoidlerUpdateAction {

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

    public SoidlerUpdateAction() {
    }

    public String execute() throws SQLException, NamingException, ClassNotFoundException {
        SoidlerDAO dao = new SoidlerDAO();
        PilotDAO daos = new PilotDAO();
        String s = daos.checkPilot(username);
        try {
            switch (rank) {
                case "Pilot":
                    boolean result = dao.updateSoidler(username, password, fullname, "Pilot");
                    if (result) {

                        if (s.equals(username)) {
                            boolean check = daos.updatePilot(username, fullname, "Pilot", "Available");
                            if (check) {
                                return SUCCESS;
                            } else {
                                return FAIL;
                            }
                        } else  {
                            boolean check = daos.addPilot(username, fullname, "Pilot", "Available");
                            if (check) {
                                return SUCCESS;
                            } else {
                                return FAIL;
                            }
                        }

                    } else {
                        return FAIL;
                    }

                
                case "Commander":
                    if (s.equals(username)) {
                        boolean check = daos.deletePilot(username);
                        if (check) {
                            boolean result3 = dao.updateSoidler(username, password, fullname, rank);
                            if (result3) {
                                return SUCCESS;
                            } else {
                                return FAIL;
                            }
                        } else {
                            boolean result3 = dao.updateSoidler(username, password, fullname, rank);
                            if (result3) {
                                return SUCCESS;
                            } else {
                                return FAIL;
                            }
                        }

                    }

                case "Reserve":
                    if (s.equals(username)) {
                        boolean check = daos.deletePilot(username);
                        if (check) {
                            boolean result4 = dao.updateSoidler(username, password, fullname, rank);
                            if (result4) {
                                return SUCCESS;
                            } else {
                                return FAIL;
                            }
                        } else {
                            boolean result4 = dao.updateSoidler(username, password, fullname, rank);
                            if (result4) {
                                return SUCCESS;
                            } else {
                                return FAIL;
                            }
                        }

                    }
                case "Weapon Engineer":
                    if (s.equals(username)) {
                        boolean check = daos.deletePilot(username);
                        if (check) {
                            boolean result5 = dao.updateSoidler(username, password, fullname, rank);
                            if (result5) {
                                return SUCCESS;
                            } else {
                                return FAIL;
                            }
                        } else {
                            boolean result5 = dao.updateSoidler(username, password, fullname, rank);
                            if (result5) {
                                return SUCCESS;
                            } else {
                                return FAIL;
                            }
                        }
                    }

                default:
                    return FAIL;
            }
        } catch (ClassNotFoundException | SQLException e) {
            return FAIL;
        }
    }

}
