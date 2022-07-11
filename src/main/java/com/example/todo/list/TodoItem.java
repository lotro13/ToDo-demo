package com.example.todo.list;

import com.example.todo.flow.TodoStore;
import com.example.todo.list.state.TodoElementStatus;
import com.example.todo.list.state.TodoListElement;
import javafx.css.PseudoClass;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import static javafx.scene.input.MouseEvent.MOUSE_CLICKED;

public class TodoItem extends HBox {

    private static PseudoClass DONE_PSEUDO_CLASS = PseudoClass.getPseudoClass("done");


    private final TodoStore store = TodoStore.getInstance();

    public TodoItem(TodoListElement element) {
        getStyleClass().add("todo-item");

        final var bodyLabel = new Label(element.getBody());
        final var hBox = new HBox(bodyLabel);
        hBox.getStyleClass().add("body");
        hBox.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(hBox, Priority.ALWAYS);

        final var isDone = element.getStatus().equals(TodoElementStatus.DONE);

        pseudoClassStateChanged(DONE_PSEUDO_CLASS, isDone);

        final var checkBox = new CheckBox();
        checkBox.selectedProperty().set(isDone);
        checkBox.addEventHandler(MOUSE_CLICKED, e -> {
            final var oldState = store.getState();
            final var newState = oldState.toggleTodo(element.getId());
            store.setState(newState);
        });

        getChildren().addAll(
                checkBox,
                hBox
        );
    }
}
