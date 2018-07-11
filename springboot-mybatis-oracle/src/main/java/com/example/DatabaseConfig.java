package com.example;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * Created by onnuricis on 2016. 12. 30..
 */

@Configuration
@MapperScan("com.example.mapper")
public class DatabaseConfig {

  @Bean
  public DataSource getDataSouce() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:test");
    dataSource.setUsername("test");
    dataSource.setPassword("test");

    return dataSource;
  }

  @Bean
  public DataSourceTransactionManager transactionManager() {
    return new DataSourceTransactionManager(getDataSouce());
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
    sessionFactoryBean.setDataSource(getDataSouce());
    return sessionFactoryBean.getObject();
  }
}
