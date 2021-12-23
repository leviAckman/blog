package com.levi.log.service;

import com.github.pagehelper.PageInfo;
import com.levi.log.pojo.Blog;
import com.levi.log.pojo.Tag;

import java.util.List;
/*博客业务接口*/
public interface BlogService {
    //根据id查询博客
    Blog getBlog(String blogId);
    //分页查询
    PageInfo<Blog> ListBlog(int pageNum,int pageSize);
    //根据条件查询博客
    List<Blog> listBlog(Blog blog);
    //查询全部博客
    PageInfo<Blog> listBlog(int pageNum,int pageSize);
    //添加一个博客
    boolean addBlog(Blog blog,int typeId,int[] tagId);
    //删除一个博客
    boolean deleteBlog(String blogId);
    //更新一个博客
    boolean updateBlog(Blog blog,int typeId,int[] tagId);
    //前端显示博客
    PageInfo<Blog> listBlogView(int pageNum,int pageSize);
    //查看推荐的
    List<Blog> ListBlogRecomment();
    //根据id查询数据
    PageInfo<Blog> listBlogTypeId(int pageNum, int pageSize,int typeId);
    //根据id查询数据
    PageInfo<Tag> listBlogTagId(int pageNum, int pageSize, int tagId);
    //搜索
    PageInfo<Blog> listBlogQuery(int pageNum, int pageSize,String query);

    //查询全部年份
    List<String> blogCreateYears();
    //按照年份查询
    List<Blog> blogByYears(String year);

    Blog getBlogView(String blogId);
}
