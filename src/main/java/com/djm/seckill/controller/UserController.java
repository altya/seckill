package com.djm.seckill.controller;

import com.djm.seckill.controller.viewobject.UserVO;
import com.djm.seckill.error.BusinessException;
import com.djm.seckill.error.EmBusinessError;
import com.djm.seckill.response.CommonReturnType;
import com.djm.seckill.service.UserService;
import com.djm.seckill.service.model.UserModel;
import org.apache.ibatis.ognl.IntHashMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
    public  CommonReturnType getUser(@RequestParam(name="id") Integer id) throws BusinessException {
        UserModel userModel = userService.getUserById(id);;//getUserById(id);

        //若获取的对应用户信息不存在
        if (userModel == null) {
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }

        // 将核心领域模型对象转化为可供UI使用的VO
        UserVO userVO = convertFromModel(userModel);
        // 返回通用对象
        return CommonReturnType.create(userVO);
    }

    private UserVO convertFromModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel,userVO);
        return userVO;
    }

    // 定义exceptionhandler解决未被contriller层吸收的exception
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException (HttpServletRequest request,Exception ex) {


        BusinessException businessException = (BusinessException)ex;
        Map<String,Object> responseData = new HashMap<>();
        responseData.put("errCode",businessException);
        responseData.put("errMsg",businessException.getErrMsg());
        return CommonReturnType.create(responseData,"fail");
    }
}
