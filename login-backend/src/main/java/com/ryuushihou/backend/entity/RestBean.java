package com.ryuushihou.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestBean {
    private String status;
    private boolean success;
    private Object message;

    public static RestBean success(Object data){
        return new RestBean("200",true, data.toString());
    }

    public static RestBean success(String message,String status){
        return new RestBean(status,true, message);
    }

    public static RestBean failure(String status){
        return new RestBean(status,true, null);
    }

    public static RestBean failure(String message,String status){
        return new RestBean(status,false, message);
    }

}
