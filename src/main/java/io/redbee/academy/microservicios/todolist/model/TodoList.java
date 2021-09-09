package io.redbee.academy.microservicios.todolist.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TodoList {

    private final String id;
    private final List<TodoItem> items;


    public TodoList() {
        this.id = UUID.randomUUID().toString();
        this.items = new ArrayList<>();
    }

    public TodoList(String id, List<TodoItem> items) {
        this.id = id;
        this.items = items;
    }

    public TodoList(TodoList todoList) {
        this(todoList.getId(), todoList.getItems());
    }

    public String getId() {
        return id;
    }


    public List<TodoItem> getItems() {
        return new ArrayList<>(this.items);
    }

    public void addItem(TodoItem item) {
        this.items.add(item);
    }
}
