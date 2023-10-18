package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/introduction-to-javafx-creating-a-basic-gui-application/">coderscratchpad.com</a>
 */
public class BasicGui extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    @Override
    public void start(Stage stage) {

        BorderPane layoutManager = new BorderPane();
        Scene scene = new Scene(layoutManager, WIDTH, HEIGHT);

        stage.setTitle("Introduction to JavaFX: Creating a Basic GUI Application");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

}
