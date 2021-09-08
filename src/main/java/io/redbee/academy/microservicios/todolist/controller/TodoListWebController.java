package io.redbee.academy.microservicios.todolist.controller;

import io.redbee.academy.microservicios.todolist.dto.ItemAccionDto;
import io.redbee.academy.microservicios.todolist.dto.NuevoItemDto;
import io.redbee.academy.microservicios.todolist.model.TodoList;
import io.redbee.academy.microservicios.todolist.service.TodoListService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoListWebController {

    private TodoListService service;

    TodoListWebController(TodoListService service) {
        this.service = service;
    }

    @GetMapping(value = {"/", "/todo-list"})
    public String nuevaTodoList(Model model) {
        TodoList todoList = service.nuevaTodoList();
        model.addAttribute("todoList", todoList);
        return "todo-list";
    }

    @PostMapping(value = "/todo-list/agregarItem",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String agregarItem(NuevoItemDto item, Model model) {
        TodoList todoList = service.agregarItem(item.getListId() , item.getDetalle());
        model.addAttribute("todoList", todoList);
        return "todo-list";
    }

    @PostMapping(value = "/todo-list/cambiarEstado",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String agregarItem(ItemAccionDto itemAccion, Model model) {
        TodoList todoList = service.cambiarEstadoItem(itemAccion.getListId(), itemAccion.getItemId());
        model.addAttribute("todoList", todoList);
        return "todo-list";
    }
}
