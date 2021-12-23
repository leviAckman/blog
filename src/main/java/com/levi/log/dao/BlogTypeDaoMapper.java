package com.levi.log.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/*博客标签接口*/
@Repository
@Mapper
public interface BlogTypeDaoMapper {
    int addBlogType(@Param("blogId") String blogId,@Param("typeId") int typeId);
    int deleteBlogType(String blogId);
    int updateBlogType(@Param("typeId")int typeId,@Param("blogId")String blogId);
}
