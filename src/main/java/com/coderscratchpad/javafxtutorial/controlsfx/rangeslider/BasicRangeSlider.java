package com.coderscratchpad.javafxtutorial.controlsfx.rangeslider;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.*;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-controlsfx-rangeslider-enhancing-range-selection/">coderscratchpad.com</a>
 */
public class BasicRangeSlider extends Application {

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

        // Create the RangeSlider
        RangeSlider rangeSlider = new RangeSlider(0, 100, 20, 80);

        rangeSlider.setBlockIncrement(5);
        rangeSlider.setShowTickLabels(true);
        rangeSlider.setShowTickMarks(true);

        // Add a 10px padding to the BorderPane
        this.parent.setPadding(new Insets(10));

        // Add the RangeSlider to the BorderPane
        this.parent.setCenter(rangeSlider);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX ControlsFX RangeSlider: Enhancing Range Selection");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}