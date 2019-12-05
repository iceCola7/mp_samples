package me.cxz.samples.high;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import me.cxz.samples.dao.UserMapper;
import me.cxz.samples.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OptTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void updateById() {
        int version = 1;
        User user = new User();
        user.setId(1202064968363057153L);
        user.setEmail("lmc2@baomidou.com");
        user.setVersion(version);
        int rows = userMapper.updateById(user);
        System.out.println("影响行数：" + rows);
    }

    @Test
    public void update() {
        int version = 2;

        User user = new User();
        user.setEmail("lmc3@baomidou.com");
        user.setVersion(version);

        QueryWrapper<User> query = Wrappers.<User>query();
        query.eq("name", "刘明超");

        int rows = userMapper.update(user, query);
        System.out.println("影响行数：" + rows);

        int version2 = 3;
        User user2 = new User();
        user2.setEmail("lmc3@baomidou.com");
        user2.setVersion(version2);

        // QueryWrapper 不能复用
        query.eq("age", 31);

        int rows2 = userMapper.update(user2, query);
        System.out.println("影响行数：" + rows2);
    }
}
