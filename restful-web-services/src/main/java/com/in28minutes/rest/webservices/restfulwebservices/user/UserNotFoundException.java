package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Exception에 HTTP 응답 코드 지정하기
@ResponseStatus(code = HttpStatus.NOT_FOUND)
// RuntimeException을 상속하면 uncheck 예외
public class UserNotFoundException extends RuntimeException {
    // message: 사용자 ID
    // try catch에서 해당 message 받아서 로깅 처리하는 데 사용
    public UserNotFoundException(String message) {
        super(message);
    }
}
