package com.itorizon.spring.data.jpatotorial.Exception;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResponseModel extends RuntimeException{
     String Massage;

    public ResponseModel(String massage) {
        Massage = massage;
    }

    public String getMassage() {
        return Massage;
    }

    public void setMassage(String massage) {
        Massage = massage;
    }
}
