package com.ald.aplus.thirdparty;

import com.didispace.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @program: aplus
 * @Version 1.0.0
 * @description: 第三方接口启动入口
 * @author: Mr.cai
 * @create: 2019-01-03 11:40
 * @CopyRight 本内容仅限于北境内部传阅，禁止外泄以及用于其他的商业目的
 **/
@EnableSwagger2Doc
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class ThirdpartyApplication{
    public static void main(String[] args) {
        //初始器和监听器在这一步添加完毕
        SpringApplication application = new SpringApplication(ThirdpartyApplication.class);
        //应用启动
        application.run(args);
    }
}


 
