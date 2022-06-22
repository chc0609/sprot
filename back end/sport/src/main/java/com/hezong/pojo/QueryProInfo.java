package com.hezong.pojo;

public class QueryProInfo {
    private String productName; //查询信息productName
    private String productOEM;  //零件号
    private int pageNum=1; //当前页数
    private int pageSize=1; //每页最大数

    public QueryProInfo() {
    }

    public QueryProInfo(String productName, String productOEM, int pageNum, int pageSize) {
        this.productName = productName;
        this.productOEM = productOEM;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductOEM() {
        return productOEM;
    }

    public void setProductOEM(String productOEM) {
        this.productOEM = productOEM;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "QueryProInfo{" +
                "productName='" + productName + '\'' +
                ", productOEM='" + productOEM + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
