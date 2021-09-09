package io.redbee.academy.microservicios.todolist.model;

import java.util.Objects;
import java.util.UUID;

public class TodoItem {

    private final String id;
    private String descripcion;
    private Boolean finalizada;

    public TodoItem(String descripcion) {
        this.id = UUID.randomUUID().toString();
        this.descripcion = descripcion;
        this.finalizada = false;
    }

    public String getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(Boolean finalizada) {
        this.finalizada = finalizada;
    }

    public void cambiarFinalizada() {
        this.finalizada = !this.finalizada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return id.equals(todoItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
