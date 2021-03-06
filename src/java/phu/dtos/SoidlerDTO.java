/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.dtos;

import java.io.Serializable;

/**
 *
 * @author Tachibana Kanade
 */
public class SoidlerDTO implements Serializable{
    private String username, password, fullname, rank;

    public SoidlerDTO(String username, String password, String fullname, String rank) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.rank = rank;
    }

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

    public SoidlerDTO(String username, String fullname, String rank) {
        this.username = username;
        this.fullname = fullname;
        this.rank = rank;
    }
    
}
