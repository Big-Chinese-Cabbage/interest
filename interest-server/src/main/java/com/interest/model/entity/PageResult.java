package com.interest.model.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 用于包装list数据的类
 *
 * @author wanghuan
 */
public class PageResult {

    @ApiModelProperty("分页数据")
    private List<?> data;

    @ApiModelProperty("分页数据总量")
    private Integer totalCount;

    public PageResult(){}

    public PageResult(List<?> data,Integer totalCount){
        this.data = data;
        this.totalCount = totalCount;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "PageResult [data=" + data + ", totalCount=" + totalCount + "]";
    }
}
