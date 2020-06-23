package com.wotrd.dubboprovider.controller;

import com.wotrd.dubboprovider.api.User;
import com.wotrd.dubboprovider.api.UserInfoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: DubboController
 * @Description: TODO
 * @Author: wotrd
 * @Date: 2020/6/20 20:44
 */
@RestController
public class DubboController {

    @DubboReference(version = "1.0.1", group = "user_group", timeout = 10000, retries = 3)
    private UserInfoService userInfoService;

    @GetMapping("userInfo")
    public User userInfo() {
        return userInfoService.getUserInfo();
    }

}