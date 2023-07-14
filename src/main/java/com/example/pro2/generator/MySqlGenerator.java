package com.example.pro2.generator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.example.pro2.entity.BaseEntity;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.MyBatisSystemException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MySqlGenerator {
    public static final String DATABASES_URL = "jdbc:mysql://127.0.0.1:3306/springboot?characterEncoding=utf8&useSSl=false&serverTimezone=Asia/Shanghai";
    public static final String DATABASE_DRIVE = "com.mysql.cj.jdbc.Driver";
    public static final String DATABASE_USERNAME = "root";
    public static final String DATABASE_PASSWORD = "123456";
    public static final String OUT_PUT_PATH = "Pro2/src/main/java";
    public static final String TEMPLATES_MAPPER_XML_PATH = "templates.mapper.xml.ftl";
    public static final String XML_PATH = "Pro2/src/main/resources/mapper";
    public static final String XML_POSTFIX = "Mapper";
    public static final String AUTHOR = "无言";
    public static final String PARENT_PACKAGE = "com.wuyan";
    public static final String[] SUPER_ENTITY_COLUMNS = {"id", "create_time", "update_time", "creator", "modifier"};

    /**
     * 读取控制台内容
     *
     * @param tip
     * @return
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + ":");
        if (scanner.hasNext()) {
            String next = scanner.next();
            if (StringUtils.isNotBlank(next)) {
                return next;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip);
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(AUTHOR);
        gc.setOpen(false);
        gc.setServiceName("%sService");
        gc.setBaseResultMap(true);
        gc.setActiveRecord(true);
        gc.setBaseColumnList(true);
        gc.setSwagger2(true);
        gc.setFileOverride(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(DATABASES_URL);
        dataSourceConfig.setDriverName(DATABASE_DRIVE);
        dataSourceConfig.setUsername(DATABASE_USERNAME);
        dataSourceConfig.setPassword(DATABASE_PASSWORD);
        mpg.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName(null);
        packageConfig.setParent(PARENT_PACKAGE);
        mpg.setPackageInfo(packageConfig);

        // 自定义配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                HashMap<String, Object> map = new HashMap<>();
                map.put("parent", PARENT_PACKAGE);
                setMap(map);
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig(TEMPLATES_MAPPER_XML_PATH) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + XML_PATH + tableInfo.getEntityName() + XML_POSTFIX + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(focList);
        mpg.setCfg(injectionConfig);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setSuperEntityClass(BaseEntity.class);
        strategyConfig.setSuperEntityColumns(SUPER_ENTITY_COLUMNS);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setChainModel(true);
        strategyConfig.setInclude(scanner("表名，多个英文盗号分割").split(","));
        strategyConfig.setControllerMappingHyphenStyle(true);
        strategyConfig.setRestControllerStyle(true);
        mpg.setStrategy(strategyConfig);

        // 选择FreeMarker引擎
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
