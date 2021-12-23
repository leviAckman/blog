package com.levi.log.service.impl;

import com.levi.log.dao.UserDaoMapper;
import com.levi.log.pojo.User;
import com.levi.log.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*user 业务实现类*/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDaoMapper udm;

    //根据名称查询一个user
    @Override
    public User getUser(String username) {
        return udm.getUser(username);
    }
}
