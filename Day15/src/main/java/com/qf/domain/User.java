package com.qf.domain;

import java.util.Date;

public class User {
    private Integer id;

    private String userName;

    private String loginName;

    private String password;

    private String status;

    private Integer userPic;

    private Date createTime;

    private Date updateTime;

    private Integer userLevel;

    private int startRow;
    private int endRow;

    private ShopPic shopPic;

    public User(Integer id, String userName, String loginName, String password, String status, Integer userPic, Date createTime, Date updateTime, Integer userLevel) {
        this.id = id;
        this.userName = userName;
        this.loginName = loginName;
        this.password = password;
        this.status = status;
        this.userPic = userPic;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.userLevel = userLevel;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getUserPic() {
        return userPic;
    }

    public void setUserPic(Integer userPic) {
        this.userPic = userPic;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public ShopPic getShopPic() {
        return shopPic;
    }

    public void setShopPic(ShopPic shopPic) {
        this.shopPic = shopPic;
    }
}