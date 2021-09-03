package io.redbee.academy.microservicios.todolist.dto;

public class ItemAccionDto {

    private String listId;
    private String itemId;

    public ItemAccionDto() {
    }

    public ItemAccionDto(String listId, String itemId) {
        this.listId = listId;
        this.itemId = itemId;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
