package com.idc.homedoctor.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan(basePackages={"com.idc.homedoctor.respository","com.idc.homedoctor.service"})
@EnableJpaRepositories(("com.idc.homedoctor.respository"))
public class AppConfig 
{
	@Bean
	public DataSource dataSource(){
		/*
		EmbeddedDatabaseBuilder builder=new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2);
		builder.addScript("schema.sql");
		builder.addScript("data.sql");
		return builder.build();
		*/
		DriverManagerDataSource datasoursce=new DriverManagerDataSource();
		datasoursce.setDriverClassName("com.mysql.jdbc.Driver");
		datasoursce.setUrl("jdbc:mysql://localhost:3306/home");
		datasoursce.setUsername("root");
		datasoursce.setPassword("root");
		return datasoursce;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter bean = new HibernateJpaVendorAdapter();
		bean.setDatabase(org.springframework.orm.jpa.vendor.Database.MYSQL);
		bean.setGenerateDdl(true);
		return bean;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource);
		bean.setJpaVendorAdapter(jpaVendorAdapter);
		bean.setPackagesToScan("com.idc.homedoctor.model");
		return bean;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
	/*@Bean //implementation
	public PlatformTransactionManager transactionManager(){
		return new DataSourceTransactionManager(dataSource());
	}*/

}
