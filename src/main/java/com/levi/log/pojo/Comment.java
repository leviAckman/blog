package com.levi.log.pojo;

import java.util.Date;
import java.util.List;

/*评论类*/
public class Comment {
    private Integer commentId; //id
    private String commentNike; //评论昵称
    private String commentEmail; //评论邮箱
    private String commentPhoto; //评论头像
    private String commentContent; //评论内容
    private Date commentCreateDate; //评论时间
    //博客
    private String commentBlogId;
    //是否为博主
    private boolean commentBlogger;

    public Comment() {
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentNike() {
        return commentNike;
    }

    public void setCommentNike(String commentNike) {
        this.commentNike = commentNike;
    }

    public String getCommentEmail() {
        return commentEmail;
    }

    public void setCommentEmail(String commentEmail) {
        this.commentEmail = commentEmail;
    }

    public String getCommentPhoto() {
        return commentPhoto;
    }

    public void setCommentPhoto(String commentPhoto) {
        this.commentPhoto = commentPhoto;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentCreateDate() {
        return commentCreateDate;
    }

    public void setCommentCreateDate(Date commentCreateDate) {
        this.commentCreateDate = commentCreateDate;
    }

    public String getCommentBlogId() {
        return commentBlogId;
    }

    public void setCommentBlogId(String commentBlogId) {
        this.commentBlogId = commentBlogId;
    }

    public boolean isCommentBlogger() {
        return commentBlogger;
    }

    public void setCommentBlogger(boolean commentBlogger) {
        this.commentBlogger = commentBlogger;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentNike='" + commentNike + '\'' +
                ", commentEmail='" + commentEmail + '\'' +
                ", commentPhoto='" + commentPhoto + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", commentCreateDate=" + commentCreateDate +
                ", commentBlogId='" + commentBlogId + '\'' +
                ", commentBlogger=" + commentBlogger +
                '}';
    }
}
