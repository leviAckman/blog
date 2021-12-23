package com.levi.log.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.levi.log.dao.BlogDaoMapper;
import com.levi.log.dao.BlogTagDaoMapper;
import com.levi.log.exception.BlogNotFoundException;
import com.levi.log.pojo.Blog;
import com.levi.log.pojo.Tag;
import com.levi.log.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/*博客业务实现类*/
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogDaoMapper blogDaoMapper;
    @Autowired
    BlogTypeService blogTypeService;
    @Autowired
    BlogTagService blogTagService;

    /*根据id查询博客*/
    @Override
    public Blog getBlog(String blogId) {
        return blogDaoMapper.getBlog(blogId);
    }
    //分页查询
    @Override
    public PageInfo<Blog> ListBlog(int pageNum, int pageSize) {
        return null;
    }
    //根据条件查询博客
    @Override
    public List<Blog> listBlog(Blog blog) {
        return null;
    }
    //查询全部博客
    @Override
    public PageInfo<Blog> listBlog(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<Blog>(blogDaoMapper.listBlog());
    }
    /*添加一个博客*/
    @Override
    public boolean addBlog(Blog blog,int typeId,int[] tagId) {
        String blogId= UUID.randomUUID().toString().replace("-","");
        blog.setBlogId(blogId);
        blog.setBlogCreateDate(new Date());
        blog.setBlogUpdateDate(new Date());
        //中间表
        blogTypeService.addBlogType(blogId,typeId);
        blogTagService.addBlogTag(blogId,tagId);
        //添加博客
        int i = blogDaoMapper.addBlog(blog);
        return true;
    }
    /*删除一个博客*/
    @Override
    public boolean deleteBlog(String blogId) {
        //删除类型
        blogTypeService.deleteBlogType(blogId);
        //删除标签
        blogTagService.deleteBlogTag(blogId);
        //删除博客
        blogDaoMapper.deleteBlog(blogId);
        return true;
    }
    /*更新一个博客*/
    @Override
    public boolean updateBlog(Blog blog,int typeId,int[] tagId) {
        blog.setBlogUpdateDate(new Date());
        //修改博客
        blogDaoMapper.updateBlog(blog);
        //修改类型
        blogTypeService.updateBlogType(typeId,blog.getBlogId());
        //删除所有标签
        blogTagService.deleteBlogTag(blog.getBlogId());
        //添加标签
        blogTagService.addBlogTag(blog.getBlogId(),tagId);
        return false;
    }
    /*前端显示博客*/
    @Override
    public PageInfo<Blog> listBlogView(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<Blog>(blogDaoMapper.listBlogView());
    }
    /*查看推荐的*/
    @Override
    public List<Blog> ListBlogRecomment() {
        return blogDaoMapper.ListBlogRecomment();
    }

    @Override
    public Blog getBlogView(String blogId) {
        Blog blogView = blogDaoMapper.getBlogView(blogId);
        if(blogView==null){
            throw new BlogNotFoundException();
        }
        return blogView;
    }
    /*按照type 显示博客*/
    @Override
    public PageInfo<Blog> listBlogTypeId(int pageNum, int pageSize,int typeId) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<Blog>(blogDaoMapper.listBlogTypeId(typeId));
    }
    /*按照tag 显示博客*/
    @Override
    public PageInfo<Tag> listBlogTagId(int pageNum, int pageSize, int tagId) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<Tag>(blogDaoMapper.listBlogTagId(tagId));
    }

    /*搜索*/
    @Override
    public PageInfo<Blog> listBlogQuery(int pageNum, int pageSize, String query) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<Blog>(blogDaoMapper.listBlogQuery(query));
    }

    /*查询所有创建的年份*/
    @Override
    public List<String> blogCreateYears() {
        return blogDaoMapper.blogCreateYears();
    }

    /*按照年份查询*/
    @Override
    public List<Blog> blogByYears(String year) {
        return blogDaoMapper.blogByYears(year);
    }
}
