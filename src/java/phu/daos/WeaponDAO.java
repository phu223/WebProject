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
import phu.dtos.WeaponDTO;
import phu.utils.MyConnection;

/**
 *
 * @author Tachibana Kanade
 */
public class WeaponDAO implements Serializable {

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

    public List<WeaponDTO> searchByWeaponName(String weaponName) throws SQLException, NamingException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<WeaponDTO> listWeapon = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select weaponCode, weaponName, firePower, storeQuantity, useFor, weaponType from tblWeapon Where weaponName like ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, "%" + weaponName + "%");

            rs = preStm.executeQuery();
            while (rs.next()) {
                String weaponCode = rs.getString("weaponCode");
                weaponName = rs.getString("weaponName");
                float firePower = rs.getFloat("firePower");
                int storeQuantity = rs.getInt("storeQuantity");
                String useFor = rs.getString("useFor");
                String weaponType = rs.getString("weaponType");
                WeaponDTO dto = new WeaponDTO(weaponCode, weaponName, useFor, weaponType, firePower, storeQuantity);
                if (listWeapon == null) {
                    listWeapon = new ArrayList();
                }
                listWeapon.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listWeapon;
    }

    public List<WeaponDTO> searchByWeaponType(String weaponType) throws SQLException, NamingException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<WeaponDTO> listWeapon = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select weaponCode, weaponName, firePower, storeQuantity, useFor, weaponType from tblWeapon Where weaponType like ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, "%" + weaponType + "%");

            rs = preStm.executeQuery();
            while (rs.next()) {
                String weaponCode = rs.getString("weaponCode");
                String weaponName = rs.getString("weaponName");
                float firePower = rs.getFloat("firePower");
                int storeQuantity = rs.getInt("storeQuantity");
                String useFor = rs.getString("useFor");
                weaponType = rs.getString("weaponType");
                WeaponDTO dto = new WeaponDTO(weaponCode, weaponName, useFor, weaponType, firePower, storeQuantity);
                if (listWeapon == null) {
                    listWeapon = new ArrayList();
                }
                listWeapon.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listWeapon;
    }

    public List<WeaponDTO> searchByWeaponUse(String useFor) throws SQLException, NamingException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<WeaponDTO> listWeapon = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select weaponCode, weaponName, firePower, storeQuantity, useFor, weaponType from tblWeapon Where useFor like ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, "%" + useFor + "%");

            rs = preStm.executeQuery();
            while (rs.next()) {
                String weaponCode = rs.getString("weaponCode");
                String weaponName = rs.getString("weaponName");
                float firePower = rs.getFloat("firePower");
                int storeQuantity = rs.getInt("storeQuantity");
                useFor = rs.getString("useFor");
                String weaponType = rs.getString("weaponType");
                WeaponDTO dto = new WeaponDTO(weaponCode, weaponName, useFor, weaponType, firePower, storeQuantity);
                if (listWeapon == null) {
                    listWeapon = new ArrayList();
                }
                listWeapon.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listWeapon;
    }

    public List<WeaponDTO> searchByWeaponNameForPilot(String weaponName) throws SQLException, NamingException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<WeaponDTO> listWeapon = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select weaponCode, weaponName, firePower, useFor, weaponType from tblWeapon Where weaponName like ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, "%" + weaponName + "%");

            rs = preStm.executeQuery();
            while (rs.next()) {
                String weaponCode = rs.getString("weaponCode");
                weaponName = rs.getString("weaponName");
                float firePower = rs.getFloat("firePower");
                
                String useFor = rs.getString("useFor");
                String weaponType = rs.getString("weaponType");
                WeaponDTO dto = new WeaponDTO(weaponCode, weaponName, useFor, weaponType, firePower);
                if (listWeapon == null) {
                    listWeapon = new ArrayList();
                }
                listWeapon.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listWeapon;
    }

    public List<WeaponDTO> searchByWeaponTypeForPilot(String weaponType) throws SQLException, NamingException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<WeaponDTO> listWeapon = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select weaponCode, weaponName, firePower, useFor, weaponType from tblWeapon Where weaponType like ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, "%" + weaponType + "%");

            rs = preStm.executeQuery();
            while (rs.next()) {
                String weaponCode = rs.getString("weaponCode");
                String weaponName = rs.getString("weaponName");
                float firePower = rs.getFloat("firePower");
                String useFor = rs.getString("useFor");
                weaponType = rs.getString("weaponType");
                WeaponDTO dto = new WeaponDTO(weaponCode, weaponName, useFor, weaponType, firePower);
                if (listWeapon == null) {
                    listWeapon = new ArrayList();
                }
                listWeapon.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listWeapon;
    }

    public List<WeaponDTO> searchByWeaponUseForPilot(String useFor) throws SQLException, NamingException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<WeaponDTO> listWeapon = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select weaponCode, weaponName, firePower, useFor, weaponType from tblWeapon Where useFor like ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, "%" + useFor + "%");

            rs = preStm.executeQuery();
            while (rs.next()) {
                String weaponCode = rs.getString("weaponCode");
                String weaponName = rs.getString("weaponName");
                float firePower = rs.getFloat("firePower");
                useFor = rs.getString("useFor");
                String weaponType = rs.getString("weaponType");
                WeaponDTO dto = new WeaponDTO(weaponCode, weaponName, useFor, weaponType, firePower);
                if (listWeapon == null) {
                    listWeapon = new ArrayList();
                }
                listWeapon.add(dto);
            }

        } finally {
            closeConnection(conn, preStm, rs);
        }
        return listWeapon;
    }

    public boolean deleteWeapon(String weaponCode) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Delete from tblWeapon where weaponCode = ?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, weaponCode);
            int row = preStm.executeUpdate();
            if (row > 0) {
                check = true;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return check;
    }

    public boolean updateWeapon(String weaponCode, String weaponName, float firePower, int storeQuantity, String useFor, String weaponType) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Update tblWeapon set weaponName=?,firePower=?,storeQuantity=?,useFor=?,weaponType=? where weaponCode=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, weaponName);
            preStm.setFloat(2, firePower);
            preStm.setInt(3, storeQuantity);
            preStm.setString(4, useFor);
            preStm.setString(5, weaponType);
            preStm.setString(6, weaponCode);
            int row = preStm.executeUpdate();
            if (row > 0) {
                check = true;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return check;
    }

    public boolean addWeapon(String weaponCode, String weaponName, float firePower, int storeQuantity, String useFor, String weaponType) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Insert into tblWeapon(weaponCode,weaponName,firePower,storeQuantity,useFor, weaponType) values(?,?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, weaponCode);
            preStm.setString(2, weaponName);
            preStm.setFloat(3, firePower);
            preStm.setInt(4, storeQuantity);
            preStm.setString(5, useFor);
            preStm.setString(6, weaponType);

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
