package com.webservice.config;

import java.util.Properties;

import javax.sql.DataSource;

import com.webservice.app.model.bean.Customer;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * Configuration Java Class... Loads Session Factory and set Spring Component scan packages
 */
@Configuration
@Import({HibernateConfig.class, WebConfig.class})
@EnableTransactionManagement
@ComponentScan("com.webservice.app")
@EnableWebMvc
public class AppConfig
{

    @Bean
    public ViewResolver createInternalResourceViewResolver() {
        UrlBasedViewResolver viewResolver= new UrlBasedViewResolver();
        viewResolver.setViewClass(JstlView.class);
       // viewResolver.setContentType("text/html");
        viewResolver.setPrefix("/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}