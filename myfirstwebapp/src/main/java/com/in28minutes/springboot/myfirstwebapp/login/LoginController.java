package com.in28minutes.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("login")
    // http://localhost:8080/login?name=Ranga
    // Model: view에 데이터를 넘기는 객체
    public String goToLoginPage(@RequestParam String name, ModelMap model) {
        // jsp의 name이라는 이름의 속성에 name 파라미터 전달
        model.put("name", name);
        logger.debug("Request param is {}", name);
        logger.info("I want this printed at info level");
        return "login";
    }
}
