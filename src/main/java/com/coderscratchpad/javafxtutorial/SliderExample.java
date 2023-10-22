package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-slider/">coderscratchpad.com</a>
 */
public class SliderExample extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private final StackPane parent = new StackPane();

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
        stage.setTitle("JavaFX Slider");

        // Set the stage scene
        stage.setScene(scene);

        // Center stage on screen
        stage.centerOnScreen();

        // Show stage on screen
        stage.show();

    }

    private void buildUI() {

        // Minimum, Maximum, Initial value
        Slider slider = new Slider(0, 100, 50);

        Label valueLabel = new Label("Current Value: " + slider.getValue());

        // Listen for value changes
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            valueLabel.setText("Current Value: " + newValue.intValue());
        });

        VBox container = new VBox(20, slider, valueLabel);
        container.setAlignment(Pos.CENTER);

        this.parent.getChildren().addAll(container);

    }

}