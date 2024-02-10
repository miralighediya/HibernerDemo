package com.hibernet.hiberner.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
	@ComponentScan(basePackages = "com.hibernet")
	//@PropertySource("classpath:application.properties")
	@EnableTransactionManagement
	public class AppConfig {
	 
		@Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/account");
	        dataSource.setUsername("root");
	        dataSource.setPassword("root");
	        Properties properties = new Properties();
	        properties.setProperty("hibernate.current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");
	        properties.setProperty("dialect", "org.hibernate.dialect.MySQL5Dialect");
	        properties.setProperty("hbm2ddl.auto", "update");
	        dataSource.setConnectionProperties(properties);
	        return dataSource;
	    }
		
		 @Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource((javax.sql.DataSource) dataSource());
	        sessionFactory.setPackagesToScan("com.hibernet");
	        //sessionFactory.setHibernateProperties(hibernateProperties());
	        return sessionFactory;
	    }
		
		 @Bean
	    public HibernateTransactionManager transactionManager(LocalSessionFactoryBean sessionFactory) {
	        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	        transactionManager.setSessionFactory(sessionFactory.getObject());
	        return transactionManager;
	    }
		
	}
