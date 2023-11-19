package com.coderscratchpad.javafxtutorial.controlsfx.toggleswitch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.ToggleSwitch;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/toggleswitch-control-in-javafx-with-controlsfx/">coderscratchpad.com</a>
 */
public class BasicToggleSwitch extends Application {

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

        ToggleSwitch toggleSwitch = new ToggleSwitch();

        toggleSwitch.setText("Enable Feature");

        // Enable feature
        toggleSwitch.setSelected(true);

        // Add the ToggleSwitch to the BorderPane layout manager
        this.parent.setCenter(toggleSwitch);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 800, 600);

        // Set the stage title
        stage.setTitle("ToggleSwitch Control");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}