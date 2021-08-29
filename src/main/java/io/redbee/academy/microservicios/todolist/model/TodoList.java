package io.redbee.academy.microservicios.todolist.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TodoList {

    private UUID uuid;
    private List<TodoItem> items;


    public TodoList() {
        this.uuid = UUID.randomUUID();
        this.items = new ArrayList();
    }

    public TodoList(UUID uuid, List<TodoItem> items) {
        this.uuid = uuid;
        this.items = items;
    }

    public TodoList(TodoList todoList) {
        this(todoList.getUuid(), todoList.getItems());
    }

    public UUID getUuid() {
        return uuid;
    }


    public List<TodoItem> getItems() {
        return new ArrayList(this.items);
    }

    public void addItem(TodoItem item) {
        this.items.add(item);
    }
}
