package com.wychmod.aicloud.util;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ResponseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 4566135631432L;
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
