package com.coderscratchpad.javafxtutorial.anchorpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-anchorpane-anchoring-your-ui/">coderscratchpad.com</a>
 */
public class FloatingActionButton extends Application {

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

        Button fabButton = new Button("+");

        fabButton.getStyleClass().add("fab-button");

        AnchorPane.setBottomAnchor(fabButton, 20.0);
        AnchorPane.setRightAnchor(fabButton, 20.0);

        Label counter = new Label("Counter: 0");

        counter.setStyle("-fx-font-size: 18px; -fx-text-fill: #f00");

        AnchorPane.setTopAnchor(counter, 220.0);
        AnchorPane.setLeftAnchor(counter, 300.0);

        fabButton.setOnAction(actionEvent -> {

            // Update counter Label
            int value= Integer.parseInt(counter.getText().split(" ")[1]);
            counter.setText("Counter: " + (value + 1));

        });

        this.parent.getChildren().addAll(counter, fabButton);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Load CSS for styling
        scene.getStylesheets().add("styles.css");

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