package com.example.custom_threadsafe.config;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.example.custom_threadsafe.repo"},
        entityManagerFactoryRef ="mysqlEntityManagerFactory",
        transactionManagerRef = "mysqlTransactionManager")
public class MysqlDBConfig {
    private static final Logger logger = LoggerFactory.getLogger(MysqlDBConfig.class);
    private final MySqlProperties mySqlProperties;

    public MysqlDBConfig(MySqlProperties mySqlProperties) {
        this.mySqlProperties = mySqlProperties;
    }
    @Bean(name = "mysqlDataSource")
    public DataSource mysqlDataSource(){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setUsername(mySqlProperties.getUsername());
        hikariDataSource.setPassword(mySqlProperties.getPassword());
        hikariDataSource.setJdbcUrl(mySqlProperties.getUrl());
        hikariDataSource.setDriverClassName(mySqlProperties.getDriverClassName());

        hikariDataSource.setPoolName("mysql-connection-pool");
        hikariDataSource.setMaximumPoolSize(10);
        hikariDataSource.setMinimumIdle(5);
        hikariDataSource.setConnectionTimeout(20000);
        hikariDataSource.setIdleTimeout(300000);
        logger.info("setup of mysql datasource complete");
        return hikariDataSource;
    }
    @Primary
    @Bean(name = "mysqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mysqlContainerEntityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(mysqlDataSource());
        em.setPackagesToScan("com.example.custom_threadsafe.repo", "com.example.custom_threadsafe.models");
        em.setPersistenceUnitName("mysql-persistence-unit");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(hibernateProperties());
        return  em;
    }
    private Properties hibernateProperties(){
        Properties properties = new Properties();
        properties.put(org.hibernate.cfg.Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
        properties.put(org.hibernate.cfg.Environment.SHOW_SQL, true);
        properties.put(org.hibernate.cfg.Environment.FORMAT_SQL, true);
        properties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "none");
        return properties;
    }
    @Bean(name = "mysqlTransactionManager")
    public JpaTransactionManager masterTransactionManager(@Qualifier("mysqlEntityManagerFactory") EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
