package me.cxz.samples.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.cxz.samples.dao.UserMapper;
import me.cxz.samples.entity.User;
import me.cxz.samples.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
