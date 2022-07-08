package com.example.todo.list;

import com.example.todo.list.state.TodoListState;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.stream.Collectors;

public class TodoList extends VBox {

    private final VBox bodyBox;

    public TodoList() {
        getStyleClass().add("todo-list");
        VBox.setVgrow(this, Priority.ALWAYS);

        final var scrollPane = new ScrollPane();
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        bodyBox = new VBox();
        bodyBox.setFillWidth(true);
        VBox.setVgrow(bodyBox, Priority.ALWAYS);
        bodyBox.setStyle("-fx-spacing: 0.2em");
        scrollPane.setContent(bodyBox);

        getChildren().add(scrollPane);
    }

    public void update(TodoListState todoListState) {
        final var elements = todoListState.getElements().stream()
                .map(TodoItem::new)
                .collect(Collectors.toList());

        bodyBox.getChildren().setAll(elements);
    }
}
