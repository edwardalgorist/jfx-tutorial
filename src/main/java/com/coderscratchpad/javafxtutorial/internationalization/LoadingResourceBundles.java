package com.coderscratchpad.javafxtutorial.internationalization;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/internationalization-in-javafx-building-multilingual-apps/">coderscratchpad.com</a>
 */
public class LoadingResourceBundles extends Application {

    // The parent layout manager
    private final BorderPane parent = new BorderPane();

    // The resource bundle
    private ResourceBundle bundle;

    @Override
    public void start(Stage stage) throws Exception {

        // Setup and display the stage
        this.setupStage(stage);
    }

    @Override
    public void init() throws Exception {
        super.init();

        // Determine the user's locale, based on user preferences
        Locale locale = Locale.getDefault();

        // Load the appropriate resource bundle
        bundle =  ResourceBundle.getBundle("languages.language", locale);

        // Build the user interface
        this.buildUI();

    }

    private void buildUI() {

        // Create UI components
        Label label = new Label(this.bundle.getString("label"));

        // Add the Label to the center of the BorderPane
        this.parent.setCenter(label);

    }

    private void setupStage(Stage stage) {

        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle(this.bundle.getString("title"));

        // Set the scene for the stage
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Display the stage
        stage.show();

    }

}