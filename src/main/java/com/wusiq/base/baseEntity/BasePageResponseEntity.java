package com.wusiq.base.baseEntity;

import java.util.List;

/**
 * 返回分页的基类
 */
public class BasePageResponseEntity<T> {
    private int totalRecords=0;//总记录数
    private int totalPages=0;//总页数
    private int pageSize=10;//页面大小
    private int pageNumber=1;//当前第几页
    private List<T> list;//数据列表

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getTotalPages() {
        if(totalRecords%pageSize==0){
            totalPages = totalRecords/pageSize;
        }else if(totalRecords<pageSize){
            totalPages = 1;
        }else {
            totalPages = totalRecords/pageSize+1;
        }

        return totalPages;
    }

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

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

/*    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"totalRecords\":")
                .append(totalRecords);
        sb.append(",\"totalPages\":")
                .append(totalPages);
        sb.append(",\"pageSize\":")
                .append(pageSize);
        sb.append(",\"pageNumber\":")
                .append(pageNumber);
        sb.append(",\"list\":")
                .append(list);
        sb.append('}');
        return sb.toString();
    }*/
}
