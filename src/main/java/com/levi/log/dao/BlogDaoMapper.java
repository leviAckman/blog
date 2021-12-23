package com.levi.log.dao;

import com.github.pagehelper.PageInfo;
import com.levi.log.pojo.Blog;
import com.levi.log.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/*博客业务接口*/
@Repository
@Mapper
public interface BlogDaoMapper {
    //根据id查询博客
    Blog getBlog(String blogId);
    //分页查询
    PageInfo<Blog> ListBlog(int pageNum,int pageSize);
    //根据条件查询博客
    List<Blog> listBlog(Blog blog);
    //查询全部博客
    List<Blog> listBlog();
    //添加一个博客
    int addBlog(Blog blog);
    //删除一个博客
    int deleteBlog(String blogId);
    //更新一个博客
    int updateBlog(Blog blog);
    //前端显示博客
    List<Blog> listBlogView();
    //查看推荐的
    List<Blog> ListBlogRecomment();
    //根据id查询数据
    List<Blog> listBlogTypeId(int typeId);
    //根据id查询数据
    List<Tag> listBlogTagId(int tagId);

    //搜索
    List<Blog> listBlogQuery(String query);

    //查询全部年份
    List<String> blogCreateYears();
    //按照年份查询
    List<Blog> blogByYears(String year);

    Blog getBlogView(String blogId);

}
