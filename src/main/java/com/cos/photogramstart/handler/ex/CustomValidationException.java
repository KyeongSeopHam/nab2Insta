package com.cos.photogramstart.handler.ex;

import java.util.Map;

public class CustomValidationException extends RuntimeException{
    //객체를 구분할때
    private static final long serialVersionUID = 1L;

    private Map<String,String> erorMap;

 public  CustomValidationException(String message,Map<String,String> erorMap){
        super(message);
        this.erorMap=erorMap;
    }

    public Map<String,String> getErorMap(){
        return erorMap;
    }

}
