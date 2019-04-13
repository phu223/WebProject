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
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import phu.dtos.SoidlerDTO;
import phu.utils.MyConnection;

/**
 *
 * @author Tachibana Kanade
 */
public class SoidlerDAO implements Serializable {

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

    public List<SoidlerDTO> searchBySoidlerName(String fullname) throws SQLException, NamingException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<SoidlerDTO> listSoidler = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select username, fullname, rank from tblUser Where fullname like ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, "%" + fullname + "%");

            rs = preStm.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                fullname = rs.getString("fullname");
                String rank = rs.getString("rank");
                SoidlerDTO dto = new SoidlerDTO(username, fullname, rank);
                if (listSoidler == null) {
                    listSoidler = new ArrayList();
                }
                listSoidler.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listSoidler;
    }

    public List<SoidlerDTO> searchBySoidlerInfo(String username, String fullname, String rank) throws SQLException, NamingException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<SoidlerDTO> listSoidler = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select username, password, fullname, rank from tblUser Where username like ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, username);

            rs = preStm.executeQuery();
            while (rs.next()) {
                username = rs.getString("username");
                String password = rs.getString("password");
                fullname = rs.getString("fullname");
                rank = rs.getString("rank");
                SoidlerDTO dto = new SoidlerDTO(username, password, fullname, rank);
                if (listSoidler == null) {
                    listSoidler = new ArrayList();
                }
                listSoidler.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listSoidler;
    }

    public List<SoidlerDTO> searchBySoidlerRank(String rank) throws SQLException, NamingException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<SoidlerDTO> listSoidler = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select username, fullname, rank from tblUser Where rank like ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, "%" + rank + "%");

            rs = preStm.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String fullname = rs.getString("fullname");
                rank = rs.getString("rank");
                SoidlerDTO dto = new SoidlerDTO(username, fullname, rank);
                if (listSoidler == null) {
                    listSoidler = new ArrayList();
                }
                listSoidler.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listSoidler;
    }

    public boolean deleteSoidler(String username) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Delete from tblUser where username = ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, username);
            int row = preStm.executeUpdate();
            if (row > 0) {
                check = true;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return check;
    }

    public boolean updateSoidler(String username, String password, String fullname, String rank) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Update tblUser set password=?,fullname=?,rank=? where username=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, password);
            preStm.setString(2, fullname);
            preStm.setString(3, rank);

            preStm.setString(4, username);
            int row = preStm.executeUpdate();
            if (row > 0) {
                check = true;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return check;
    }

    public boolean updateSoidlerPilot(String username, String fullname) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Update tblUser set fullname=? where username=?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, fullname);
            preStm.setString(2, username);
            int row = preStm.executeUpdate();
            if (row > 0) {
                check = true;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return check;
    }

    public boolean sendSoidlerToReserve(String username, String rank) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Update tblUser set rank=? where username=?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, rank);

            preStm.setString(2, username);
            int row = preStm.executeUpdate();
            if (row > 0) {
                check = true;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return check;
    }

    public boolean addSoidler(String username, String password, String fullname, String rank) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Insert into tblUser(username,password,fullname,rank) values(?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);

            preStm.setString(3, fullname);
            preStm.setString(4, rank);

            int row = preStm.executeUpdate();
            if (row > 0) {
                check = true;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return check;
    }
}
