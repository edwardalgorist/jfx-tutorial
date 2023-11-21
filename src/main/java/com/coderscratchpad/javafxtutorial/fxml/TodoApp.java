package com.coderscratchpad.javafxtutorial.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-and-fxml-separating-ui-from-logic/">coderscratchpad.com</a>
 */
public class TodoApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Setup and display the stage
        this.setupStage(stage);
    }

    private void setupStage(Stage stage) throws IOException {

        URL fxml = this.getClass().getResource("/fxml/todo.fxml");

        VBox parent = FXMLLoader.load(fxml);

        // Create a scene with the VBox as the root
        Scene scene = new Scene(parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX and FXML: Separating UI from Logic");

        // Set the scene for the stage
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Display the stage
        stage.show();

    }

}