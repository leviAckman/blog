package com.levi.log.service;

import com.github.pagehelper.PageInfo;
import com.levi.log.pojo.Tag;

import java.util.List;
/*标签业务接口*/
public interface TagService {
    //根据Id查询一个类型
    Tag getTag(Integer tagId);
    //根据名称查询一个名称
    Tag getTagName(String tagName);
    //查询全部
    List<Tag> listTag();
    //分页查询
    PageInfo<Tag> listTagPag(int pageNum,int pageSize);
    //添加一个类型
    boolean saveTag(String TagName);
    //更新一个类型
    boolean updateTag(Tag tag);
    //删除一个类型
    boolean deleteTag(Integer tagId);
    //前端显示查询
    List<Tag> listTagView();
    //前端显示查询
    List<Tag> listTagViewTag();
}
