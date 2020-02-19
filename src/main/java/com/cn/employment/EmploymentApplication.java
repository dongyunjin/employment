package com.cn.employment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages= {"com.cn.**.dao"})
public class EmploymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmploymentApplication.class, args);
    }

}
