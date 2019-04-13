/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import phu.utils.MyConnection;

/**
 *
 * @author Tachibana Kanade
 */
public class LoginDAO implements Serializable {
    
    private void closeConnection(Connection conn, PreparedStatement preStm, ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
    public String checkLogin(String username, String password) throws ClassNotFoundException, SQLException{
        String rank="unrank";
        Connection conn = null ;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        
        try {
            conn = MyConnection.getConnection();
            String sql = "Select rank from tblUser where username=? and password=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs=preStm.executeQuery();
            if (rs.next()) {
                rank = rs.getString("rank");
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return rank;
    }
    public String checkPassword(String username) throws ClassNotFoundException, SQLException{
        String password="1";
        Connection conn = null ;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        
        try {
            conn = MyConnection.getConnection();
            String sql = "Select password from tblUser where username=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
           
            rs=preStm.executeQuery();
            if (rs.next()) {
                password = rs.getString("password");
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return password;
    }
    public String checkName(String username, String password) throws ClassNotFoundException, SQLException{
        String fullname="";
        Connection conn = null ;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        
        try {
            conn = MyConnection.getConnection();
            String sql = "Select fullname from tblUser where username=? and password=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs=preStm.executeQuery();
            if (rs.next()) {
                fullname = rs.getString("fullname");
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return fullname;
    }
    public String checkPilotRank(String username) throws ClassNotFoundException, SQLException{
        String rank="unrank";
        Connection conn = null ;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        
        try {
            conn = MyConnection.getConnection();
            String sql = "Select rank from tblPilot where pilotCode=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            
            rs=preStm.executeQuery();
            if (rs.next()) {
                rank = rs.getString("rank");
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return rank;
    }
    
}
