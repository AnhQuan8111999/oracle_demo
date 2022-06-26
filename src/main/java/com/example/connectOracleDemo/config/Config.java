package com.example.connectOracleDemo.config;


import oracle.jdbc.pool.OracleDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class Config {

    @Bean
    public DataSource oracledataSource() throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser("camid");
        dataSource.setPassword("jones1234");
        dataSource.setURL("jdbc:oracle:thin:@123.31.38.148:1521:xe");
        dataSource.setFastConnectionFailoverEnabled(true);
        dataSource.setImplicitCachingEnabled(true);
        dataSource.setConnectionCachingEnabled(true);
        return dataSource;
    }

    @Bean(name="CamIdOracleJdbcTempalte")
    public NamedParameterJdbcTemplate jdbcTemplate() {
        try {
            return new NamedParameterJdbcTemplate(oracledataSource());
        } catch (SQLException e) {
            System.out.println("Connect|false : "+ e.getMessage());
        }
        return null;
    }
}
