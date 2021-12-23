package com.levi.log.service;

import com.github.pagehelper.PageInfo;
import com.levi.log.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
/*类型业务接口*/
public interface TypeService {
    //根据Id查询一个类型
    Type getType(Integer typeId);
    //根据名称查询一个类型
    Type getTypeName(String typeName);
    //查询全部
    List<Type> listType();
    //分页查询
    PageInfo<Type> listTypePag(int pageNum,int pageSize);
    //添加一个类型
    boolean saveType(String typeName);
    //更新一个类型
    boolean updateType(Type type);
    //删除一个类型
    boolean deleteType(Integer typeId);
    //前端类型数据
    List<Type> listTypeView();
    //前端类型数据
    List<Type> listTypeViewType();
}
