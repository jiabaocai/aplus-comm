package com.ald.news.user;

import com.didispace.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationListener;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Set;

@EnableSwagger2Doc
@SpringBootApplication
@EnableEurekaClient
public class UserApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {

        //初始器和监听器在这一步添加完毕
        SpringApplication application = new SpringApplication(UserApplication.class);
        Set<ApplicationListener<?>> listeners = application.getListeners();

//        //设置寻址文件名, 支持外部配置文件和任意位置配置(覆盖默认配置), 但是还没吃透, 实验失败
//        Iterator<ApplicationListener<?>> iterator = listeners.iterator();
//        while(iterator.hasNext()){
//            ApplicationListener<?> next = iterator.next();
//            if( next instanceof ConfigFileApplicationListener){
//                ConfigFileApplicationListener target = (ConfigFileApplicationListener)next;
//                target.setSearchNames("news");
//                break;
//            }
//        }
        //应用启动
        application.run(args);
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);

    }
}
