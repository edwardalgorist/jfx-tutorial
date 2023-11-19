package com.coderscratchpad.javafxtutorial.controlsfx.worldmapview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.controlsfx.control.WorldMapView;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-controlsfx-worldmapview/">coderscratchpad.com</a>
 */
public class WorldMapViewCustomizingCountryViewFactory extends Application {

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

        // Create a custom country view factory
        Callback<WorldMapView.Country, WorldMapView.CountryView> countryViewFactory = country -> {

            WorldMapView.CountryView customView = new WorldMapView.CountryView(country);

            // Set a custom fill color
            customView.setFill(Color.GREEN);

            // Set a custom stroke color
            customView.setStroke(Color.BLACK);

            return customView;

        };

        // Set the custom country view factory
        worldMapView.setCountryViewFactory(countryViewFactory);

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