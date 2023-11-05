package com.coderscratchpad.javafxtutorial.effects;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * This JavaFX application demonstrates the Blend Effect as described in the tutorial on
 * <a href="https://coderscratchpad.com/javafx-blend-effect/">coderscratchpad.com</a>.
 */
public class BlendEffect extends Application {

    // Application properties
    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;
    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        // Create the main application scene
        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Set the title for the application window
        stage.setTitle("Blend Effect");

        // Set the scene for the stage
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();

        // Create Rectangle Nodes
        Rectangle rectangle = new Rectangle(50, 50, 300, 300);
        rectangle.setFill(Color.CORNFLOWERBLUE); // Set the Rectangle Fill color

        Blend blend = new Blend();
        blend.setOpacity(0.8); // Set the Blend Opacity to 0.8

        // Create the ColorInput Effect
        ColorInput colorInput = new ColorInput(0, 0, 160, 150, Color.MEDIUMPURPLE);
        blend.setTopInput(colorInput); // Set the ColorInput as the Blend Top Input

        // Create the SepiaTone Effect
        SepiaTone sepiaTone = new SepiaTone();

        // Set the SepiaTone as the Blend Bottom Input
        blend.setBottomInput(sepiaTone);

        // Apply the Blend Effect to the Rectangle
        rectangle.setEffect(blend);

        // Add the Rectangle to the center region of the BorderPane
        this.parent.setCenter(rectangle);

        // Add the BlendModePanel to the left region of the BorderPane
        this.parent.setLeft(new BlendModePanel(blend));

    }

    static class BlendModePanel extends HBox {

        public BlendModePanel(Blend blend) {
            super(5);

            // Create BlendModes Collection
            ObservableList<BlendMode> blendModes = FXCollections.observableArrayList(
                    BlendMode.values()
            );

            // Create BlendMode ComboBox and provide the available BlendModes
            ComboBox<BlendMode> blendModeComboBox = new ComboBox<>(blendModes);
            blendModeComboBox.getSelectionModel().selectFirst(); // Select the first BlendMode

            // Bind the Blend modeProperty to the ComboBox valueProperty
            blend.modeProperty().bind(blendModeComboBox.valueProperty());

            // Create the HBox to arrange the Label and BlendMode ComboBox
            this.getChildren().addAll(
                    new Label(String.format("%-13s", "Blend Mode")),
                    blendModeComboBox
            );

            this.setPadding(new Insets(20));
            this.setAlignment(Pos.CENTER_LEFT);

        }

    }

}