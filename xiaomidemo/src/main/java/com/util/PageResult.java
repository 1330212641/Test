package com.util;
import java.util.List;

public class PageResult<T> {
    long total;
    List<T> rows;
    int pageNum;
    int pageSize;

    public PageResult(long total, List<T> rows,int pageNum, int pageSize) {
        this.total = total;
        this.rows = rows;
        this.pageNum = pageNum;
        this.pageSize =pageSize;
    }
    public long getTotal(){
        return total;
    }
}
