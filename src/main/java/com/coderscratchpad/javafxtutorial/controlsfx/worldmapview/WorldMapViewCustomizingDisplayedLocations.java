package com.coderscratchpad.javafxtutorial.controlsfx.worldmapview;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.WorldMapView;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-controlsfx-worldmapview/">coderscratchpad.com</a>
 */
public class WorldMapViewCustomizingDisplayedLocations extends Application {

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

        // Create the WorldMapView
        WorldMapView worldMapView = new WorldMapView();

        // Set background color to transparent
        worldMapView.setStyle("-fx-background-color: transparent;");

        // Set whether to show locations
        worldMapView.setShowLocations(true);

        // Create a list of locations
        ObservableList<WorldMapView.Location> locations = FXCollections.observableArrayList();
        locations.add(new WorldMapView.Location("New York", 40.712776, -74.005974));
        locations.add(new WorldMapView.Location("London", 51.5074, -0.1278));
        locations.add(new WorldMapView.Location("Tokyo", 35.6895, 139.6917));

        // Set the list of locations on the map
        worldMapView.setLocations(locations);

        // Add the WorldMapView to the BorderPane
        this.parent.setCenter(worldMapView);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX ControlsFX WorldMapView");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}