# dawnwar-Client
dawnwar by zebei
注册服务 各类基础服务
spring-cloud client service

5-23

rabbitmq  在pom中使用的为spring-boot-starter-amqp 不是bus中的amqp 否则会导致启动失败未注册bindService

@FeignClient是调用其他服务 如果指定为自己本服务 当第一次启动时会失败

5-15-1 

eventbus add example.

5-11-2

通过“POST”请求发送到http://localhost:7002/refresh 刷新配置文件

5-11-1

config必须配置在bootstrap.properties中，内容才能被正确加载。因为config的相关配置会先于application.properties，而bootstrap.properties的加载也是先于application.properties。
