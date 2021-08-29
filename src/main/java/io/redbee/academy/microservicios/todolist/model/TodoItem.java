package io.redbee.academy.microservicios.todolist.model;

import java.util.Objects;
import java.util.UUID;

public class TodoItem {

    private UUID uuid;
    private String detalle;
    private Boolean finalizada;

    TodoItem(String detalle) {
        this.uuid = UUID.randomUUID();
        this.detalle = detalle;
        this.finalizada = false;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getDetalle() {
        return  detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(Boolean finalizada) {
        this.finalizada = finalizada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return uuid.equals(todoItem.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
