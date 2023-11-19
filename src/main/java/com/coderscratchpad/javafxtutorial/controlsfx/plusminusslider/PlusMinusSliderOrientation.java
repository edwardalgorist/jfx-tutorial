package com.coderscratchpad.javafxtutorial.controlsfx.plusminusslider;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.*;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-controlsfx-plusminusslider-navigating-with-precision/">coderscratchpad.com</a>
 */
public class PlusMinusSliderOrientation extends Application {

    private final BorderPane parent = new BorderPane();

    @Override
    public void init() throws Exception {
        super.init();
        this.buildUI();
    }

    private void buildUI() {

        // Create the PlusMinusSlider
        PlusMinusSlider horizontalSlider = new PlusMinusSlider();
        horizontalSlider.setOrientation(Orientation.HORIZONTAL);

        PlusMinusSlider verticalSlider = new PlusMinusSlider();
        verticalSlider.setOrientation(Orientation.VERTICAL);

        // Add the PlusMinusSlider to the VBox
        VBox container = new VBox(20, horizontalSlider, verticalSlider);
        container.setAlignment(Pos.CENTER);
        container.setPadding(new Insets(20.0));

        // Add the VBox to the BorderPane
        this.parent.setCenter(container);

    }

    @Override
    public void start(Stage stage) throws Exception {
        this.setupStage(stage);
    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX ControlsFX PlusMinusSlider: Navigating with Precision");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}