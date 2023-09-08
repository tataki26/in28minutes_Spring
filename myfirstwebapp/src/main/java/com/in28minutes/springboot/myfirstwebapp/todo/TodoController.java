package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUsername("in28minutes");
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        String username = (String)model.get("name");
        // 단방향 바인딩 - Bean에서 양식으로 바인딩
        Todo todo = new Todo(0, username, "Default Desc", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    // command bean / 양식 보조 객체
    // 사용자 입력을 Bean에 직접 바인딩하기
    // @Valid: 검증을 트리거 하니 위한 어노테이션
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        // 검증에 오류가 있으면 다음 페이지로 넘어가지 않는다
        if (result.hasErrors()) {
            return "todo";
        }

        String username = (String)model.get("name");
        todoService.addTodo(username, todo.getDescription(), LocalDate.now().plusYears(1), false);

        // list-todos 페이지로 리다이렉트
        // view 이름이 아닌 url을 적어야 한다
        return "redirect:list-todos";
    }
}
