package com.controller;

import java.util.List;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.config.DataSourceConfig;
@SpringBootApplication
@EnableConfigurationProperties(value={DataSourceConfig.class})
@MapperScan("com.dao")
@ComponentScan(value={"com.service.impl","com.controller"})
public class Application {

	private static Logger logger=LoggerFactory.getLogger(Application.class);
	@Autowired
	private DataSourceConfig dataSourceConfig;
	
	@Bean
	public DataSource dataSource(){
		DataSource dataSource=new DataSource();
		dataSource.setDriverClassName(dataSourceConfig.getDriver());
		dataSource.setUrl(dataSourceConfig.getUrl());
		dataSource.setUsername(dataSourceConfig.getUsername());
		dataSource.setPassword(dataSourceConfig.getPassword());
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		PathMatchingResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:com/dao/TeacherMapper.xml"));
		SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBean.getObject();
		return sqlSessionFactory;
		
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(){
		return new DataSourceTransactionManager(dataSource());
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		logger.info("Spring 开始启动");
	}
	
	
}