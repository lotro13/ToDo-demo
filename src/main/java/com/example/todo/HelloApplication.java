package com.example.todo;

import com.example.todo.flow.TodoStore;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        final var todoStore = TodoStore.getInstance();
        final var mainWindow = new MainWindow();
        todoStore.attach(mainWindow);


        Scene scene = new Scene(mainWindow, 320, 240);

        scene.getStylesheets().addAll(
                "/css/main-style.css"
        );

        stage.setTitle("My Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}