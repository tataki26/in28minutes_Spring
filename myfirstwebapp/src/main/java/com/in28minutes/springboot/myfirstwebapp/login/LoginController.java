package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @RequestMapping("login")
    // http://localhost:8080/login?name=Ranga
    // Model: view에 데이터를 넘기는 객체
    public String goToLoginPage(@RequestParam String name, ModelMap model) {
        // jsp의 name이라는 이름의 속성에 name 파라미터 전달
        model.put("name", name);
        // 예시로 사용하는 것일 뿐 실무에서는 콘솔 출력 대신 로깅 사용을 권장
        System.out.println("Request param is " + name);
        return "login";
    }
}
