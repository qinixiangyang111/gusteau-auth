package net.xinhuamm.auth;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @program: gusteau-auth
 * @description: 启动类
 * @author: qinxiangyang
 * @create: 2020-06-08 17:04
 **/

@SpringBootApplication
@ComponentScan(basePackages = "net.xinhuamm")
@EnableMethodCache(basePackages = "net.xinhuamm.auth")
@MapperScan(value = "net.xinhuamm.auth.mapper")
@EnableCreateCacheAnnotation
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "net.xinhuamm")
@ServletComponentScan
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

}