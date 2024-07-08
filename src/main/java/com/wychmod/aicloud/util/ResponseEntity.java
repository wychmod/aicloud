package com.wychmod.aicloud.util;

import lombok.Data;

@Data
public class ResponseEntity {
    private int code;
    private String msg;
    private Object data;


    public static ResponseEntity success(Object data) {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setCode(200);
        responseEntity.setMsg("success");
        responseEntity.setData(data);
        return responseEntity;
    }

    public static ResponseEntity fail(String msg) {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setCode(500);
        responseEntity.setMsg(msg);
        return responseEntity;
    }
}
