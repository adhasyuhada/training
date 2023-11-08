package com.idstartalent.training.util;

public enum Code {
    SUCCESS(200), BUSINESS_ERROR(400), SYSTEM_ERROR(500);

    private int code;

    public int getCode(){
        return this.code;
    }

    private Code(int code){
        this.code = code;
    }
}
