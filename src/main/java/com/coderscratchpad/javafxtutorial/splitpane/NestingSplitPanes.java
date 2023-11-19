package com.coderscratchpad.javafxtutorial.splitpane;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-splitpane-a-tool-for-flexible-user-interfaces/">coderscratchpad.com</a>
 */
public class NestingSplitPanes extends Application {

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

        SplitPane outerSplitPane = new SplitPane();
        SplitPane innerSplitPane = new SplitPane();

        VBox topLeftContent = new VBox(new Label("Top Left Pane"));
        VBox topRightContent = new VBox(new Label("Top Right Pane"));

        // Add Top Left and Top Right Contents to the inner SplitPlane
        innerSplitPane.getItems().addAll(topLeftContent, topRightContent);

        VBox bottomContent = new VBox(new Label("Bottom Pane"));

        // Add Bottom Content and the Inner SplitPane to the Outer SplitPlane
        outerSplitPane.getItems().addAll(innerSplitPane, bottomContent);

        // Change the orientation for the Outer SplitPane
        outerSplitPane.setOrientation(Orientation.VERTICAL);

        // Add the SplitPane to the BorderPane layout manager
        this.parent.setCenter(outerSplitPane);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("JavaFX SplitPane: A Tool for Flexible User Interfaces");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}