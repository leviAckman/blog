package com.levi.log.dao;

import com.levi.log.pojo.Tag;
import com.levi.log.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagDaoMapper {
    //根据Id查询一个类型
    Tag getTag(Integer tagId);
    //根据名称查询一个名称
    Tag getTagName(String tagName);
    //查询全部
    List<Tag> listTag();
    //添加一个类型
    int saveTag(String TagName);
    //更新一个类型
    int updateTag(Tag tag);
    //删除一个类型
    int deleteTag(Integer tagId);
    //前端显示查询
    List<Tag> listTagView();
    //前端显示查询
    List<Tag> listTagViewTag();
}
