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
public class SplitPaneOrientation extends Application {

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

        SplitPane splitPane = new SplitPane();

        // Set the orientation for the SplitPane
        splitPane.setOrientation(Orientation.VERTICAL);

        VBox topContent = new VBox(new Label("Top Pane"));
        VBox bottomContent = new VBox(new Label("Bottom Pane"));

        splitPane.getItems().addAll(topContent, bottomContent);

        // Add the SplitPane to the BorderPane layout manager
        this.parent.setCenter(splitPane);

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