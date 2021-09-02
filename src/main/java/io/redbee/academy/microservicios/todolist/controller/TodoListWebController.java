package io.redbee.academy.microservicios.todolist.controller;

import io.redbee.academy.microservicios.todolist.dto.NuevoItemDto;
import io.redbee.academy.microservicios.todolist.model.TodoList;
import io.redbee.academy.microservicios.todolist.service.TodoListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoListWebController {

    private TodoListService service;

    TodoListWebController(TodoListService service) {
        this.service = service;
    }

    @GetMapping("/todo-list/nueva")
    public String nuevaTodoList(Model model) {
        TodoList todoList = service.createTodoList();
        model.addAttribute("todoList", todoList);
        model.addAttribute("nuevoItem", new NuevoItemDto());
        return "todo-list";
    }

    @PostMapping("/todo-list/{id}/items")
    public String agregarItem(@PathVariable("id") String listId, @ModelAttribute NuevoItemDto item, Model model) {
        TodoList todoList = service.agregarItem(listId , item.getDetalle());
        model.addAttribute("todoList", todoList);
        model.addAttribute("nuevoItem", new NuevoItemDto());
        return "todo-list";
    }
}
