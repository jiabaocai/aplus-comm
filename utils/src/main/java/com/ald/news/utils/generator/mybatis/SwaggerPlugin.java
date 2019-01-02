package com.ald.news.utils.generator.mybatis;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

/**
 * @author xdj
 */
public class SwaggerPlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> warnings) {
        System.out.println(warnings);
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        //引入JPA注解
        topLevelClass.addImportedType("io.swagger.annotations.ApiModelProperty");
        return true;
    }

    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        field.addAnnotation("@ApiModelProperty(\"" + introspectedColumn.getRemarks() + "\")");
        return true;
    }

}
