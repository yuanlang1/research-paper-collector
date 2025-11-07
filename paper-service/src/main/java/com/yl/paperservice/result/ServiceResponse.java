package com.yl.paperservice.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author yl
 * @date 2025-11-03 21:19
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;
    private Long timestamp = System.currentTimeMillis();

    public static <T> ServiceResponse<T> success(){
        return new ServiceResponse<T>()
                .setCode(ResponseCode.SUCCESS.code)
                .setMsg(ResponseCode.SUCCESS.msg);
    }

    public static <T> ServiceResponse<T> success(T data){
        return new ServiceResponse<T>()
                .setCode(ResponseCode.SUCCESS.code)
                .setMsg(ResponseCode.SUCCESS.msg)
                .setData(data);
    }

    public static <T> ServiceResponse<T> error(String msg){
        return new ServiceResponse<T>()
                .setCode(ResponseCode.BUSINESS_ERROR.code)
                .setMsg(msg);
    }
}
