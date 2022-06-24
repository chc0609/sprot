package com.hezong.pojo;

public class QueryProInfo {
    private String queryName; //可查零件与产品名称
    private int pageNum=1; //当前页数
    private int pageSize=1; //每页最大数

    public QueryProInfo() {
    }

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
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
                "queryName='" + queryName + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
