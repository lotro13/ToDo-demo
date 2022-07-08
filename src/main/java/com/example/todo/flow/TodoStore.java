package com.example.todo.flow;

import com.example.todo.list.state.TodoListState;

import java.util.ArrayList;
import java.util.List;

public class TodoStore {
    private static TodoStore instance = new TodoStore();
    private final List<Observer> observers = new ArrayList<>();

    private TodoListState state = new TodoListState();

    private TodoStore() {
    }

    public static TodoStore getInstance() {
        if (instance == null) {
            instance = new TodoStore();
        }
        return instance;
    }

    public void setState(TodoListState state) {
        this.state = state;
        notifyAllObservers();
    }

    public TodoListState getState() {
        return state;
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        observers.forEach(o -> o.update(state));
    }
}
