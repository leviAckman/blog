package com.levi.log.service.impl;

import com.levi.log.dao.CommentDaoMapper;
import com.levi.log.pojo.Comment;
import com.levi.log.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
   @Autowired
    CommentDaoMapper commentDaoMapper;

    @Override
    public boolean addComment(Comment comemnt) {
        int i = commentDaoMapper.addComment(comemnt);
        if(i > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Comment> listCommentByBlogId(String blogId) {
        return commentDaoMapper.listCommentByBlogId(blogId);
    }
}
