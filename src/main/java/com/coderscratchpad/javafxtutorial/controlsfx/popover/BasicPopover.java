package com.coderscratchpad.javafxtutorial.controlsfx.popover;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.PopOver;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-popover-enhancing-ui-with-contextual-information/">coderscratchpad.com</a>
 */
public class BasicPopover extends Application {

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

    private void buildUI() {

        Button button = new Button("Show Popover");

        PopOver popover = new PopOver(new Label("Hello, I'm a Popover!"));

        button.setOnAction(e -> popover.show(button));

        // Add the Button to the BorderPane layout manager
        this.parent.setCenter(button);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("JavaFX Popover: Enhancing UI with Contextual Information");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}