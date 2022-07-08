package com.example.todo.list.state;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TodoListState {

    public TodoListState() {
        elements = new ArrayList<>();
    }

    public TodoListState(List<TodoListElement> elements) {
        this.elements = elements;
    }

    private final List<TodoListElement> elements;

    public TodoListState addNewTodo(String todo) {
        final var newList = new ArrayList<>(elements);
        newList.add(new TodoListElement(todo));

        return new TodoListState(newList);
    }

    public TodoListState toggleTodo(UUID todoId) {
        final var newList = elements.stream()
                .map(e -> {
                    if (e.getId().equals(todoId)) {
                        return e.toggleSelection();
                    }

                    return e;
                }).collect(Collectors.toList());

        return new TodoListState(newList);
    }

    public List<TodoListElement> getElements() {
        return elements;
    }
}
