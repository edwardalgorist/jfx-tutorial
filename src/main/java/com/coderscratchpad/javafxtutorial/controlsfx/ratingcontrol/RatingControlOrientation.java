package com.coderscratchpad.javafxtutorial.controlsfx.ratingcontrol;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-controlsfx-rating-control/">coderscratchpad.com</a>
 */
public class RatingControlOrientation extends Application {

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

        // Create a Horizontal Rating Control
        Rating hrating = new Rating();
        hrating.setOrientation(Orientation.HORIZONTAL);

        // Create a Vertical Rating Control
        Rating vrating = new Rating();
        vrating.setOrientation(Orientation.VERTICAL);

        // Add the Rating Controls to the VBox
        VBox vbox = new VBox(30, hrating, vrating);
        vbox.setAlignment(Pos.CENTER);

        // Add the VBox to the BorderPane layout manager
        this.parent.setCenter(vbox);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("Customizing the Rating Control: Orientation");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}