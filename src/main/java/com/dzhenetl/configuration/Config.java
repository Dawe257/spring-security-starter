package com.dzhenetl.configuration;

import com.dzhenetl.util.PropertiesUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan(basePackages = "com.dzhenetl")
@EnableWebMvc
public class Config {

    private static final String JDBC_DRIVER_KEY = "db.driver";
    private static final String DB_URL_KEY = "db.url";
    private static final String DB_USERNAME_KEY = "db.username";
    private static final String DB_PASSWORD_KEY = "db.password";

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(PropertiesUtil.get(JDBC_DRIVER_KEY));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        dataSource.setJdbcUrl(PropertiesUtil.get(DB_URL_KEY));
        dataSource.setUser(PropertiesUtil.get(DB_USERNAME_KEY));
        dataSource.setPassword(PropertiesUtil.get(DB_PASSWORD_KEY));

        return dataSource;
    }

    @Bean
    public ViewResolver viewResolver() {
        return new InternalResourceViewResolver("/WEB-INF/view/", ".jsp");
    }

}
