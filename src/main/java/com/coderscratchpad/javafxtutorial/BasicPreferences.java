package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.prefs.Preferences;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-preferences-saving-and-retrieving-user-preferences/">coderscratchpad.com</a>
 */
public class BasicPreferences extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private static final String PREFERENCE_NODE_NAME = "com.coderscratchpad.javafx.preferences";
    private static final String WIDTH_KEY = "width";
    private static final String HEIGHT_KEY = "height";
    private static final String LEFT_KEY = "left";
    private static final String TOP_KEY = "top";

    private double windowWidth;
    private double windowHeight;
    private double windowLeft;
    private double windowTop;

    private final StackPane parent = new StackPane();

    @Override
    public void start(Stage stage) throws Exception {
        this.setupStage(stage);
    }

    private void setupStage(Stage stage) {

        // Load the saved window dimensions and positions
        loadWindowSettings();

        Scene scene = new Scene(this.parent);

        // Sets the stage title
        stage.setTitle("JavaFX Preferences: Saving and Retrieving User Preferences");

        // Sets the stage scene
        stage.setScene(scene);

        // Set the stage size
        stage.setWidth(windowWidth);
        stage.setHeight(windowHeight);

        // Set the stage position
        stage.setX(this.windowLeft);
        stage.setY(this.windowTop);

        // Save the window size and position when the application is closed
        stage.setOnCloseRequest(event -> {

            saveWindowSettings(stage.getWidth(), stage.getHeight(), stage.getX(), stage.getY());

        });

        // Show stage on screen
        stage.show();

    }

    private void loadWindowSettings() {

        Preferences preferences = Preferences.userRoot().node(PREFERENCE_NODE_NAME);

        this.windowWidth = preferences.getDouble(WIDTH_KEY, WIDTH);
        this.windowHeight = preferences.getDouble(HEIGHT_KEY, HEIGHT);
        this.windowLeft = preferences.getDouble(LEFT_KEY, 100.0);
        this.windowTop = preferences.getDouble(TOP_KEY, 100.0);

    }

    private void saveWindowSettings(double width, double height, double left, double top) {

        Preferences preferences = Preferences.userRoot().node(PREFERENCE_NODE_NAME);

        preferences.putDouble(WIDTH_KEY, width);
        preferences.putDouble(HEIGHT_KEY, height);
        preferences.putDouble(LEFT_KEY, left);
        preferences.putDouble(TOP_KEY, top);

    }

}