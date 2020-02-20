package com.cn.employment;

import com.cn.employment.login.entity.Users;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmploymentApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void usersInsert() {
        Users users = new Users();
        users.setUsername("aaa");
        users.insert();
        System.err.println(users.getId());
    }

}
