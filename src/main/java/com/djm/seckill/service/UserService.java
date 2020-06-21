package com.djm.seckill.service;

import com.djm.seckill.service.model.UserModel;

/**
 * Created by Xiao_Ming on 2020/6/20.
 */
public interface UserService {
    UserModel getUserById(Integer id);
    Integer getIntById(Integer id);
}
