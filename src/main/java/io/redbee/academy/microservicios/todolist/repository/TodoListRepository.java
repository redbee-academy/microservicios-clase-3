package io.redbee.academy.microservicios.todolist.repository;

import io.redbee.academy.microservicios.todolist.model.TodoList;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TodoListRepository {

    private Map<String, TodoList> data;

    TodoListRepository() {
        this.data = new HashMap<>();
    }

    public TodoList getTodoList(String id) {
        TodoList todoList = data.get(id);
        if (todoList != null) {
            todoList = new TodoList(todoList);
        }
        return todoList;
    }

    public void saveTodoList(TodoList todoList) {
        data.put(todoList.getId(), new TodoList(todoList));
    }
}
