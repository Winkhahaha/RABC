package com.mineok.base;

import lombok.Data;

import java.io.Serializable;

/*
  封装page,便于分页时传参
 */
@Data
public class PageTableRequest implements Serializable {

    private Integer page;   // 页码
    private Integer limit;  // 每页数据量

    // 计算索引偏移位置offset
    public Integer getOffset() {
        if (null == this.page || null == this.limit) {
            // this.offset = 0;
            return 0;
        }
        // p1页从0(offset)开始,获取两个(limit)
        // p1 (select limit) 0,2;
        // ......
        // p2 (select limit) 2,2;
        // p3 (select limit) 2,2;
        return (this.page - 1) * limit;
    }

}
