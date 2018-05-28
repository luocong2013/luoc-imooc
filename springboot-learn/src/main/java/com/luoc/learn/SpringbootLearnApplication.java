package com.luoc.learn;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication
//@PropertySources({@PropertySource("classpath:config/web.properties")})//自定义配置文件（这里也可以这样定义，也可以在如MyWebProperties中那样定义）
public class SpringbootLearnApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringbootLearnApplication.class, args);
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println("dataSource is: " + dataSource);
        //检查数据库是否是hikar数据库连接池
        if (!(dataSource instanceof HikariDataSource)) {
            System.err.println("Wrong dataSource type: " + dataSource.getClass().getCanonicalName());
            System.exit(-1);
        }
    }
}
