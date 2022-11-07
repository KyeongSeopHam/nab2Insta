package com.cos.photogramstart.handler;

import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.util.Script;
import com.cos.photogramstart.web.dto.CMRespDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController // 데이터를 리턴할거니까
@ControllerAdvice // 모든익셉션 다낚아챔
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class) //RuntimeException이 발생하는 모든 Exception을
    public String validationException(CustomValidationException e){ // 이 함수가(validationException) 가로챔
        return Script.back(e.getErorMap().toString());
    }
}
