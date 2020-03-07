package com.cn.employment;

import com.cn.employment.login.entity.Login;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmploymentApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void usersInsert() {
        Login users = new Login();
        users.setUsername("aaa");
        users.insert();
        System.err.println(users.getId());
    }

}
