package com.example.todo.flow;

import com.example.todo.list.state.TodoListState;

public interface Observer {
    void update(TodoListState state);
}
