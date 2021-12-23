package com.levi.log.service;

import com.levi.log.pojo.User;
/*user 业务接口类*/
public interface UserService {
    //根据名称查询一个user
    User getUser(String username);
}
