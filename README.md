# dawnwar-Client
spring-cloud client service


5-11
config必须配置在bootstrap.properties中，内容才能被正确加载。因为config的相关配置会先于application.properties，而bootstrap.properties的加载也是先于application.properties。
