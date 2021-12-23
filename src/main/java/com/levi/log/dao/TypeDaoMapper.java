package com.levi.log.dao;

import com.levi.log.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypeDaoMapper {
    //根据Id查询一个类型
    Type getType(Integer typeId);
    //根据名称查询一个名称
    Type getTypeName(String typeName);
    //查询全部
    List<Type> listType();
    //添加一个类型
    int saveType(String typeName);
    //更新一个类型
    int updateType(Type type);
    //删除一个类型
    int deleteType(Integer typeId);
    //前端类型数据
    List<Type> listTypeView();
    //前端类型数据
    List<Type> listTypeViewType();
}
