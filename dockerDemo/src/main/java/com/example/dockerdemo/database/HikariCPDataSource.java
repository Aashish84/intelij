package com.example.dockerdemo.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariCPDataSource {
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds ;
    static{
        config.setJdbcUrl("jdbc:mysql://mysql_db:3306/myDatabase_asis");
        config.setUsername("root");
        config.setPassword("12345");
        config.addDataSourceProperty("cachePrepStmts" , "true");
        config.addDataSourceProperty("prepStmtCacheSize" , "2");
        config.addDataSourceProperty("prepStmtCacheSqlLimit" , "100");
        ds = new HikariDataSource(config);
    }
    private HikariCPDataSource(){}
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
