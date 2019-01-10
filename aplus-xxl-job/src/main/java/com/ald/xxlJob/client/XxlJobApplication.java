package com.ald.xxlJob.client;

import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: aplus
 * @Version 1.0.0
 * @description:
 * @author: Mr.cai
 * @create: 2019-01-10 11:33
 * @CopyRight 本内容仅限于北境内部传阅，禁止外泄以及用于其他的商业目的
 **/
@SpringBootApplication
@EnableEurekaClient
public class XxlJobApplication {
    public static void main(String[] args) {
        XxlJobLogger.log("xxl-job-client running.........");
        //初始器和监听器在这一步添加完毕
        SpringApplication application = new SpringApplication(XxlJobApplication.class);
        //应用启动
        application.run(args);
    }
}


 
