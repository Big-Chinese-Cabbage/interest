package com.interest.model.utils;

public class PageWrapper {

    private int pageSize;

    private int start;

    public PageWrapper(int pageSize, int page) {
        this.pageSize = pageSize;
        this.start = page * pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
