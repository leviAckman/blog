package com.levi.log.service;

import com.github.pagehelper.PageInfo;
import com.levi.log.pojo.Blog;
import com.levi.log.pojo.Comment;

import java.util.List;

/*评论业务接z*/
public interface CommentService {
    //添加一个评论
    boolean addComment(Comment comemnt);
    //根据博客id查询评论
    List<Comment> listCommentByBlogId(String blogId);
}
