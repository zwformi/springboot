package com.zw.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class MybatisConfig implements TransactionManagementConfigurer {
    @Autowired
    private JdbcConfig jdbcConfig;
    @Autowired
    private MybatisProp prop;


    /**
     * 配置 dataSource
     相当于 xml
     <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
     <property name="driverClass" value="${driverClass}"/>
     <property name="jdbcUrl" value="${jdbcUrl}"></property>
     <property name="user" value="${user}" />
     <property name="password" value="${password}"/>
     </bean>


     * @return
     */
    @Bean(name="dataSource")
    public DruidDataSource createDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(jdbcConfig.getUrl());
        druidDataSource.setDriverClassName(jdbcConfig.getDriverClassName());
        druidDataSource.setUsername(jdbcConfig.getUsername());
        druidDataSource.setPassword(jdbcConfig.getPassword());
        return druidDataSource;
    }

    /**
     * xml配置
     <bean  class="org.mybatis.spring.SqlSessionFactoryBean">
     <property name="dataSource" ref="dataSource" />
     <property name="typeAliasesPackage" value="com.study.bean"/>
     </bean>
     * @return
     */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(){
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(createDataSource());
        //别名包
        bean.setTypeAliasesPackage(prop.getTypeAliasesPackage());
        //分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);

        //添加插件
        bean.setPlugins(new Interceptor[]{pageHelper});
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            //设置mapper 目录，这些都可以配置到配置文件中，直接注入进来接可以了
            bean.setMapperLocations(resolver.getResources(prop.getMapperLocations()));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    };

    /**
     * 整合 spring +mybaits
     * @param sqlSessionFactory
     * @return
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


    /*
     * 配置注解事物
     * 相当于xml
     <!-- spring 事务 -->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>
    <!-- 开启注解事务-->
    <tx:annotation-driven transaction-manager="transactionManager"/>
     */
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(createDataSource());
    }
}
