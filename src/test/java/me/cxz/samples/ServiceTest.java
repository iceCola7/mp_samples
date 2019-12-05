package me.cxz.samples;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import me.cxz.samples.entity.User;
import me.cxz.samples.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class ServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getOne() {
        User user = userService.getOne(Wrappers.<User>lambdaQuery().gt(User::getAge, 25), false);
        System.out.println(user);
    }

    @Test
    public void batch() {
        User user1 = new User();
        user1.setName("李四");
        user1.setAge(26);

        User user2 = new User();
        user2.setName("李四2");
        user2.setAge(27);

        List<User> userList = Arrays.asList(user1, user2);
        boolean saveBatch = userService.saveBatch(userList);
        System.out.println(saveBatch);

    }

    @Test
    public void chain() {
        List<User> userList = userService.lambdaQuery().gt(User::getAge, 25).like(User::getName, "雨").list();
        userList.forEach(System.out::println);
    }

    @Test
    public void chain2(){
        boolean update = userService.lambdaUpdate().eq(User::getAge, 25).set(User::getAge, 26).update();
        System.out.println(update);
    }

    @Test
    public void chain3(){
        boolean remove = userService.lambdaUpdate().eq(User::getAge, 24).remove();
        System.out.println(remove);
    }

}
