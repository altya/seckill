package com.djm.seckill.controller;

import com.djm.seckill.service.UserService;
import com.djm.seckill.service.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Xiao_Ming on 2020/6/20.
 */
@Controller("user")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;




    @RequestMapping("/get")
    @ResponseBody
    public  UserModel getUser(@RequestParam(name="id") Integer id) {
        UserModel userModel = userService.getUserById(id);;//getUserById(id);
        return userModel;
    }
}
