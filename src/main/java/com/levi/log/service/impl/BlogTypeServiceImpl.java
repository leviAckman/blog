package com.levi.log.service.impl;

import com.levi.log.dao.BlogTypeDaoMapper;
import com.levi.log.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogTypeServiceImpl implements BlogTypeService {
    @Autowired
    BlogTypeDaoMapper btdm;

    @Override
    public boolean addBlogType(String blogId, int typeId) {
        btdm.addBlogType(blogId,typeId);
        return true;
    }

    @Override
    public boolean deleteBlogType(String blogId) {
        btdm.deleteBlogType(blogId);
        return true;
    }

    @Override
    public boolean updateBlogType(int typeId, String blogId) {
        btdm.updateBlogType(typeId,blogId);
        return true;
    }
}
