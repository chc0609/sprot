package com.hezong.pojo;

/**
 * 产品实体类
 */
public class Product {
    private int id;
    private String prodName; //产品名
    private String autoType; //车型
    private String oem; //零件号
    private String updateTime; //更新时间
    private String updateUser; //更新用户
    private String imagePath; //产品图片路径
    private boolean state; //状态

    public Product(int id, String prodName, String autoType, String oem, String updateTime, String updateUser, String imagePath, boolean state) {
        this.id = id;
        this.prodName = prodName;
        this.autoType = autoType;
        this.oem = oem;
        this.updateTime = updateTime;
        this.updateUser = updateUser;
        this.imagePath = imagePath;
        this.state = state;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getAutoType() {
        return autoType;
    }

    public void setAutoType(String autoType) {
        this.autoType = autoType;
    }

    public String getOem() {
        return oem;
    }

    public void setOem(String oem) {
        this.oem = oem;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", prodName='" + prodName + '\'' +
                ", autoType='" + autoType + '\'' +
                ", oem='" + oem + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", updateUser='" + updateUser + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", state=" + state +
                '}';
    }
}
