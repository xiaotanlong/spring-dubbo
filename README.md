# dubbo 框架demo

api-业务模块接口

consume-只暴露接口 http//127.0.0.1/url

provide-底层服务提供者  dobbu rpc服务

web-暴露接口或者展示html页面

common-all  所有模块都会用的公共组件

common-service 公共的service

common-web   web层  和接口服务  使用的拦截机制

common-util    工具包


# mybatis 开头是 mybatis 相关

mybatis-generator-module  ---mybatis-generator  生成mybatis相关文件命令模式，可以不依赖项目

mybatis-quick-start  --- mybatis  原始加载  

    mybatis 配置文件 读取数据库
    
    通过main方法生成mybatis开发文件
    
    通过maven plugin 方法生成mybatis开发文件