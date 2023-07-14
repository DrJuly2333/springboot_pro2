package com.example.pro2.generator;

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
     * @param tip
     * @return
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + ":");
        if (scanner.hasNext()) {
            String next = scanner.next();
            if (StringU)
        }
    }
}
