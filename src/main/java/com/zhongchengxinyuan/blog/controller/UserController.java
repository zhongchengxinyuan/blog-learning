package com.zhongchengxinyuan.blog.controller;

import com.zhongchengxinyuan.blog.model.User;
import com.zhongchengxinyuan.blog.payload.ResponsePayload;
import com.zhongchengxinyuan.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponsePayload query(HttpServletRequest request){
        Object obj = request.getSession().getAttribute("userId");
        if(obj == null){
            return ResponsePayload.build().setCode("0101").setMessage("没有登录");
        }
        Long userId = Long.valueOf(String.valueOf(obj));
        return ResponsePayload.build().setData(userService.query(userId));
    }

    @PostMapping("/save")
    public ResponsePayload save(HttpServletRequest request, User user){
        Object obj = request.getSession().getAttribute("userId");
        if(obj == null){
            return ResponsePayload.build().setCode("0101").setMessage("没有登录");
        }
        Long userId = Long.valueOf(String.valueOf(obj));
        user.setId(userId);
        userService.save(user);
        return ResponsePayload.build();
    }
}
