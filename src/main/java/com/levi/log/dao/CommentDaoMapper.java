package com.levi.log.dao;

import com.levi.log.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/*评论持久层接口*/
@Repository
@Mapper
public interface CommentDaoMapper {
    //添加一个评论
    int addComment(Comment comemnt);
    //根据博客id查询评论
    List<Comment> listCommentByBlogId(String blogId);
}
