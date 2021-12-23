package com.levi.log.dao;

import com.github.pagehelper.PageInfo;
import com.levi.log.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*博客标签接口*/
@Repository
@Mapper
public interface BlogTagDaoMapper {
    int addBlogTag(@Param("blogId") String blogId,@Param("tagId") int tagId);
    int deleteBlogTag(String blogId);
}
