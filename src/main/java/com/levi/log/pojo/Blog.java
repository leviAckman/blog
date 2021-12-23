package com.levi.log.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*博客类*/
public class Blog {
    private String blogId; //id
    private String blogTitle; //标题
    private String blogContent; //博客内容
    private String blogFirstPicture; //博客图片
    private String blogDescribe; //博客描述
    private String blogFlag; // 标签：原创，转载，翻译
    private int blogClickNumber; // 博客点击数
    private boolean blogComment; //评论是否开启
    private boolean blogPublish; //是否发布
    private boolean blogRecommend; //是否推荐
    private Date blogCreateDate; //创建时间
    private Date blogUpdateDate; //修改时间

    //private boolean blogDonation; //捐助是否开启
    //private boolean blogCopyright; //版权是否开启

    //类型
    private Type type;
    //标签
    private List<Tag> tagList=new ArrayList<Tag>();
    private String tagIds;
    //评论
    private List<Comment> commentList=new ArrayList<Comment>();
    //用户
    private User user;

    public Blog() {

    }

    public void initTagIdsStr() {
        if (tagList!=null && tagList.size() > 0) {
            tagIds = "";
            for (int i = 0; i < tagList.size() - 1; i++) {
                tagIds += tagList.get(i).getTagId() + ",";
            }
            tagIds += tagList.get(tagList.size() - 1).getTagId();
        }
    }

    public String getBlogDescribe() {
        return blogDescribe;
    }

    public void setBlogDescribe(String blogDescribe) {
        this.blogDescribe = blogDescribe;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public String getBlogFirstPicture() {
        return blogFirstPicture;
    }

    public void setBlogFirstPicture(String blogFirstPicture) {
        this.blogFirstPicture = blogFirstPicture;
    }

    public String getBlogFlag() {
        return blogFlag;
    }

    public void setBlogFlag(String blogFlag) {
        this.blogFlag = blogFlag;
    }

    public int getBlogClickNumber() {
        return blogClickNumber;
    }

    public void setBlogClickNumber(int blogClickNumber) {
        this.blogClickNumber = blogClickNumber;
    }

    public boolean isBlogComment() {
        return blogComment;
    }

    public void setBlogComment(boolean blogComment) {
        this.blogComment = blogComment;
    }

    public boolean isBlogPublish() {
        return blogPublish;
    }

    public void setBlogPublish(boolean blogPublish) {
        this.blogPublish = blogPublish;
    }

    public boolean isBlogRecommend() {
        return blogRecommend;
    }

    public void setBlogRecommend(boolean blogRecommend) {
        this.blogRecommend = blogRecommend;
    }

    public Date getBlogCreateDate() {
        return blogCreateDate;
    }

    public void setBlogCreateDate(Date blogCreateDate) {
        this.blogCreateDate = blogCreateDate;
    }

    public Date getBlogUpdateDate() {
        return blogUpdateDate;
    }

    public void setBlogUpdateDate(Date blogUpdateDate) {
        this.blogUpdateDate = blogUpdateDate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
