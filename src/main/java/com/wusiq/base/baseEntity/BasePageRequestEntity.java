package com.wusiq.base.baseEntity;

/**
 * 分页查询，请求参数实体类
 */
public class BasePageRequestEntity {
    private int pageSize=10;//页面大小
    private int pageNumber=1;//当前第几页

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
