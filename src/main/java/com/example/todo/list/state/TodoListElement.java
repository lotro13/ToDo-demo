package com.example.todo.list.state;

import java.util.UUID;

public class TodoListElement {
    private final UUID id;
    private final String body;
    private final TodoElementStatus status;

    public TodoListElement(String body) {
        this.id = UUID.randomUUID();
        this.body = body;
        this.status = TodoElementStatus.TODO;
    }

    public TodoListElement(UUID uuid, String body, TodoElementStatus status) {
        this.id = uuid;
        this.body = body;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public TodoElementStatus getStatus() {
        return status;
    }

    public TodoListElement toggleSelection() {
        if (status.equals(TodoElementStatus.TODO)) {
            return new TodoListElement(id, body, TodoElementStatus.DONE);
        }

        return new TodoListElement(id, body, TodoElementStatus.TODO);
    }
}
