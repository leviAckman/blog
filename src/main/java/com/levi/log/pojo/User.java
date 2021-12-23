package com.levi.log.pojo;

import java.util.Date;
import java.util.List;

/*管理员类*/
public class User {
    private Integer userId; //id
    private String userName; //用户名称
    private String userPassword; //用户密码
    private String userEmail;//用户邮箱
    private String userType;//用户类型
    private String userProfilePhoto; //用户头像
    private Date userCreateDate; //用户创建时间
    private Date userUpdateDate; //用户更新时间
    //博客
    private List<Blog> blogList;

    public User() {
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserProfilePhoto() {
        return userProfilePhoto;
    }

    public void setUserProfilePhoto(String userProfilePhoto) {
        this.userProfilePhoto = userProfilePhoto;
    }

    public Date getUserCreateDate() {
        return userCreateDate;
    }

    public void setUserCreateDate(Date userCreateDate) {
        this.userCreateDate = userCreateDate;
    }

    public Date getUserUpdateDate() {
        return userUpdateDate;
    }

    public void setUserUpdateDate(Date userUpdateDate) {
        this.userUpdateDate = userUpdateDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userType='" + userType + '\'' +
                ", userProfilePhoto='" + userProfilePhoto + '\'' +
                ", userCreateDate=" + userCreateDate +
                ", userUpdateDate=" + userUpdateDate +
                '}';
    }
}
