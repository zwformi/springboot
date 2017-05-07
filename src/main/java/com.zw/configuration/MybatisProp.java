package com.zw.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * mapper 基本配置
 * @author like
 *
 */
@Component
@ConfigurationProperties(prefix="mybatis.prop")
public class MybatisProp {

    private String mapperLocations;//mapper存放路径
    private String typeAliasesPackage; //别名包

    public String getMapperLocations() {
        return mapperLocations;
    }
    public void setMapperLocations(String mapperLocations) {
        this.mapperLocations = mapperLocations;
    }
    public String getTypeAliasesPackage() {
        return typeAliasesPackage;
    }
    public void setTypeAliasesPackage(String typeAliasesPackage) {
        this.typeAliasesPackage = typeAliasesPackage;
    }
}
