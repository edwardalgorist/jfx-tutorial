package com.coderscratchpad.javafxtutorial.controlsfx.toggleswitch;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.ToggleSwitch;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/toggleswitch-control-in-javafx-with-controlsfx/">coderscratchpad.com</a>
 */
public class ToggleSwitchStateChanges extends Application {

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

        Label label = new Label("Feature Disabled");

        toggleSwitch.setText("Enable Feature");

        // Attach a listener to the ToggleSwitch
        toggleSwitch.selectedProperty().addListener((observable, oldValue, newValue) -> {

            if (newValue) {
                label.setText("Feature Enabled");
            } else {
                label.setText("Feature Disabled");
            }

        });

        // Add the ToggleSwitch and the Label to the VBox container
        VBox container = new VBox(15, toggleSwitch, label);
        container.setAlignment(Pos.CENTER);

        // Add the container VBox to the BorderPane layout manager
        this.parent.setCenter(container);

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