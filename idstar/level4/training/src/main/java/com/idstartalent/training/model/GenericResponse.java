package com.idstartalent.training.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.idstartalent.training.util.Status;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

@Data
@Accessors(chain = true)
public class GenericResponse {
    private int code;
    private Object data;
    private Status status;
    @JsonIgnore
    private HttpStatus httpStatus;


    public void setFailed(int code, Status status, HttpStatus httpStatus){
        this.status = status;
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public void setSuccess(Object data){
        this.code = 200;
        this.data = data;
        this.status = Status.SUCCESS;
        this.httpStatus = HttpStatus.OK;
    }

    public void setSuccess(){
        this.code = 200;
        this.data = Status.SUCCESS;
        this.status = Status.SUCCESS;
        this.httpStatus = HttpStatus.OK;
    }
}
