package com.in28minutes.learnspringsecurity.resources;

import jakarta.annotation.security.RolesAllowed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public static final List<Todo> TODOS_LIST =
            List.of(new Todo("in28mintues", "Learn AWS"),
                    new Todo("in28mintues", "Get AWS Certified"));

    @GetMapping("/todos")
            public List<Todo> retrieveAllTodos() {
        return TODOS_LIST;
    }

    // only USER can access this method
    @GetMapping("users/{username}/todos")
    // recommended: pre, post (flexible)
    @PreAuthorize("hasRole('USER') and #username == authentication.name") // in28minutes
    @PostAuthorize("returnObject.username == 'in28mintues'")
    // standard: jsr-250
    @RolesAllowed({"ADMIN", "USER"})
    // old spring
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public Todo retrieveTodosForSpecificUser(@PathVariable String username) {
        return TODOS_LIST.get(0);
    }

    @PostMapping("users/{username}/todos")
    public void createTodosForSpecificUser(@PathVariable String username, @RequestBody Todo todo) {
        logger.info("Create {} for {}", todo, username);
    }
}

record Todo(String username, String description) {}