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
import phu.dtos.CrewDTO;
import phu.utils.MyConnection;

/**
 *
 * @author Tachibana Kanade
 */
public class CrewDAO implements Serializable {

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

    public List<CrewDTO> searchGearPilots(String gearCode) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<CrewDTO> listPilotOfThisGear = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select pilotCode from tblCrew where gearCode=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, gearCode);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String pilotCode = rs.getString("pilotCode");
                CrewDTO dto = new CrewDTO(gearCode, pilotCode);
                if (listPilotOfThisGear == null) {
                    listPilotOfThisGear = new ArrayList();
                }
                listPilotOfThisGear.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listPilotOfThisGear;
    }
    public List<CrewDTO> searchGearByPilotCode(String pilotCode) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<CrewDTO> listPilotOfThisGear = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select gearCode from tblCrew where pilotCode=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, pilotCode);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String gearCode= rs.getString("gearCode");
                CrewDTO dto = new CrewDTO(gearCode, pilotCode);
                if (listPilotOfThisGear == null) {
                    listPilotOfThisGear = new ArrayList();
                }
                listPilotOfThisGear.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listPilotOfThisGear;
    }
    public String searchPilotGear(String pilotCode) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        String gearCode = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select gearCode from tblCrew where pilotCode=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, pilotCode);
            rs = preStm.executeQuery();
            while (rs.next()) {
                gearCode = rs.getString("gearCode");

            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return gearCode;
    }

    public String searchPilotGears(String gearCode) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        String pilotCode = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select pilotCode from tblCrew where gearCode=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, gearCode);
            rs = preStm.executeQuery();
            while (rs.next()) {
                pilotCode = rs.getString("pilotCode");

            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return pilotCode;
    }

    public boolean deleteCrew(String gearCode) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Delete from tblCrew where gearCode = ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, gearCode);
            int row = preStm.executeUpdate();
            if (row > 0) {
                check = true;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return check;
    }

    public boolean deleteCrewman(String pilotCode) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Delete from tblCrew where pilotCode = ?";
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

    public boolean pilotChooseGear(String gearCode, String pilotCode) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Insert into tblCrew(gearCode, pilotCode, status) values(?,?,?)";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, gearCode);
            preStm.setString(2, pilotCode);
            preStm.setString(3, "Available");
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
