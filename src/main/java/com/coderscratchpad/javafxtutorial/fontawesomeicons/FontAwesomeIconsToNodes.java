package com.coderscratchpad.javafxtutorial.fontawesomeicons;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/fontawesome-icons-in-javafx-with-fontawesomefx/">coderscratchpad.com</a>
 */
public class FontAwesomeIconsToNodes extends Application {

    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        // Setup and display the stage
        this.setupStage(stage);

    }

    @Override
    public void init() throws Exception {
        super.init();

        // Build the user interface
        this.buildUI();

    }

    private void buildUI() {

        // Create FontAwesome icon
        FontAwesomeIconView androidIcon = new FontAwesomeIconView(FontAwesomeIcon.ANDROID);

        // Create the Label
        Label label = new Label("Android");

        // Set the icon as the graphic
        label.setGraphic(androidIcon);

        // Increase the Label font size
        label.setStyle("-fx-font-size: 16px");

        // Add the Label to the center of the BorderPane
        this.parent.setCenter(label);

    }

    private void setupStage(Stage stage) {

        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("FontAwesome Icons in JavaFX with FontAwesomeFX");

        // Set the scene for the stage
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Display the stage
        stage.show();

    }

}