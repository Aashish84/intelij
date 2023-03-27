package com.example.eventhandlerfromscratch.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariCPDataSource {
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;
    static{
        config.setJdbcUrl("jdbc:mysql://localhost:3306/EventHandlerFromScratch?createDatabaseIfNotExist=true");
        config.setUsername("root");
        config.setPassword("123root!@#");
        config.addDataSourceProperty("cachePrepStmts" , "true");
        config.addDataSourceProperty("prepStmtCacheSize" , "2");
        config.addDataSourceProperty("prepStmtCacheSqlLimit" , "100");
        config.setMaximumPoolSize(1);
        config.setConnectionTimeout(30000);
        config.setIdleTimeout(600000);
        config.setMaxLifetime(1800000);
        config.setLeakDetectionThreshold(10000);
        ds = new HikariDataSource(config);
    }
    private HikariCPDataSource(){}
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
