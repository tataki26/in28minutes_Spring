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

    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        StringBuffer sb = new StringBuffer();

        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>My first HTML Page - Changed</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("My first html page with body - Changed");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

    // "say-hello-jsp" => sayHello.jsp
    // @ResponseBody를 생략하면 view 반환
    // view를 정의하면 Java 코드에 html을 정의할 필요가 없으므로 훨씬 간략하다
    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp() {
        // jsp 파일 이름 - 경로는 application.properties에서 지정
        return "sayHello";
    }
}
