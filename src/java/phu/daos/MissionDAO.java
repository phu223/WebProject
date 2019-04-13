/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phu.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import phu.dtos.MissionDTO;
import phu.dtos.MissionDetailDTO;
import phu.utils.MyConnection;

/**
 *
 * @author Tachibana Kanade
 */
public class MissionDAO implements Serializable {

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

    public List<MissionDTO> searchByMissionName(String missionName) throws SQLException, NamingException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<MissionDTO> listMission = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select missionCode, missionName, startDate ,status, type from tblMission Where missionName like ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, "%" + missionName + "%");

            rs = preStm.executeQuery();
            while (rs.next()) {
                String missionCode = rs.getString("missionCode");
                missionName = rs.getString("missionName");
                Date startDate = rs.getDate("startDate");
                String status = rs.getString("status");
                String type = rs.getString("type");
                MissionDTO dto = new MissionDTO(missionCode, missionName, status, type, startDate);
                if (listMission == null) {
                    listMission = new ArrayList();
                }
                listMission.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listMission;
    }

    public List<MissionDTO> searchByMissionStatus(String status) throws SQLException, NamingException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<MissionDTO> listMission = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select missionCode, missionName, startDate ,status, type from tblMission Where missionName like ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, "%" + status + "%");

            rs = preStm.executeQuery();
            while (rs.next()) {
                String missionCode = rs.getString("missionCode");
                String missionName = rs.getString("missionName");
                Date startDate = rs.getDate("startDate");
                status = rs.getString("status");
                String type = rs.getString("type");
                MissionDTO dto = new MissionDTO(missionCode, missionName, status, type, startDate);
                if (listMission == null) {
                    listMission = new ArrayList();
                }
                listMission.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listMission;
    }

    public boolean deleteMission(String missionCode) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Delete from tblMission where missionCode = ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, missionCode);
            int row = preStm.executeUpdate();
            if (row > 0) {
                check = true;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return check;
    }

    public boolean deleteMissionDetail(String missionCode) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Delete from tblMissionDetail where missionCode = ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, missionCode);
            int row = preStm.executeUpdate();
            if (row > 0) {
                check = true;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return check;
    }

    public boolean searchMissionDetail(String missionCode, String pilotCode) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select missionCode, pilotCode from tblMissionDetail where missionCode =? and pilotCode = ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, missionCode);
            preStm.setString(2, pilotCode);
            rs = preStm.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return check;
    }

    public boolean updateMission(String missionCode, String missionName, String status) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Update tblMission set missionName=?, status=? where missionCode=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, missionName);
            preStm.setString(2, status);
            preStm.setString(3, missionCode);
            int row = preStm.executeUpdate();
            if (row > 0) {
                check = true;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return check;
    }

    public boolean addMission(String missionCode, String missionName, Date date, String status, String type) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Insert into tblMission(missionCode,missionName,startDate,status,type) values(?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, missionCode);
            preStm.setString(2, missionName);
            preStm.setDate(3, date);
            preStm.setString(4, status);
            preStm.setString(5, type);
            int row = preStm.executeUpdate();
            if (row > 0) {
                check = true;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return check;
    }

    public boolean deletePilotFromMission(String missionCode, String pilotCode) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Delete from tblMissionDetail where missionCode = ? and pilotCode=?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, missionCode);
            preStm.setString(2, pilotCode);
            int row = preStm.executeUpdate();
            if (row > 0) {
                check = true;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return check;
    }

    public boolean addPilotForMission(String missionCode, String pilotCode) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Insert into tblMissionDetail(missionCode,pilotCode) values(?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, missionCode);
            preStm.setString(2, pilotCode);

            int row = preStm.executeUpdate();
            if (row > 0) {
                check = true;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return check;
    }

    public List<MissionDetailDTO> searchByMissionDetailCode(String missionCode) throws SQLException, NamingException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<MissionDetailDTO> listMission = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select missionCode, pilotCode from tblMissionDetail Where missionCode = ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, missionCode);

            rs = preStm.executeQuery();
            while (rs.next()) {
                missionCode = rs.getString("missionCode");
                String pilotCode = rs.getString("pilotCode");
                MissionDetailDTO dto = new MissionDetailDTO(missionCode, pilotCode);
                if (listMission == null) {
                    listMission = new ArrayList();
                }
                listMission.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listMission;
    }

    public List<MissionDetailDTO> searchByMissionDetailByPilotCode(String pilotCode) throws SQLException, NamingException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<MissionDetailDTO> listMission = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select missionCode, pilotCode from tblMissionDetail Where pilotCode = ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, pilotCode);

            rs = preStm.executeQuery();
            while (rs.next()) {
                String missionCode = rs.getString("missionCode");
                pilotCode = rs.getString("pilotCode");
                MissionDetailDTO dto = new MissionDetailDTO(missionCode, pilotCode);
                if (listMission == null) {
                    listMission = new ArrayList();
                }
                listMission.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listMission;
    }

    public List<MissionDTO> searchByMissionCode(String missionCode) throws SQLException, NamingException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<MissionDTO> listMission = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select missionCode from tblMission Where missionCode = ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, missionCode);

            rs = preStm.executeQuery();
            while (rs.next()) {
                missionCode = rs.getString("missionCode");

                MissionDTO dto = new MissionDTO(missionCode);
                if (listMission == null) {
                    listMission = new ArrayList();
                }
                listMission.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listMission;
    }

    public String searchMissionCode(String pilotCode) throws SQLException, NamingException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        String missionCode = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select missionCode from tblMissionDetail Where pilotCode = ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, pilotCode);

            rs = preStm.executeQuery();
            while (rs.next()) {
                missionCode = rs.getString("missionCode");

            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return missionCode;
    }

    public List<MissionDTO> searchFullByMissionCode(String missionCode) throws SQLException, NamingException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<MissionDTO> listMission = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select missionCode, missionName, startDate, status, type from tblMission Where missionCode = ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, missionCode);

            rs = preStm.executeQuery();
            while (rs.next()) {
                missionCode = rs.getString("missionCode");
                String missionName = rs.getString("missionName");
                Date startDate = rs.getDate("startDate");
                String status = rs.getString("status");
                String type = rs.getString("type");
                MissionDTO dto = new MissionDTO(missionCode, missionName, status, type, startDate);
                if (listMission == null) {
                    listMission = new ArrayList();
                }
                listMission.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listMission;
    }
}
