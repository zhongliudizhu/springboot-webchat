package com.coolchatting.springbootwebchat.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Value("${datasource1.username}")
    private String userName;
    @Value("${datasource1.jdbcUrl}")
    private String jdbcUrl;
    @Value("${datasource1.driverClass}")
    private  String driverClass;
    @Value("${datasource1.password}")
    private String  password;
    @Value("${datasource1.maxPoolSize}")
    private  String maxActive;
    @Value("${datasource1.maxWait}")
    private  String maxWait;
    @Value("${datasource1.initPoolSize}")
    private String initPoolSize;

    @Bean(name = "druidDataSource")
    public DruidDataSource getMqDataSource(){
        DruidDataSource druidDataSource=new DruidDataSource();
        druidDataSource.setMaxActive(Integer.parseInt(maxActive));
        druidDataSource.setInitialSize(Integer.parseInt(initPoolSize));
        druidDataSource.setUsername(userName);
        druidDataSource.setDriverClassName(driverClass);
        druidDataSource.setUrl(jdbcUrl);
        druidDataSource.setPassword(password);
        druidDataSource.setMaxWait(Long.parseLong(maxWait));
        return  druidDataSource;
    }
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier(value = "druidDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().
                getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }
    @Bean
    public PlatformTransactionManager getTran(@Qualifier(value = "druidDataSource") DataSource dataSource){
        return  new DataSourceTransactionManager(dataSource);
    }


}
