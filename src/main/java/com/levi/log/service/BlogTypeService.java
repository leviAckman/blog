package com.levi.log.service;

import org.apache.ibatis.annotations.Param;

public interface BlogTypeService {
    boolean addBlogType(String blogId,int typeId);
    boolean deleteBlogType(String blogId);
    boolean updateBlogType(@Param("typeId")int typeId, @Param("blogId")String blogId);
}
