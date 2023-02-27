package com.example.eventhandlerfromscratch.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ServerDatabaseOperation {
    private Connection getMainConnection() {
        try {
            return HikariCPDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String executeQeuryString(String query) {
        String resultString = null;
        Connection con = getMainConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                resultString = rs.getString(1);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultString;
    }

    public ResultSet executeQuery(String query) {
        Connection con = getMainConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            return pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

//      close connection
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int executeUpdateQuery(String query, Map<Integer, Object> params) {
        int affectedRow = 0;
        Connection con = getMainConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            if (params != null) {
                for (Map.Entry<Integer, Object> entry : params.entrySet()) {
                    pstmt.setObject(entry.getKey(), entry.getValue());
                }
            }
            affectedRow = pstmt.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRow;
    }
}
