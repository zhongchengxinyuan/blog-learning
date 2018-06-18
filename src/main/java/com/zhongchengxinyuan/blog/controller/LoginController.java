package com.zhongchengxinyuan.blog.controller;

import com.zhongchengxinyuan.blog.model.User;
import com.zhongchengxinyuan.blog.payload.LoginReqPayload;
import com.zhongchengxinyuan.blog.payload.ResponsePayload;
import com.zhongchengxinyuan.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponsePayload login(@RequestBody LoginReqPayload payload){
        User user = userService.validate(payload.getUsername(), payload.getPassword());
        if(user != null){
            return ResponsePayload.build().setData(user);
        }else{
            return ResponsePayload.build().setCode("0101").setMessage("Login failed");
        }
    }
}
