package com.ald.news.utils.generator;

/**
 * 新框架不需要生成所有的mapper文件和mapper接口
 * 只需要实体对象, 所以修改生成模版和代码, 只会生成实体类
 */
@Deprecated
public class Create {
    public static void main(String[] args) {
        Create ot = new Create();
        ot.test();
    }

    public void test() {

        // 数据库连接信息
//		String url = "jdbc:mysql://115.236.44.234:3306/arc_collection_test?useUnicode=true&characterEncoding=utf8";
        String url = "jdbc:mysql://192.168.106.76:3306/arc_t?useUnicode=true&characterEncoding=utf8";
        String MysqlUser = "eCityArcTest";
        String mysqlPassword = "rickControl@test";

        // 数据库及数据表名称
        String database = "arc_t";
        String table = "arc_sys_role_menu";


        // 配置作者及Domain说明
        String classAuthor = "baojun";
        String functionName = "系统用户";

        // 公共包路径 (例如 BaseDao、 BaseService、 BaseServiceImpl)
        String commonName = "com.ald.news.core.config.base";

        String packageName = "com.ald.news";
        String moduleName = "system";

        //Mapper文件存储地址  默认在resources中
        String batisName = "config/mapping";
        String db = "mysql";

        try {
            String classNamePrefix = "SysRoleMenu";
            MybatisGenerate.generateCode(db, url, MysqlUser, mysqlPassword, database, table, commonName, packageName, batisName, moduleName, classAuthor, functionName, classNamePrefix);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getClassName(String tableName) {
        String beanName = tableName.substring(0, 1).toUpperCase() + tableName.substring(1);
        while (beanName.indexOf("_") >= 0) {
            int firstSpe = beanName.indexOf("_");
            beanName = beanName.substring(0, firstSpe) + beanName.substring(firstSpe + 1, firstSpe + 2).toUpperCase() + beanName.substring(firstSpe + 2);
        }
        return beanName;
    }


}
