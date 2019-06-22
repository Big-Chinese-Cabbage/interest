package com.interest.model.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 用于包装list数据的类
 *
 * @author wanghuan
 */
@Data
public class PageResult<T> {

    @ApiModelProperty("分页数据")
    private List<T> data;

    @ApiModelProperty("分页数据总量")
    private Integer totalCount;

    public PageResult() {
    }

    public PageResult(List<T> data, Integer totalCount) {
        this.data = data;
        this.totalCount = totalCount;
    }
}
