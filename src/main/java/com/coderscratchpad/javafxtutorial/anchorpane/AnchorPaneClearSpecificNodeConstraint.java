package com.coderscratchpad.javafxtutorial.anchorpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-anchorpane-anchoring-your-ui/">coderscratchpad.com</a>
 */
public class AnchorPaneClearSpecificNodeConstraint extends Application {

    private final AnchorPane parent = new AnchorPane();

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

        Button button = new Button("Click Me!");

        AnchorPane.setTopAnchor(button, 50.0);
        AnchorPane.setLeftAnchor(button, 100.0);

        Button clearButton = new Button("Clear Constraints");

        // Set action for clear Constraints button
        clearButton.setOnAction(event -> {

            // Clear Top and Bottom anchors
            AnchorPane.setTopAnchor(button, null);
            AnchorPane.setBottomAnchor(button, null);

        });

        this.parent.getChildren().addAll(button, clearButton);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX AnchorPane: Anchoring Your UI");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}