package io.redbee.academy.microservicios.todolist.repository;

import io.redbee.academy.microservicios.todolist.model.TodoList;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class TodoListRepository {

    private Map<UUID, TodoList> data;

    TodoListRepository() {
        this.data = new HashMap<>();
    }

    public TodoList getTodoList(UUID uuid) {
        TodoList todoList = data.get(uuid);
        if (todoList != null) {
            todoList = new TodoList(todoList);
        }
        return todoList;
    }

    public void saveTodoList(TodoList todoList) {
        data.put(todoList.getUuid(), new TodoList(todoList));
    }
}
