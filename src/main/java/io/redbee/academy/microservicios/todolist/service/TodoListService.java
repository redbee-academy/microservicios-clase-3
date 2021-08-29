package io.redbee.academy.microservicios.todolist.service;

import io.redbee.academy.microservicios.todolist.model.TodoList;
import io.redbee.academy.microservicios.todolist.model.TodoItem;
import io.redbee.academy.microservicios.todolist.repository.TodoListRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TodoListService {

    TodoListRepository repository;

    TodoListService(TodoListRepository repository) {
        this.repository = repository;
    }

    public TodoList createTodoList() {
        TodoList nuevaTodoList = new TodoList();
        this.repository.saveTodoList(nuevaTodoList);
        return nuevaTodoList;
    }


    public TodoList buscarTodoList(UUID uuid) {
        return this.repository.getTodoList(uuid);
    }

    public void agregarItem(UUID todoListId, TodoItem item) {
        TodoList todoList = this.repository.getTodoList(todoListId);
        todoList.addItem(item);
        this.repository.saveTodoList(todoList);
    }
}
