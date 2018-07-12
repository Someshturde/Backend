package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.niit.model.Post;
import com.niit.model.User;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.niit")
@EnableWebMvc
public class DBConfig 
{
	public DBConfig()
	{
		System.out.println("DBConfig Started");
	}
	
	@Bean
	public SessionFactory sessionFactory()
	{
		LocalSessionFactoryBuilder lsfb= new LocalSessionFactoryBuilder(dataSource());
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		lsfb.addProperties(properties);
		Class class1[] = new Class[] {User.class,Post.class};
		return lsfb.addAnnotatedClasses(class1).buildSessionFactory();
		
	}
	
	@Bean
	public DataSource dataSource()
	{
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	    dataSource.setUsername("ProjectNew");
	    dataSource.setPassword("som");
	    return dataSource;
		
	}
	@Bean
	public HibernateTransactionManager hibTransManagement()
	{
		return new HibernateTransactionManager(sessionFactory());
	}
}
