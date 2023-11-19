package com.coderscratchpad.javafxtutorial.flowpane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-flowpane-designing-responsive-interfaces/">coderscratchpad.com</a>
 */
public class FlowPaneAlignmentAndMargin extends Application {

    private final FlowPane parent = new FlowPane();

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

        // Horizontal gap between nodes
        this.parent.setHgap(10);

        // Vertical gap between nodes
        this.parent.setVgap(10);

        // Create and add UI elements to the FlowPane
        for (int i = 1; i <= 10; i++) {

            Button button = new Button("Button " + i);
            this.parent.getChildren().add(button);

            // Set a margin of 10 pixels
            FlowPane.setMargin(button, new Insets(10));

        }

        // Align children at the center
        this.parent.setAlignment(Pos.CENTER);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX FlowPane: Designing Responsive Interfaces");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}