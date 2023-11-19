package com.coderscratchpad.javafxtutorial.controlsfx.ratingcontrol;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-controlsfx-rating-control/">coderscratchpad.com</a>
 */
public class HandlingRatingControlChanges extends Application {

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

        // Create a Rating Control
        Rating rating = new Rating();

        Label ratingLabel = new Label("Rating: " + rating.getRating());

        // Set the maximum number of stars to 10
        rating.setMax(10);

        rating.ratingProperty().addListener((observable, oldValue, newValue) -> {
            ratingLabel.setText("Rating: " + newValue);
            // Update other parts of your application based on the new rating
        });

        // Add the Rating Control to the VBox
        VBox vbox = new VBox(15, rating, ratingLabel);
        vbox.setAlignment(Pos.CENTER);

        // Add the VBox to the BorderPane layout manager
        this.parent.setCenter(vbox);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("Handling Rating Changes");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}