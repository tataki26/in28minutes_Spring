package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    // "say-hello" => "Hello! What are you learning today?"
    // http://localhost:8080/say-hello
    @RequestMapping("say-hello")
    // 리턴된 메시지 그대로 브라우저에 전송
    @ResponseBody
    public String sayHello() {
        // [default] SpringMVC - 문자열 리턴 >> view 이름
        return "Hello! What are you learning today?";
    }
}
