package com.levi.log.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.levi.log.dao.TagDaoMapper;
import com.levi.log.dao.TypeDaoMapper;
import com.levi.log.pojo.Tag;
import com.levi.log.pojo.Type;
import com.levi.log.service.TagService;
import com.levi.log.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/*标签业务实现类*/
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagDaoMapper tdm;
    //根据Id查询一个类型
    @Override
    public Tag getTag(Integer tagId) {
        return tdm.getTag(tagId);
    }
    //根据名称查询一个类型
    @Override
    public Tag getTagName(String tagName) {
        return tdm.getTagName(tagName);
    }
    //查询全部
    @Override
    public List<Tag> listTag() {
        return tdm.listTag();
    }
    //分页查询
    @Override
    public PageInfo<Tag> listTagPag(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Tag> tags = listTag();
        return new PageInfo<Tag>(tags);
    }
    //添加一个类型
    @Override
    public boolean saveTag(String tagName) {
        int i = tdm.saveTag(tagName);
        if(i > 0){
            return true;
        }
        return false;
    }
    //更新一个类型
    @Override
    public boolean updateTag(Tag tag) {
        int i = tdm.updateTag(tag);
        if(i > 0){
            return true;
        }
        return false;
    }
    //删除一个类型
    @Override
    public boolean deleteTag(Integer tagId) {
        int i = tdm.deleteTag(tagId);
        if(i > 0){
            return true;
        }
        return false;
    }
    //前端显示查询
    @Override
    public List<Tag> listTagView() {
        return tdm.listTagView();
    }

    @Override
    public List<Tag> listTagViewTag() {
        return tdm.listTagViewTag();
    }
}
