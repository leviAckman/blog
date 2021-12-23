package com.levi.log.service;

public interface BlogTagService {
    boolean addBlogTag(String blogId,int[] tagIds);
    boolean deleteBlogTag(String blogId);
}
