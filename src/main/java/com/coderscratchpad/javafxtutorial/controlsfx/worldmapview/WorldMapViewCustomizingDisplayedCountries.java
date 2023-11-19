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
public class WorldMapViewCustomizingDisplayedCountries extends Application {

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

        // Create a list of countries to be displayed
        ObservableList<WorldMapView.Country> selectedCountries = FXCollections.observableArrayList(
                WorldMapView.Country.ZM, // Zambia
                WorldMapView.Country.ZW, // Zimbabwe
                WorldMapView.Country.MW, // Malawi
                WorldMapView.Country.BW, // Botswana
                WorldMapView.Country.NA, // Namibia
                WorldMapView.Country.TZ, // Tanzania
                WorldMapView.Country.MZ, // Mozambique
                WorldMapView.Country.AO, // Angola
                WorldMapView.Country.CD  // Congo
        );

        // Set the list of selected countries to be displayed on the map
        worldMapView.setCountries(selectedCountries);

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