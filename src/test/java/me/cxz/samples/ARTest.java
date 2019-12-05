package me.cxz.samples;

import me.cxz.samples.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class ARTest {

    /**
     * User 实体类需要继承 Model<User>
     */

    @Test
    public void insert() {
        User user = new User();
        user.setName("张三");
        user.setAge(31);
        user.setEmail("zs@baomidou.com");
        user.setManagerId(1088248166370832385L);
        user.setCreateTime(LocalDateTime.now());

        boolean insert = user.insert();
        System.out.println(insert);
    }

    @Test
    public void selectById() {
        User user = new User();
        User selectUser = user.selectById(1201795228222656513L);
        System.out.println(user == selectUser);
        System.out.println(selectUser);
    }

    @Test
    public void selectById2() {
        User user = new User();
        user.setId(1201795228222656513L);
        User selectUser = user.selectById();
        System.out.println(user == selectUser);
        System.out.println(selectUser);
    }

    @Test
    public void updateById() {
        User user = new User();
        user.setId(1201795228222656513L);
        user.setName("李四");
        user.setEmail("ls@baomidou.com");
        boolean update = user.updateById();
        System.out.println(update);
    }

    @Test
    public void deleteById() {
        User user = new User();
        user.setId(1201795228222656513L);
        boolean delete = user.deleteById();
        System.out.println(delete);
    }

    @Test
    public void insertOrUpdate() {
        User user = new User();
        user.setId(1201797764283482114L);
        user.setName("张三");
        user.setAge(31);
        user.setEmail("zs@baomidou.com");
        user.setManagerId(1088248166370832385L);
        user.setCreateTime(LocalDateTime.now());

        boolean insert = user.insertOrUpdate();
        System.out.println(insert);
    }
}
