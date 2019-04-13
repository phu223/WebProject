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
import phu.dtos.PilotDTO;
import phu.utils.MyConnection;

/**
 *
 * @author Tachibana Kanade
 */
public class PilotDAO implements Serializable {

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

    public String checkPilot(String pilotCode) throws SQLException, NamingException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        String username = "not found";
        try {
            conn = MyConnection.getConnection();
            String sql = "select pilotName from tblPilot where pilotCode=?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, pilotCode);

            rs = preStm.executeQuery();
            if (rs.next()) {
                username = rs.getString("pilotName");
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return username;
    }

    public String checkPilotName(String pilotCode) throws SQLException, NamingException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        String username = "not found";
        try {
            conn = MyConnection.getConnection();
            String sql = "select pilotName from tblPilot where pilotCode=?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, pilotCode);

            rs = preStm.executeQuery();
            if (rs.next()) {
                username = rs.getString("pilotName");
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return username;
    }

    public List<PilotDTO> searchByPilotName(String pilotName) throws SQLException, NamingException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<PilotDTO> listPilot = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select pilotCode,pilotName,rank,status from tblPilot Where pilotName like ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, "%" + pilotName + "%");

            rs = preStm.executeQuery();
            while (rs.next()) {
                String pilotCode = rs.getString("pilotCode");
                pilotName = rs.getString("pilotName");
                String rank = rs.getString("rank");
                String status = rs.getString("status");
                PilotDTO dto = new PilotDTO(pilotCode, pilotName, rank, status);
                if (listPilot == null) {
                    listPilot = new ArrayList();
                }
                listPilot.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listPilot;
    }

    public List<PilotDTO> getPilotName(String pilotCode) throws SQLException, NamingException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<PilotDTO> listPilot = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select pilotName from tblPilot Where pilotCode = ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, pilotCode);

            rs = preStm.executeQuery();
            if (rs.next()) {

                String pilotName = rs.getString("pilotName");

                PilotDTO dto = new PilotDTO(pilotCode, pilotName);
                if (listPilot == null) {
                    listPilot = new ArrayList();
                }
                listPilot.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listPilot;
    }

    public List<PilotDTO> searchByPilotCode(String pilotCode, String rank) throws SQLException, NamingException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<PilotDTO> listPilot = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select pilotCode,pilotName,rank,status from tblPilot Where pilotCode = ? and rank =?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, pilotCode);
            preStm.setString(2, rank);
            rs = preStm.executeQuery();
            if (rs.next()) {
                pilotCode = rs.getString("pilotCode");
                String pilotName = rs.getString("pilotName");
                rank = rs.getString("rank");
                String status = rs.getString("status");
                PilotDTO dto = new PilotDTO(pilotCode, pilotName, rank, status);
                if (listPilot == null) {
                    listPilot = new ArrayList();
                }
                listPilot.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listPilot;
    }

    public List<PilotDTO> searchByPilotRank(String rank) throws SQLException, NamingException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<PilotDTO> listPilot = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select pilotCode,pilotName,rank,status from tblPilot Where rank like ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, "%" + rank + "%");

            rs = preStm.executeQuery();
            while (rs.next()) {
                String pilotCode = rs.getString("pilotCode");
                String pilotName = rs.getString("pilotName");
                rank = rs.getString("rank");
                String status = rs.getString("status");
                PilotDTO dto = new PilotDTO(pilotCode, pilotName, rank, status);
                if (listPilot == null) {
                    listPilot = new ArrayList();
                }
                listPilot.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listPilot;
    }

    public List<PilotDTO> searchByPilotStatus( String status) throws SQLException, NamingException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<PilotDTO> listPilot = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select pilotCode,pilotName,rank,status from tblPilot Where status like ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, "%" + status + "%");

            rs = preStm.executeQuery();
            while (rs.next()) {
                String pilotCode = rs.getString("pilotCode");
                String pilotName = rs.getString("pilotName");
                String rank = rs.getString("rank");
                status = rs.getString("status");
                PilotDTO dto = new PilotDTO(pilotCode, pilotName, rank, status);
                if (listPilot == null) {
                    listPilot = new ArrayList();
                }
                listPilot.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listPilot;
    }
    public List<PilotDTO> searchByPilotNameStatus(String pilotName) throws SQLException, NamingException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<PilotDTO> listPilot = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select pilotCode,pilotName,rank,status from tblPilot Where pilotName like ? and status ='Available'";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, "%" + pilotName + "%");

            rs = preStm.executeQuery();
            while (rs.next()) {
                String pilotCode = rs.getString("pilotCode");
                pilotName = rs.getString("pilotName");
                String rank = rs.getString("rank");
                String status = rs.getString("status");
                PilotDTO dto = new PilotDTO(pilotCode, pilotName, rank, status);
                if (listPilot == null) {
                    listPilot = new ArrayList();
                }
                listPilot.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listPilot;
    }

    public boolean deletePilot(String pilotCode) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Delete from tblPilot where pilotCode = ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, pilotCode);
            int row = preStm.executeUpdate();
            if (row > 0) {
                check = true;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return check;
    }

    public boolean updatePilot(String pilotCode, String pilotName, String rank, String status) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Update tblPilot set pilotName=?,rank=?,status=? where pilotCode=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, pilotName);

            preStm.setString(2, rank);
            preStm.setString(3, status);
            preStm.setString(4, pilotCode);
            int row = preStm.executeUpdate();
            if (row > 0) {
                check = true;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return check;
    }

    public boolean updatePilot(String pilotCode, String status) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Update tblPilot set status=? where pilotCode=?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(3, status);
            preStm.setString(4, pilotCode);
            int row = preStm.executeUpdate();
            if (row > 0) {
                check = true;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return check;
    }

    public boolean addPilot(String pilotCode, String pilotName, String rank, String status) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Insert into tblPilot(pilotCode,pilotName,rank,status) values(?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, pilotCode);
            preStm.setString(2, pilotName);

            preStm.setString(3, rank);
            preStm.setString(4, status);

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
