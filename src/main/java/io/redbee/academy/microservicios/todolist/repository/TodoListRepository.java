package io.redbee.academy.microservicios.todolist.repository;

import io.redbee.academy.microservicios.todolist.model.TodoList;

public interface TodoListRepository {

    TodoList getTodoList(String id);

    void saveTodoList(TodoList todoList);
}
