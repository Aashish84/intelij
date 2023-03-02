package com.example.dockerdemo.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServerDatabaseOperation {
    private Connection getMainConnection(){
        try {
            return HikariCPDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet executeQuery(String query){
        Connection con = getMainConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            return pstmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
