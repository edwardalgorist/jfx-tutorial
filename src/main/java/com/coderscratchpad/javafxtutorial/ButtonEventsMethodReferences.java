package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/handling-javafx-button-events/">coderscratchpad.com</a>
 */
public class ButtonEventsMethodReferences extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {
        this.setupStage(stage);
    }

    @Override
    public void init() throws Exception {
        super.init();
        this.buildUI();
    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("Handling JavaFX Button Events");

        // Sets the stage scene
        stage.setScene(scene);

        // Centers stage on screen
        stage.centerOnScreen();

        // Show stage on screen
        stage.show();

    }

    private void buildUI() {

        Button button = new Button("Exit");

        button.setOnAction(this::onExit);

        this.parent.setCenter(button);

    }

    private void onExit(ActionEvent actionEvent) {

        // Call Platform.exit() to close the JavaFX application
        Platform.exit();

    }

}
