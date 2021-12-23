package com.levi.log.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.levi.log.dao.TypeDaoMapper;
import com.levi.log.pojo.Type;
import com.levi.log.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
/*类型业务实现类*/
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeDaoMapper tdm;
    //根据Id查询一个类型
    @Override
    public Type getType(Integer typeId) {
        return tdm.getType(typeId);
    }
    //根据名称查询一个类型
    @Override
    public Type getTypeName(String typeName) {
        return tdm.getTypeName(typeName);
    }
    //查询全部
    @Override
    public List<Type> listType() {
        return tdm.listType();
    }
    //分页查询
    @Override
    public PageInfo<Type> listTypePag(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Type> types = listType();
        return new PageInfo<Type>(types);
    }
    //添加一个类型
    @Override
    public boolean saveType(String typeName) {
        int i = tdm.saveType(typeName);
        if(i > 0){
            return true;
        }
        return false;
    }
    //更新一个类型
    @Override
    public boolean updateType(Type type) {
        int i = tdm.updateType(type);
        if(i > 0){
            return true;
        }
        return false;
    }
    //删除一个类型
    @Override
    public boolean deleteType(Integer typeId) {
        int i = tdm.deleteType(typeId);
        if(i > 0){
            return true;
        }
        return false;
    }
    //前端类型数据
    @Override
    public List<Type> listTypeView() {
        return tdm.listTypeView();
    }

    @Override
    public List<Type> listTypeViewType() {
        return tdm.listTypeViewType();
    }
}
