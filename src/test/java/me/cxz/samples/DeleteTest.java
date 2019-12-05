package me.cxz.samples;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import me.cxz.samples.dao.UserMapper;
import me.cxz.samples.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DeleteTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void deleteById() {
        int rows = userMapper.deleteById(1201791917851521025L);
        System.out.println("删除条数：" + rows);
    }

    @Test
    public void deleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "刘明强");
        map.put("age", 31);
        int rows = userMapper.deleteByMap(map);
        System.out.println("删除条数：" + rows);
    }

    @Test
    public void deleteByIds() {
        int rows = userMapper.deleteBatchIds(Arrays.asList(1201793087185637378L, 1201793128482791426L));
        System.out.println("删除条数：" + rows);
    }

    @Test
    public void deleteByWrapper() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = Wrappers.<User>lambdaQuery();
        lambdaQueryWrapper.eq(User::getAge,21);
        int rows = userMapper.delete(lambdaQueryWrapper);
        System.out.println("删除条数：" + rows);
    }

}
