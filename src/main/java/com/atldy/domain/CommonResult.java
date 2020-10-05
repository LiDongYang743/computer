package com.atldy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 唐多山
 * @create 2020-09-30 11:36
 *
 * 用于封装后端返回前端数据对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code; //返回状态码
    private String  message; // 返回情况
    private T data; // 返回参数

    public  CommonResult(Integer code,String  message){
        this(code,message,null);
    }

}
