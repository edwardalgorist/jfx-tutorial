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
public class WorldMapViewSelectingCountries extends Application {

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

        // Set WorldMapView selection mode
        worldMapView.setCountrySelectionMode(WorldMapView.SelectionMode.MULTIPLE);

        // Create a list of selected countries
        ObservableList<WorldMapView.Country> selectedCountries = FXCollections.observableArrayList(
                WorldMapView.Country.ZM
        );

        // Set the list of selected countries on the map
        worldMapView.setSelectedCountries(selectedCountries);

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