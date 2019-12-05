package me.cxz.samples;

import me.cxz.samples.dao.UserMapper;
import me.cxz.samples.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SamplesApplicationTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void select() {

        List<User> userList = userMapper.selectList(null);

        userList.forEach(System.out::println);
    }

}
