package com.ald.news.utils.generator.mybatis;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xdj
 */
public class Create {
    public static void main(String[] args) {
        try {
            String configPath = ClassLoader.getSystemResource("generatorConfig.xml").getPath();

            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            File configFile = new File(configPath);
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (IOException | XMLParserException | SQLException | InvalidConfigurationException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
