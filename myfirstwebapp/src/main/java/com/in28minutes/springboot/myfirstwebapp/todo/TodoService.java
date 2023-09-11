package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;
    // static 필드 초기화
    static {
        todos.add(new Todo(++todosCount, "in28minutes", "Learn AWS with Ranga", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "in28minutes", "Learn DevOps", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount, "in28minutes", "Learn Full Stack Development", LocalDate.now().plusYears(3), false));
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate
                = todo -> todo.getId() == id;
        return todos.stream()
                    .filter(predicate)
                    .findFirst()
                    .get();
    }

    public List<Todo> findByUsername(String username) {
        Predicate<? super Todo> predicate
                = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream()
                    .filter(predicate)
                    .toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, done);
        todos.add(todo);
    }
    
    public void deleteById(int id) {
        // 모든 bean의 id를 체크하여 원하는 id의 항목 찾기
        Predicate<? super Todo> predicate
                = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
