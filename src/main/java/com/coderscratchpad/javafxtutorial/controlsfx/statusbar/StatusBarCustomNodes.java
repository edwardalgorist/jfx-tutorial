package com.coderscratchpad.javafxtutorial.controlsfx.statusbar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.StatusBar;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-controlsfx-statusbar/">coderscratchpad.com</a>
 */
public class StatusBarCustomNodes extends Application {

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

        StatusBar statusBar = new StatusBar();

        Label customLabel = new Label("Custom Content:");

        ImageView customIcon = new ImageView(new Image("java.png"));

        statusBar.getLeftItems().addAll(customLabel, customIcon);

        // Add the StatusBar to the BorderPane layout manager
        this.parent.setBottom(statusBar);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX ControlsFX StatusBar");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}