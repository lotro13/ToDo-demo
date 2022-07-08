package com.example.todo;

import com.example.todo.flow.Observer;
import com.example.todo.flow.TodoStore;
import com.example.todo.list.TodoCreationItem;
import com.example.todo.list.TodoList;
import com.example.todo.list.state.TodoListState;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainWindow extends StackPane implements Observer {

    private final TodoList todoList;

    public MainWindow() {
        setAlignment(Pos.CENTER);

        final var l = new Label("Todo List");
        l.setStyle("-fx-font-size: 2.2em;");

        todoList = new TodoList();
        final var todoCreationItem = new TodoCreationItem();

        final var vBox = new VBox(l, todoList, todoCreationItem);
        VBox.setVgrow(vBox, Priority.ALWAYS);
        vBox.setFillWidth(true);
        vBox.setStyle("-fx-spacing: 0.5em;");
        getChildren().addAll(vBox);
    }

    @Override
    public void update(TodoListState state) {
        todoList.update(state);
    }
}
