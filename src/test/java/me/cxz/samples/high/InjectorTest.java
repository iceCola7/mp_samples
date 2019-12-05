package me.cxz.samples.high;

import me.cxz.samples.dao.UserMapper;
import me.cxz.samples.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class InjectorTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void deleteAll() {
        int rows = userMapper.deleteAll();
        System.out.println("影响行数：" + rows);
    }

    @Test
    public void insertBatch() {
        User user1 = new User();
        user1.setName("张三");
        user1.setAge(25);
        user1.setManagerId(1088248166370832385L);

        User user2 = new User();
        user2.setName("李四");
        user2.setAge(28);
        user2.setManagerId(1088248166370832385L);

        List<User> userList = Arrays.asList(user1, user2);
        int rows = userMapper.insertBatchSomeColumn(userList);
        System.out.println("影响行数：" + rows);

    }

    @Test
    public void deleteByIdWithFill() {
        User user = new User();
        user.setId(1202121820937416706L);
        user.setAge(35);
        int rows = userMapper.deleteByIdWithFill(user);
        System.out.println("影响行数：" + rows);
    }

    @Test
    public void alwaysUpdateSomeColumnById() {
        User user = new User();
        user.setId(1088248166370832385L);
        user.setAge(26);
        user.setName("王风");
        int rows = userMapper.alwaysUpdateSomeColumnById(user);
        System.out.println("影响行数：" + rows);
    }

}
