package io.redbee.academy.microservicios.todolist.service;

import io.redbee.academy.microservicios.todolist.model.TodoList;
import io.redbee.academy.microservicios.todolist.model.TodoItem;
import io.redbee.academy.microservicios.todolist.repository.TodoListRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoListService {

    private TodoListRepository repository;

    public TodoListService(TodoListRepository repository) {
        this.repository = repository;
    }

    public TodoList createTodoList() {
        TodoList nuevaTodoList = new TodoList();
        this.repository.saveTodoList(nuevaTodoList);
        return nuevaTodoList;
    }


    public TodoList buscarTodoList(String uuid) {
        return this.repository.getTodoList(uuid);
    }

    public TodoList agregarItem(String listId, String descripcion) {
        TodoList todoList = this.repository.getTodoList(listId);
        TodoItem todoItem = new TodoItem(descripcion);
        todoList.addItem(todoItem);
        this.repository.saveTodoList(todoList);
        return todoList;
    }
}
