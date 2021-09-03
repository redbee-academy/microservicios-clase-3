package io.redbee.academy.microservicios.todolist.controller;

import io.redbee.academy.microservicios.todolist.dto.ItemAccionDto;
import io.redbee.academy.microservicios.todolist.dto.NuevoItemDto;
import io.redbee.academy.microservicios.todolist.model.TodoList;
import io.redbee.academy.microservicios.todolist.service.TodoListService;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TodoListWebController {

    private TodoListService service;

    TodoListWebController(TodoListService service) {
        this.service = service;
    }

    @GetMapping({"/", "/todo-list/", "/todo-list/nueva"})
    public String nuevaTodoList(Model model) {
        TodoList todoList = service.createTodoList();
        model.addAttribute("todoList", todoList);
        model.addAttribute("nuevoItem", new NuevoItemDto());
        model.addAttribute("itemAccion", new ItemAccionDto());
        return "todo-list";
    }

    @PostMapping("/todo-list/{listId}/items")
    public String agregarItem(@PathVariable("listId") String listId, @ModelAttribute NuevoItemDto item, Model model) {
        TodoList todoList = service.agregarItem(listId , item.getDetalle());
        model.addAttribute("todoList", todoList);
        model.addAttribute("nuevoItem", new NuevoItemDto());
        model.addAttribute("itemAccion", new ItemAccionDto());
        return "todo-list";
    }

    @PostMapping(value = "/todo-list/{listId}/items/{itemId}/cambiarEstado",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String agregarItem(@PathVariable("listId") String listId, @PathVariable("itemId") String itemId, ItemAccionDto itemAccion, Model model) {
        TodoList todoList = service.cambiarEstadoItem(listId, itemId);
        model.addAttribute("todoList", todoList);
        model.addAttribute("nuevoItem", new NuevoItemDto());
        model.addAttribute("itemAccion", new ItemAccionDto());
        return "todo-list";
    }
}
