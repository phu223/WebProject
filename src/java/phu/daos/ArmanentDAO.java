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
import phu.dtos.ArmanentDTO;
import phu.utils.MyConnection;

/**
 *
 * @author Tachibana Kanade
 */
public class ArmanentDAO implements Serializable {

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

    public List<ArmanentDTO> searchPilotGearWeapon(String gearCode) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        List<ArmanentDTO> listPilotOfThisGear = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select  weaponCode, quantity from tblArmanent where gearCode=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, gearCode);
            rs = preStm.executeQuery();
            while (rs.next()) {

                String weaponCode = rs.getString("weaponCode");
                int quantity = rs.getInt("quantity");
                ArmanentDTO dto = new ArmanentDTO(gearCode, weaponCode, quantity);
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

    public int checkQuantity(String gearCode, String weaponCode) throws SQLException, ClassNotFoundException {
        int quantity = 0;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select quantity from tblArmanent where gearCode=? and weaponCode=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, gearCode);
            preStm.setString(2, weaponCode);
            rs = preStm.executeQuery();
            if (rs.next()) {
                quantity = rs.getInt("quantity");
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return quantity;
    }
    public boolean checkArma(String gearCode, String weaponCode) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select quantity from tblArmanent where gearCode=? and weaponCode=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, gearCode);
            preStm.setString(2, weaponCode);
            rs = preStm.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return check;
    }
    public int checkLimitation(String gearCode) throws SQLException, ClassNotFoundException {
        int quantity = 0;
        int total = 0;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Select quantity from tblArmanent where gearCode=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, gearCode);

            rs = preStm.executeQuery();
            while (rs.next()) {
                quantity = rs.getInt("quantity");
                total = total + quantity;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return total;
    }

    public boolean addWeaponToGundam(String gearCode, String weaponCode) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Insert into tblArmanent(gearCode, weaponCode, quantity) values(?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, gearCode);
            preStm.setString(2, weaponCode);
            preStm.setInt(3, 1);

            int row = preStm.executeUpdate();
            if (row > 0) {
                check = true;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return check;
    }

    public boolean deleteWeaponFromGundam(String gearCode, String weaponCode) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Delete from tblArmanent where gearCode = ? and weaponCode=?";
            preStm = conn.prepareStatement(sql);

            preStm.setString(1, gearCode);
            preStm.setString(2, weaponCode);
            int row = preStm.executeUpdate();
            if (row > 0) {
                check = true;
            }
        } finally {
            closeConnection(conn, preStm, rs);
        }
        return check;
    }

    public boolean deleteWeaponFromGundam(String gearCode) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Delete from tblArmanent where gearCode = ? ";
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
    public boolean deleteWeapon(String weaponCode) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Delete from tblArmanent where weaponCode = ? ";
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
    public boolean updateWeaponFromGundam(String gearCode, String weaponCode, int quantity) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "Update tblArmanent set quantity=? where gearCode = ? and weaponCode=?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, quantity);
            preStm.setString(2, gearCode);
            preStm.setString(3, weaponCode);
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
