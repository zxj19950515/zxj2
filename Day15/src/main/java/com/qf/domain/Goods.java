package com.qf.domain;

public class Goods {
    private Integer id;
    private String  shopName;
    private  String shopStatus;
    private  String shopDetil;
    private Integer posId;
    private String  createTime;
    private String  updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus;
    }

    public String getShopDetil() {
        return shopDetil;
    }

    public void setShopDetil(String shopDetil) {
        this.shopDetil = shopDetil;
    }

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Goods(Integer id, String shopName, String shopStatus, String shopDetil, Integer posId, String createTime, String updateTime) {
        this.id = id;
        this.shopName = shopName;
        this.shopStatus = shopStatus;
        this.shopDetil = shopDetil;
        this.posId = posId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Goods() {
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", shopName='" + shopName + '\'' +
                ", shopStatus='" + shopStatus + '\'' +
                ", shopDetil='" + shopDetil + '\'' +
                ", posId=" + posId +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
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

    private int startRow;
    private int endRow;
}

