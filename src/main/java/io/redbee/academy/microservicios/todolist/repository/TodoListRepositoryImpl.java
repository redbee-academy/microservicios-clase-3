package io.redbee.academy.microservicios.todolist.repository;

import io.redbee.academy.microservicios.todolist.model.TodoList;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TodoListRepositoryImpl implements TodoListRepository {

    private final Map<String, TodoList> data;

    TodoListRepositoryImpl() {
        this.data = new HashMap<>();
    }

    @Override
    public TodoList getTodoList(String id) {
        TodoList todoList = data.get(id);
        if (todoList != null) {
            todoList = new TodoList(todoList);
        }
        return todoList;
    }

    @Override
    public void saveTodoList(TodoList todoList) {
        data.put(todoList.getId(), new TodoList(todoList));
    }
}
