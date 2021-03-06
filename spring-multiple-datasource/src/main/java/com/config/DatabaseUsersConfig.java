package com.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate; 
 
/**
 * Configures Users Datasource, with prefix spring.ds_users in application.properties.
 * 
 * @author s.tsourdos
 */
@Configuration 
public class DatabaseUsersConfig
{ 
    @Bean(name = "dsUsers") 
    @ConfigurationProperties(prefix="spring.ds_users")
    @Primary
    public DataSource dataSource() { 
        return DataSourceBuilder.create().build(); 
    } 
 
    @Bean(name = "jdbcUsers")
    @Autowired
    public JdbcTemplate jdbcTemplate(@Qualifier("dsUsers") DataSource dsUsers) { 
        return new JdbcTemplate(dsUsers); 
    } 
} 