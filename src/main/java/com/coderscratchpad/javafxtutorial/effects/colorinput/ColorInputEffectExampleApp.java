package com.coderscratchpad.javafxtutorial.effects.colorinput;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.ColorInput;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-colorinput-effect/">coderscratchpad.com</a>
 */
public class ColorInputEffectExampleApp extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    /* The parent layout manager */
    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("ColorInput Effect");

        // Set the stage scene
        stage.setScene(scene);

        // Center stage on screen
        stage.centerOnScreen();

        // Show stage on screen
        stage.show();

    }

    @Override
    public void init() throws Exception {
        super.init();

        // Create the ColorInputEffect
        ColorInput colorInput = new ColorInput();

        // Create a rectangle to apply the effect to
        Rectangle rectangle = new Rectangle(280, 280);

        // Apply the ColorInput Effect to the Rectangle
        rectangle.setEffect(colorInput);

        // Create the Control Panel for the ColorInput
        ColorInputControlPanel controlPanel = new ColorInputControlPanel(
                colorInput, rectangle.getWidth(), rectangle.getHeight()
        );

        /* Add the Rectangle to the BorderPane center region */
        this.parent.setCenter(rectangle);
        BorderPane.setAlignment(rectangle, Pos.CENTER_LEFT);
        BorderPane.setMargin(rectangle, new Insets(20));

        /* Add the ColorInputControlPanel to the BorderPane left region */
        this.parent.setLeft(controlPanel);
    }
}