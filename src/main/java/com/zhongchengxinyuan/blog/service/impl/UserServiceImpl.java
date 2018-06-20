package com.zhongchengxinyuan.blog.service.impl;

import com.zhongchengxinyuan.blog.model.User;
import com.zhongchengxinyuan.blog.repository.UserRepository;
import com.zhongchengxinyuan.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User validate(String username, String password) {
        User user = userRepository.findByUsername(username);
        return (user != null && user.getPassword().equals(password)) ? user : null;
    }

    @Override
    public User query(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public Long save(User user) {
        return userRepository.save(user).getId();
    }
}
