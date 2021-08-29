package io.redbee.academy.microservicios.todolist.controller;

import io.redbee.academy.microservicios.todolist.model.TodoList;
import io.redbee.academy.microservicios.todolist.service.TodoListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoListWebController {

    private TodoListService service;

    TodoListWebController(TodoListService service) {
        this.service = service;
    }

    @GetMapping("/todo-list/nueva")
    public String TodoList(Model model) {
        TodoList todoList = service.createTodoList();
        model.addAttribute("todo-list", todoList);
        return "todo-list";
    }
}
