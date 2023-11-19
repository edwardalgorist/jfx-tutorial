package com.coderscratchpad.javafxtutorial.controlsfx.plusminusslider;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.*;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-controlsfx-plusminusslider-navigating-with-precision/">coderscratchpad.com</a>
 */
public class BasicPlusMinusSlider extends Application {

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

        // Create the PlusMinusSlider
        PlusMinusSlider plusMinusSlider = new PlusMinusSlider();

        // Create the ListView
        ListView<String> listView = new ListView<>();

        // Populate the list with sample items
        for (int i = 1; i <= 20; i++) {
            listView.getItems().add("Item " + i);
        }

        // Attach a listener to the PlusMinusSlider value changes
        plusMinusSlider.valueProperty().addListener((observable, oldValue, newValue) -> {

            // Calculate the offset based on the PlusMinusSlider value
            // Adjust the multiplier as needed
            int offset = (int) (newValue.doubleValue() * 10);

            // Scroll the ListView by the calculated offset
            int currentIndex = listView.getSelectionModel().getSelectedIndex();
            int newIndex = currentIndex + offset;

            // Ensure the new index is within valid bounds
            if (newIndex >= 0 && newIndex < listView.getItems().size()) {
                listView.getSelectionModel().select(newIndex);
            }

        });

        // Add the PlusMinusSlider and ListView to the BorderPane
        this.parent.setTop(plusMinusSlider);
        this.parent.setCenter(listView);

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