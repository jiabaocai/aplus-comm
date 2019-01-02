package com.ald.news.utils.generator;

import com.ald.news.utils.app.FreeMarkers;
import com.ald.news.utils.app.GenerateUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.DefaultResourceLoader;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * mybatis映射代码生成器
 *
 * @author Administrator
 */
@Deprecated
public class MybatisGenerate {

    /**
     * @param db
     * @param url
     * @param MysqlUser
     * @param mysqlPassword
     * @param database
     * @param table
     * @param packageName
     * @param batisName
     * @param moduleName
     * @param classAuthor
     * @param functionName
     * @Description: 生成代码方法
     */
    public static void generateCode(String db, String url, String MysqlUser, String mysqlPassword, String database,
                                    String table, String commonName, String packageName, String batisName, String moduleName, String classAuthor,
                                    String functionName, String classNamePrefix) throws Exception {

        Boolean needsDomain = true; // 是否生成实体类
        Boolean needsDao = false; // 是否生成Dao
        Boolean needsService = true; // 是否生成Service和ServiceImpl
        Boolean needsAction = false; // 是否生成Action
        Boolean needsMapper = true; //是否生成Mapper配置文件
        String table_name = "";

        String dbClass = "com.mysql.jdbc.Driver";
        String showTables = "SHOW TABLES";
        String getTable = "Tables_in_" + database;
        String executeSql = "SELECT COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT FROM INFORMATION_SCHEMA.`COLUMNS` WHERE table_name = '"
                + table + "'  AND table_schema = '" + database + "'";


        Connection connection = GenerateUtils.getDblink(dbClass, url, MysqlUser, mysqlPassword);
        Statement stateMent_table = (Statement) connection.createStatement();
        // 查询该数据库所有的表名
        ResultSet tables = stateMent_table.executeQuery(showTables);
        while (tables.next()) {
            table_name = tables.getString(getTable);
            // 判断执行那个表的,生成代码操作
            if (table_name.indexOf(table) == -1) {
                continue;
            }
//				String cn = StringUtil.lowerCase(table_name); // 全部转换为小写

//				String className = GenerateUtils.toUpper(cn.substring(0));
            String className = firstCharUpperCase(classNamePrefix);

            String separator = File.separator;

            // 获取工程路径
            File projectPath = new DefaultResourceLoader().getResource("").getFile();
            while (!new File(projectPath.getPath() + separator + "src").exists()) {
                projectPath = projectPath.getParentFile();
            }
            String realProjectPath = projectPath.getPath().substring(0, projectPath.getPath().lastIndexOf(File.separator));
            // 模板文件路径
            String tplPath = StringUtils.replace(realProjectPath + "/news-system/template", "/", separator);

            // Java文件路径,使用
//				String javaPath = StringUtils.replaceEach(
//						projectPath + "/src/main/java/" + StringUtils.lowerCase(packageName), new String[] { "/", "." },
//						new String[] { separator, separator });
            String dalPath = StringUtils.replaceEach(realProjectPath + "/news-domain" + "/src/main/java/" + StringUtils.lowerCase(packageName) + "/domain/system", new String[]{"/", "."}, new String[]{separator, separator});
            String bizPath = "";
            String webPath = "";

            // mybatis文件生成地址

            String batisPath = "";

            // 代码模板配置
            Configuration cfg = new Configuration();
            cfg.setDirectoryForTemplateLoading(new File(tplPath));

            // 定义模板变量
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("commonName", StringUtils.lowerCase(commonName));
            model.put("packageName", StringUtils.lowerCase(packageName));
            model.put("moduleName", StringUtils.lowerCase(moduleName));
            model.put("className", StringUtils.uncapitalize(className));
            model.put("ClassName", className);
            model.put("classAuthor", classAuthor);
            model.put("classDate", GenerateUtils.getDate());
            model.put("functionName", functionName);
            model.put("tableName", StringUtils.lowerCase(table_name));
            model.put("urlPrefix", model.get("moduleName") + " /" + model.get("className"));
            model.put("permissionPrefix", model.get("moduleName") + " :" + model.get("className"));
            model.put("list", GenerateUtils.getList(dbClass, table_name, url, MysqlUser, mysqlPassword, database,
                    executeSql));
            model.put("listSize", GenerateUtils
                    .getList(dbClass, table_name, url, MysqlUser, mysqlPassword, database, executeSql).size());
            // mybatis {替代单词
            model.put("leftBraces", "{");
            // mybatis }替代单词
            model.put("rightBraces", "}");
            // mybatis $替代单词
            model.put("dollarSign", "$");


            /**
             * 生成 ibatis文件
             */
            if (needsMapper) {
                Template ibatisTemplate = cfg.getTemplate("dbmapper.ftl");
                // 渲染生成模板
                String ibatisContent = FreeMarkers.renderTemplate(ibatisTemplate, model);
                // 生成的文件地址
                String batisSql = dalPath + separator + model.get("ClassName") + ".xml";
//					System.out.println("batisSql=" + batisSql);
                // 将内容写入文件
                GenerateUtils.writeFile(ibatisContent, batisSql);
            }
            /**
             * 生成实体类
             */
            if (needsDomain) {
                // FreeMarkers模板地址
                Template beanTemplate = cfg.getTemplate("domain.ftl");
                // 渲染生成模板
                String beanContent = FreeMarkers.renderTemplate(beanTemplate, model);
                // 生成的文件地址
                String beanFile = dalPath + separator
                        + model.get("ClassName") + ".java";
//					System.out.println("beanFile=" + beanFile);
                // 将内容写入文件
                GenerateUtils.writeFile(beanContent, beanFile);
            }
            /**
             * 生成 Dao
             */
            if (needsDao) {
                // FreeMarkers模板地址
                Template daoTemplate = cfg.getTemplate("dao.ftl");
                // 渲染生成模板
                String daoContent = FreeMarkers.renderTemplate(daoTemplate, model);
                // 生成的文件名称
                String daoFile = dalPath + separator + "dao" + separator
                        + model.get("ClassName") + "Dao.java";
//					System.out.println("daoFile=" + daoFile);
                // 将内容写入文件
                GenerateUtils.writeFile(daoContent, daoFile);
            }
            /**
             * 生成 Service
             */
            if (needsService) {
                // FreeMarkers模板地址
                Template serviceTemplate = cfg.getTemplate("service.ftl");
                // 渲染生成模板
                String serviceContent = FreeMarkers.renderTemplate(serviceTemplate, model);
                // 生成的文件名称
                String serviceFile = dalPath + separator + "service"
                        + separator + model.get("ClassName") + "Service.java";
//					System.out.println("serviceFile=" + serviceFile);
                // 将内容写入文件
                GenerateUtils.writeFile(serviceContent, serviceFile);

                /**
                 * 生成 ServiceImpl 代码
                 */
                // FreeMarkers模板地址
                Template serviceI_Template = cfg.getTemplate("serviceImpl.ftl");
                // 渲染生成模板
                String serviceI_Content = FreeMarkers.renderTemplate(serviceI_Template, model);
                // 生成的文件名称
                String serviceI_File = dalPath + separator + "service"
                        + separator + "impl" + separator + model.get("ClassName") + "ServiceImpl.java";
//					System.out.println("serviceI_File=" + serviceI_File);
                // 将内容写入文件
                GenerateUtils.writeFile(serviceI_Content, serviceI_File);
            }

            /**
             * 生成 Action代码
             */
            if (needsAction) {
                // FreeMarkers模板地址
                Template actionTemplate = cfg.getTemplate("controller.ftl");
                // 渲染生成模板
                String actionContent = FreeMarkers.renderTemplate(actionTemplate, model);
                // 生成的文件名称
                String actionFile = dalPath + separator + "sys" + separator + "controller"
                        + separator + model.get("ClassName") + "Controller.java";
//					System.out.println("actionFile=" + actionFile);
                // 将内容写入文件
                GenerateUtils.writeFile(actionContent, actionFile);
            }
            /**
             * 提示信息
             */
            System.out.println("代码生成成功");
        }
        tables.close();
        stateMent_table.close();
        connection.close();


    }

    private static String firstCharUpperCase(String s) {
        StringBuffer sb = new StringBuffer(s.substring(0, 1).toUpperCase());
        sb.append(s.substring(1, s.length()));
        return sb.toString();
    }
}
