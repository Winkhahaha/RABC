package com.mineok.base;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Results<T> implements Serializable {

    Long count;//数据数量
    Integer code;//代码
    String msg;//信息
    List<T> datas;//返回数据
    T data;//任何类型条件

    public Results() {
    }

    public Results(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public Results(Integer code, String msg, T data, Long count, List<T> datas) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = count;
        this.datas = datas;
    }

    /* 无数据传输的 成功返回 */
    public static <T> Results<T> success() {
        return new Results<T>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }

    public static <T> Results<T> success(String msg) {
        return new Results<T>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> Results<T> success(ResponseCode resultCode) {
        return new Results<T>(resultCode.getCode(), resultCode.getMessage());
    }

    /* 单个数据传输的 成功返回 */
    public static <T> Results<T> success(T data) {
        return new Results<T>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), data, 0L, null);
    }

    public static <T> Results<T> success(String msg, T data) {
        return new Results<T>(ResponseCode.SUCCESS.getCode(), msg, data, 0L, null);
    }

    public static <T> Results<T> success(ResponseCode resultCode, T data) {
        return new Results<T>(resultCode.getCode(), resultCode.getMessage(), data, 0L, null);
    }

    /* 分页数据传输的 成功返回 */
    public static <T> Results<T> success(Long count, List<T> datas) {
        return new Results<T>(ResponseCode.TABLE_SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), null, count, datas);
    }

    public static <T> Results<T> success(String msg, Long count, List<T> datas) {
        return new Results<T>(ResponseCode.TABLE_SUCCESS.getCode(), msg, null, count, datas);
    }

    public static <T> Results<T> success(ResponseCode resultCode, Long count, List<T> datas) {
        return new Results<T>(resultCode.getCode(), resultCode.getMessage(), null, count, datas);
    }

    /* 无数据传输的 失败返回 */
    public static <T> Results<T> failure() {
        return new Results<T>(ResponseCode.FAIL.getCode(), ResponseCode.FAIL.getMessage());
    }

    public static <T> Results<T> failure(ResponseCode resultCode) {
        return new Results<T>(resultCode.getCode(), resultCode.getMessage());
    }

    public static <T> Results<T> failure(Integer code, String msg) {
        return new Results<T>(code, msg);
    }

    public static Results ok() {
        return new Results();
    }

}
