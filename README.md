# library-man-spring

Library Man的后端Java Spring实现，与前端[LibraryManView](https://github.com/WeiYuanStudio/LibraryManView)配合使用

最简配置示范

```
spring.datasource.url=jdbc:mysql://<SQL_LOCATION>:3306/<DATABASE>
spring.datasource.username=<SQL_USERNAME>
spring.datasource.password=<SQL_PASSWORD>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.hbm2ddl.auto=create # JPA debug mode
server.port=5000 # API port
spring.redis.host=<REDIS_LOCATION>
```
