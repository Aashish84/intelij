package com.example.multipledb.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "primaryEntityManagerFactory",
        transactionManagerRef = "primaryTransactionManager",
        basePackages = {"com.example.multipledb.repository.primary"})
public class PrimaryDBConfig {
    @Primary
    @Bean(name = "primaryProps")
    @ConfigurationProperties("spring.datasource")
//    @ConfigurationProperties
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "datasource")
    @ConfigurationProperties(prefix = "spring.datasource")
//    @ConfigurationProperties
    public DataSource datasource(@Qualifier("primaryProps") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
//        return DataSourceBuilder.create()
//                .driverClassName("com.mysql.cj.jdbc.Driver")
//                .url("jdbc:mysql://localhost:3306/multipledbPrimary?createDatabaseIfNotExists=true")
//                .username("root")
//                .password("123root!@#")
//                .build();
    }

    @Primary
    @Bean(name = "primaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder, @Qualifier("datasource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.multipledb.entity.primary")
//                .persistenceUnit("Admin")
                .build();
    }

    @Primary
    @Bean(name = "primaryTransactionManager")
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager transactionManager(final @Qualifier("primaryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
