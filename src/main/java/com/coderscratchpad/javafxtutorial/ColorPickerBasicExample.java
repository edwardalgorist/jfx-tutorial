package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-colorpicker/">coderscratchpad.com</a>
 */
public class ColorPickerBasicExample extends Application {

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

        // Set the stage title
        stage.setTitle("JavaFX ColorPickers");

        // Sets the stage scene
        stage.setScene(scene);

        // Centers stage on screen
        stage.centerOnScreen();

        // Show stage on screen
        stage.show();

    }

    private void buildUI() {

        // Create a new ColorPicker
        ColorPicker colorPicker = new ColorPicker();

        colorPicker.setOnAction(this::onColorPicked);

        parent.getChildren().add(colorPicker);

    }

    private void onColorPicked(ActionEvent actionEvent) {

        // Gets the color picker
        ColorPicker colorPicker = (ColorPicker) actionEvent.getSource();

        // Gets the selected color
        Color selectedColor = colorPicker.getValue();

        // Convert the selected color to its RGB hexadecimal representation
        String RGB = toRGBCode(selectedColor);

        this.parent.setStyle(String.format("-fx-background-color: %s;", RGB));

    }

    private String toRGBCode(Color color) {

        return String.format(
                "#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255)
        );

    }

}
