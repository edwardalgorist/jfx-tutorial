package com.coderscratchpad.javafxtutorial.fontawesomeicons;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/fontawesome-icons-in-javafx-with-fontawesomefx/">coderscratchpad.com</a>
 */
public class BasicFontAwesomeIcons extends Application {

    private final BorderPane parent = new BorderPane();

    @Override
    public void init() throws Exception {
        super.init();

        // Build the user interface
        this.buildUI();

    }

    private void buildUI() {

        // Create FontAwesome icons
        FontAwesomeIconView androidIcon = new FontAwesomeIconView(FontAwesomeIcon.ANDROID);
        FontAwesomeIconView googleIcon = new FontAwesomeIconView(FontAwesomeIcon.GOOGLE);
        FontAwesomeIconView windowsIcon = new FontAwesomeIconView(FontAwesomeIcon.WINDOWS);
        FontAwesomeIconView appleIcon = new FontAwesomeIconView(FontAwesomeIcon.APPLE);
        FontAwesomeIconView amazonIcon = new FontAwesomeIconView(FontAwesomeIcon.AMAZON);

        // Set the icon size
        String iconSize = "50px";

        androidIcon.setSize(iconSize);
        googleIcon.setSize(iconSize);
        windowsIcon.setSize(iconSize);
        appleIcon.setSize(iconSize);
        amazonIcon.setSize(iconSize);

        // Create a VBox container to hold the icons with spacing
        VBox iconContainer = new VBox(10, androidIcon, googleIcon, windowsIcon, appleIcon, amazonIcon);
        iconContainer.setAlignment(Pos.CENTER);

        // Add the VBox icon container to the center of the BorderPane
        this.parent.setCenter(iconContainer);

    }

    @Override
    public void start(Stage stage) throws Exception {

        // Setup and display the stage
        this.setupStage(stage);

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