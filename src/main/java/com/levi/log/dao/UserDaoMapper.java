package com.levi.log.dao;

import com.levi.log.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
/*user dao类*/
@Mapper
@Repository
public interface UserDaoMapper {
    //根据名称查询一个User
    User getUser(String username);
}
