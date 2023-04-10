package com.dfrb.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author dfrb@ne
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.dfrb.spring")
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Autowired
    private Environment env;
    
    private final Logger logger = Logger.getLogger(getClass().getName());
    
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    
    @Bean
    public DataSource securityDataSource() {
        // Crear el Pool de Conexiones
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        
        // Establecer el Driver JDBC
        try {
            dataSource.setDriverClass(env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        
        // Hacer Logs de las propiedades de la Conexion
        logger.log(Level.INFO, "URL de la BBDD: {0}", env.getProperty("jdbc.url"));
        logger.log(Level.INFO, "Usuario conectado a la BBDD: {0}", env.getProperty("jdbc.user"));
        
        // Establecer las Propiedades de Conexion con la BBDD
        dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        dataSource.setUser(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        
        // Establecer las Popiedades del Pool de Conexiones
        dataSource.setInitialPoolSize(getPropPool("connection.pool.initialPoolSize"));
        dataSource.setMinPoolSize(getPropPool("connection.pool.minPoolSize"));
        dataSource.setMaxPoolSize(getPropPool("connection.pool.maxPoolSize"));
        dataSource.setMaxIdleTime(getPropPool("connection.pool.maxIdleTime"));
        
        return dataSource;
    }
    
    private int getPropPool(String propName) {
        return Integer.parseInt(env.getProperty(propName));
    }
}
