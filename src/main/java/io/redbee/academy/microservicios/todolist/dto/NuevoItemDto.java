package io.redbee.academy.microservicios.todolist.dto;

public class NuevoItemDto {

    private String listId;
    private String detalle;

    public NuevoItemDto() {
    }

    public NuevoItemDto(String listId, String detalle) {
        this.listId = listId;
        this.detalle = detalle;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
