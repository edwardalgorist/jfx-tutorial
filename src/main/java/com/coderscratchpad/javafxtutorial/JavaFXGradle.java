package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-with-gradle/">coderscratchpad.com</a>
 */
public class JavaFXGradle extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("JavaFX with Gradle");

        Label label = new Label("Hello, JavaFX!");

        StackPane root = new StackPane(label);

        Scene scene = new Scene(root, 640, 480);

        primaryStage.setScene(scene);

        primaryStage.show();

    }

}