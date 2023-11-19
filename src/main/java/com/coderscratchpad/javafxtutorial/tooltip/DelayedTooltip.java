package com.coderscratchpad.javafxtutorial.tooltip;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-tooltip-enhancing-user-interface-with-informative-hints/">coderscratchpad.com</a>
 */
public class DelayedTooltip extends Application {

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

        // Create a Button
        Button button = new Button("Hover Me!");

        // Create a tooltip
        Tooltip tooltip = new Tooltip("This tooltip appears after a 2-second delay");

        // Set the tooltip to show after a 2-second delay
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(e -> Tooltip.install(button, tooltip));
        delay.play();

        // Add the Button to the BorderPane layout manager
        this.parent.setCenter(button);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("JavaFX Tooltip: Enhancing User Interface with Informative Hints");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}