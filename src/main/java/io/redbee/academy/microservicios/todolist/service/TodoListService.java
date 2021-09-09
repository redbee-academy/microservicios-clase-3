package io.redbee.academy.microservicios.todolist.service;

import io.redbee.academy.microservicios.todolist.model.TodoList;

public interface TodoListService {
    TodoList nuevaTodoList();

    TodoList buscarLista(String listId);

    TodoList agregarItem(String listId, String descripcion);

    TodoList cambiarEstadoItem(String listId, String itemId);

    TodoList eliminarItem(String listId, String itemId);
}
