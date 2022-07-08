package com.example.todo.list;

import javafx.scene.control.Button;

public class AddItemButton extends Button {

    public AddItemButton() {
        getStyleClass().add("add-item-button");
        setText("Add Item");
    }
}
