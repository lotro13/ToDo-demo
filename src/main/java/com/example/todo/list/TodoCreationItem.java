package com.example.todo.list;

import com.example.todo.flow.TodoStore;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import static javafx.scene.input.MouseEvent.MOUSE_CLICKED;

public class TodoCreationItem extends HBox {

    public TodoCreationItem() {
        getStyleClass().add("todo-creation-item");
        setSpacing(7);

        final var textField = new TextField();
        textField.setPromptText("Todo goes here");
        final var hBox = new HBox(textField);
        HBox.setHgrow(hBox, Priority.ALWAYS);

        final var addItemButton = new AddItemButton();

        final var store = TodoStore.getInstance();
        addItemButton.addEventHandler(MOUSE_CLICKED, (e) -> {
            final var userText = textField.getText();
            if (!userText.equals("")) {
                textField.clear();
                final var newState = store.getState()
                        .addNewTodo(userText);
                store.setState(newState);
            }
        });

        getChildren().addAll(
                hBox,
                addItemButton
        );
    }
}
