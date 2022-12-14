package com.cos.photogramstart.handler;

import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.util.Script;
import com.cos.photogramstart.web.dto.CMRespDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController // 데이터를 리턴할거니까
@ControllerAdvice // 모든익셉션 다낚아챔
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class) //RuntimeException이 발생하는 모든 Exception을
    public String validationException(CustomValidationException e){ // 이 함수가(validationException) 가로챔

        return Script.back(e.getErorMap().toString());
        /*CMRespDto와 Script만들어서 비교
        1. 클라이언트에게 응답할땐 스크립이 좋음
        -> 브라우저가받음
        2. ajax통신 - CMRespDto  ->개발자가받음 코드로받으니
        3. 안르도이드통신 CMRespDto ->개발자가받음 코드로받으니
         */
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)  // 벨리데이션 예외
    public void methodArgumentNotValidException(MethodArgumentNotValidException e){

        Map<String, String> errorMap = new HashMap<>();
        log.error("MethodArgumentNotValidException log");
        for (FieldError error : e.getFieldErrors()) {
            errorMap.put(error.getField(), error.getDefaultMessage());
        }
        throw new CustomValidationException("유효성 검사 실패함", errorMap);

    }

}


