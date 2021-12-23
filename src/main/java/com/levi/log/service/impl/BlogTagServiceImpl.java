package com.levi.log.service.impl;

import com.levi.log.dao.BlogTagDaoMapper;
import com.levi.log.service.BlogTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogTagServiceImpl implements BlogTagService {
    @Autowired
    BlogTagDaoMapper btdm;
    @Override
    public boolean addBlogTag(String blogId, int[] tagIds) {
        for (int tagId : tagIds) {
            btdm.addBlogTag(blogId,tagId);
        }
        return true;
    }

    @Override
    public boolean deleteBlogTag(String blogId) {
        btdm.deleteBlogTag(blogId);
        return true;
    }
}
