package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-with-apache-maven/">coderscratchpad.com</a>
 */
public class JavaFXApacheMaven extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("JavaFX with Apache Maven");

        Label label = new Label("Hello, JavaFX!");

        StackPane root = new StackPane(label);

        stage.setScene(new Scene(root, 300, 200));

        stage.show();

    }

}