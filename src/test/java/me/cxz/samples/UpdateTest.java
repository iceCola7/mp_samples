package me.cxz.samples;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.LambdaUpdateChainWrapper;
import me.cxz.samples.dao.UserMapper;
import me.cxz.samples.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UpdateTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void updateById() {
        User user = new User();
        user.setId(1088248166370832385L);
        user.setAge(26);
        user.setEmail("wtf2@baomidou.com");
        int rows = userMapper.updateById(user);
        System.out.println("影响记录数：" + rows);
    }

    @Test
    public void updateByWrapper() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", "李艺伟").eq("age", 28);
        User user = new User();
        user.setEmail("lyw2019@baomidou.com");
        user.setAge(29);
        int rows = userMapper.update(user, updateWrapper);
        System.out.println("影响记录数：" + rows);
    }

    @Test
    public void updateByWrapper2() {
        User whereUser = new User();
        whereUser.setName("李艺伟");
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>(whereUser);
        // updateWrapper.eq("name","李艺伟").eq("age",28);
        User user = new User();
        user.setEmail("lyw2019@baomidou.com");
        user.setAge(29);
        int rows = userMapper.update(user, updateWrapper);
        System.out.println("影响记录数：" + rows);
    }

    @Test
    public void updateByWrapper3() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", "李艺伟").eq("age", 29)
                .set("age", 30);
        int rows = userMapper.update(null, updateWrapper);
        System.out.println("影响记录数：" + rows);
    }

    @Test
    public void updateByWrapperLambda() {
        LambdaUpdateWrapper<User> lambdaWrapper = Wrappers.<User>lambdaUpdate();
        lambdaWrapper.eq(User::getName, "李艺伟").eq(User::getAge, 30).set(User::getAge, 31);
        int rows = userMapper.update(null, lambdaWrapper);
        System.out.println("影响记录数：" + rows);
    }

    @Test
    public void updateByWrapperLambdaChain() {
        boolean result = new LambdaUpdateChainWrapper<User>(userMapper)
                .eq(User::getName, "李艺伟")
                .eq(User::getAge, 31)
                .set(User::getAge, 32)
                .update();
        System.out.println(result);
    }

}
