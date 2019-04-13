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
import phu.dtos.GearDTO;
import phu.utils.MyConnection;

/**
 *
 * @author Tachibana Kanade
 */
public class GearDAO implements Serializable {

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

    public GearDAO() {
    }

    public List<GearDTO> searchGearName(String gearName) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<GearDTO> listGear = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select gearCode, gearName, type, status, slotAvailable, weaponSlot from tblGear where gearName like ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + gearName + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                String gearCode = rs.getString("gearCode");
                gearName = rs.getString("gearName");
                String type = rs.getString("type");
                String status = rs.getString("status");
                int slotAvailable = rs.getInt("slotAvailable");
                int weaponSlot = rs.getInt("weaponSlot");
                GearDTO dto = new GearDTO(gearCode, gearName, type, status, slotAvailable, weaponSlot);
                if (listGear == null) {
                    listGear = new ArrayList();
                }
                listGear.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listGear;
    }

    public List<GearDTO> searchGearNameByCode(String gearCode) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<GearDTO> listGear = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select gearCode, gearName from tblGear where gearCode=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, gearCode);
            rs = preStm.executeQuery();
            while (rs.next()) {
                gearCode = rs.getString("gearCode");
                String gearName = rs.getString("gearName");

                GearDTO dto = new GearDTO(gearCode, gearName);
                if (listGear == null) {
                    listGear = new ArrayList();
                }
                listGear.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listGear;
    }
    public int checkGearLimit(String gearCode) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        int weaponSlot = 0;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select weaponSlot from tblGear where gearCode=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, gearCode);
            rs = preStm.executeQuery();
            while (rs.next()) {
                weaponSlot = rs.getInt("weaponSlot");
                
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return weaponSlot;
    }
    public List<GearDTO> searchGearByCode(String gearCode) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<GearDTO> listGear = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select gearCode, gearName, type, status, slotAvailable, weaponSlot from tblGear where gearCode=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, gearCode);
            rs = preStm.executeQuery();
            while (rs.next()) {
                gearCode = rs.getString("gearCode");
                String gearName = rs.getString("gearName");
                String type = rs.getString("type");
                String status = rs.getString("status");
                int slotAvailable = rs.getInt("slotAvailable");
                int weaponSlot = rs.getInt("weaponSlot");
                GearDTO dto = new GearDTO(gearCode, gearName, type, status, slotAvailable, weaponSlot);
                if (listGear == null) {
                    listGear = new ArrayList();
                }
                listGear.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listGear;
    }

    public List<GearDTO> searchGearNameForPilot(String gearName) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<GearDTO> listGear = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select gearCode, gearName, slotAvailable, weaponSlot from tblGear where gearName like ? and  status='Available'";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + gearName + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                String gearCode = rs.getString("gearCode");
                gearName = rs.getString("gearName");
                int slotAvailable = rs.getInt("slotAvailable");
                int weaponSlot = rs.getInt("weaponSlot");
                GearDTO dto = new GearDTO(gearCode, gearName, slotAvailable, weaponSlot);
                if (listGear == null) {
                    listGear = new ArrayList();
                }
                listGear.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listGear;
    }

    public List<GearDTO> searchGearType(String type) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<GearDTO> listGear = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select gearCode, gearName, type, status, slotAvailable, weaponSlot from tblGear where type like ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + type + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                String gearCode = rs.getString("gearCode");
                String gearName = rs.getString("gearName");
                type = rs.getString("type");
                String status = rs.getString("status");
                int slotAvailable = rs.getInt("slotAvailable");
                int weaponSlot = rs.getInt("weaponSlot");
                GearDTO dto = new GearDTO(gearCode, gearName, type, status, slotAvailable, weaponSlot);
                if (listGear == null) {
                    listGear = new ArrayList();
                }
                listGear.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listGear;
    }

    public List<GearDTO> searchGearStatus(String status) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<GearDTO> listGear = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select gearCode, gearName, type, status, slotAvailable, weaponSlot from tblGear where status like ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + status + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                String gearCode = rs.getString("gearCode");
                String gearName = rs.getString("gearName");
                String type = rs.getString("type");
                status = rs.getString("status");
                int slotAvailable = rs.getInt("slotAvailable");
                int weaponSlot = rs.getInt("weaponSlot");
                GearDTO dto = new GearDTO(gearCode, gearName, type, status, slotAvailable, weaponSlot);
                if (listGear == null) {
                    listGear = new ArrayList();
                }
                listGear.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listGear;
    }

    public List<GearDTO> searchGearWeaponSlot(int weaponSlot) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<GearDTO> listGear = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select gearCode, gearName, type, status, slotAvailable, weaponSlot from tblGear where weaponSlot=? ";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + weaponSlot + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                String gearCode = rs.getString("gearCode");
                String gearName = rs.getString("gearName");
                String type = rs.getString("type");
                String status = rs.getString("status");
                int slotAvailable = rs.getInt("slotAvailable");
                weaponSlot = rs.getInt("weaponSlot");
                GearDTO dto = new GearDTO(gearCode, gearName, type, status, slotAvailable, weaponSlot);
                if (listGear == null) {
                    listGear = new ArrayList();
                }
                listGear.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listGear;
    }

    public List<GearDTO> searchGearWeaponSlotForPilot(int weaponSlot) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<GearDTO> listGear = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select gearCode, gearName, type, status, slotAvailable, weaponSlot from tblGear where weaponSlot like ? and status='Available'";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + weaponSlot + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                String gearCode = rs.getString("gearCode");
                String gearName = rs.getString("gearName");
                int slotAvailable = rs.getInt("slotAvailable");
                weaponSlot = rs.getInt("weaponSlot");
                GearDTO dto = new GearDTO(gearCode, gearName, slotAvailable, weaponSlot);
                if (listGear == null) {
                    listGear = new ArrayList();
                }
                listGear.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listGear;
    }

    public List<GearDTO> searchGearWeaponSlotForCrewman(int weaponSlot) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<GearDTO> listGear = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select gearCode, gearName, type, status, slotAvailable, weaponSlot from tblGear where weaponSlot like ? and type='MA' or type='MS' and status='Available'";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + weaponSlot + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                String gearCode = rs.getString("gearCode");
                String gearName = rs.getString("gearName");
                String type = rs.getString("type");
                String status = rs.getString("status");
                int slotAvailable = rs.getInt("slotAvailable");
                weaponSlot = rs.getInt("weaponSlot");
                GearDTO dto = new GearDTO(gearCode, gearName, type, status, slotAvailable, weaponSlot);
                if (listGear == null) {
                    listGear = new ArrayList();
                }
                listGear.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listGear;
    }

    public boolean deleteGear(String gearCode) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Delete from tblGear where gearCode = ?";
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

    public boolean updateGear(String gearCode, String gearName, String type, String status, int slotAvailable, int weaponSlot) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Update tblGear set gearName=?, type=?, status=?, slotAvailable=?, weaponSlot=? where gearCode=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, gearName);
            preStm.setString(2, type);
            preStm.setString(3, status);
            preStm.setInt(4, slotAvailable);
            preStm.setInt(5, weaponSlot);
            preStm.setString(6, gearCode);
            int row = preStm.executeUpdate();
            if (row > 0) {
                check = true;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return check;
    }

    public boolean updateGearStatus(String gearCode) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Update tblGear set status=? where gearCode=?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, "in use");

            preStm.setString(2, gearCode);
            int row = preStm.executeUpdate();
            if (row > 0) {
                check = true;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return check;
    }

    public boolean updateGearStatusToAvailable(String gearCode) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Update tblGear set status=? where gearCode=?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, "Available");

            preStm.setString(2, gearCode);
            int row = preStm.executeUpdate();
            if (row > 0) {
                check = true;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return check;
    }

    public boolean addGear(String gearCode, String gearName, String type, String status, int slotAvailable, int weaponSlot) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Insert into tblGear(gearCode, gearName, type, status, slotAvailable, weaponSlot) values(?,?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(2, gearName);
            preStm.setString(3, type);
            preStm.setString(4, status);
            preStm.setInt(5, slotAvailable);
            preStm.setInt(6, weaponSlot);
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
}
