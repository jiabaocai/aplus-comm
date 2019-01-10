# aplus

## 启动命令 

```bash
# 默认为开发环境
$ java -jar xxxxx.jar
# 开发环境启动
$ java -jar xxxxx.jar --spring.profiles.active=dev
# 预发环境启动
$ java -jar xxxxx.jar --spring.profiles.active=pre
# 生产环境启动方式
$ java -jar xxxxx.jar --spring.profiles.active=prod
```

## 接口文档-Swagger2
[spring-boot-starter-swagger 1.2.0.RELEASE：新增分组配置功能](http://blog.didispace.com/spring-boot-starter-swagger-1.2.0/)<br>
[Swagger 常用注解](https://www.cnblogs.com/java-zhao/p/5348113.html)

## 实体类生成器
Create
debt-web/src/main/resources/generatorConfig.xml

## 项目结构
![img](/img/项目依赖.jpg)

## 工具
- 分页插件 
  [分页插件](https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/en/HowToUse.md)
  
  ```
  PageHelper.startPage(1, 10);
  // 查询函数
  ```
  
- Mapper
  [Mapper插件](https://github.com/abel533/Mapper)
  
- SFTP的连接工具
[SFTP的连接工具](https://filezilla-project.org/)

## 相关地址
```
