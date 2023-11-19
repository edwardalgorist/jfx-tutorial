package com.coderscratchpad.javafxtutorial.tooltip;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-tooltip-enhancing-user-interface-with-informative-hints/">coderscratchpad.com</a>
 */
public class TooltipCustomizingAppearance extends Application {

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

        // Create a Tooltip and set its content
        Tooltip tooltip = new Tooltip("Hello, I am a Tooltip!");

        // Customize the appearance of the Tooltip
        tooltip.setStyle("-fx-background-color: #336699; -fx-text-fill: white; -fx-font-size: 14px;");

        // Associate the Tooltip with the Button
        button.setTooltip(tooltip);

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
