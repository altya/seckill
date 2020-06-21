package com.djm.seckill;

import com.djm.seckill.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"com.djm.seckill"})
@RestController
@MapperScan("com.djm.seckill.dao")
public class App {

    @Autowired
    private UserService userService;
//    @Autowired
//    private UserDOMapper userDOMapper;

    @RequestMapping("/")
    public Integer home() {
//        UserDO userDo = userDOMapper.selectByPrimaryKey(1);
//        if (userDo == null) {
//            return "用户对象不存在";
//        } else {
//            return  userDo.getName();
//        }
        return userService.getIntById(1);
    }

    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);
    }
}
