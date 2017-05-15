# dawnwar-Client
dawnwar by zebei
注册服务 各类基础服务
spring-cloud client service

5-15-1 
eventbus add example

5-11-2
通过“POST”请求发送到http://localhost:7002/refresh 刷新配置文件

5-11-1
config必须配置在bootstrap.properties中，内容才能被正确加载。因为config的相关配置会先于application.properties，而bootstrap.properties的加载也是先于application.properties。
