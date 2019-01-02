package com.ald.news.core.config.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by luohao on 2017/8/25.
 * 仿照风控的做法, 启动系统时对constant赋值
 * <p>
 * 将配置文件替换为数据库配置
 * 必须配置正确, 否则启动会失败
 */
@Component
public class ConfigSystemBeforeApplicationStartedInitializer implements CommandLineRunner {


    @Transactional
    public void run(String... strings) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据<<<<<<<<<<<<<");

        //从数据库读取配置, 如果常量库中没有定义, 无视.

        //启动一个线程池, 读取热部署常量数据.

        //对于不需要热部署的变量一次性读取

    }
}
