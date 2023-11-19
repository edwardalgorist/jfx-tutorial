package com.coderscratchpad.javafxtutorial.controlsfx.ratingcontrol;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-controlsfx-rating-control/">coderscratchpad.com</a>
 */
public class RatingControlPartialRating extends Application {

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

        // Set the maximum number of stars to 10
        rating.setMax(10);

        // Enable partial rating
        rating.setPartialRating(true);

        // Add the Rating Control to the VBox
        VBox vbox = new VBox(rating);
        vbox.setAlignment(Pos.CENTER);

        // Add the VBox to the BorderPane layout manager
        this.parent.setCenter(vbox);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("Enable Partial Rating");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}