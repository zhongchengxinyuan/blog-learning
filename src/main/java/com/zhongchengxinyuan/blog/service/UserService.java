package com.zhongchengxinyuan.blog.service;

import com.zhongchengxinyuan.blog.model.User;

public interface UserService {

    User validate(String username, String password);

    User query(Long userId);

    Long save(User user);
}
