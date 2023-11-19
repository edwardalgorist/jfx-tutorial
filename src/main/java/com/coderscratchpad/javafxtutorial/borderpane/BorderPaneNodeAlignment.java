package com.coderscratchpad.javafxtutorial.borderpane;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-borderpane-desinging-with-divisions/">coderscratchpad.com</a>
 */
public class BorderPaneNodeAlignment extends Application {

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

        // Create nodes for each region
        Label header = new Label("Header");
        Label leftSidebar = new Label("Left Sidebar");
        Label content = new Label("Main Content");
        Label rightSidebar = new Label("Right Sidebar");
        Label footer = new Label("Footer");

        // Set nodes in respective regions
        this.parent.setTop(header);
        this.parent.setLeft(leftSidebar);
        this.parent.setCenter(content);
        this.parent.setRight(rightSidebar);
        this.parent.setBottom(footer);

        // Customize alignment of regions
        BorderPane.setAlignment(header, Pos.CENTER);
        BorderPane.setAlignment(leftSidebar, Pos.CENTER);
        BorderPane.setAlignment(content, Pos.CENTER);
        BorderPane.setAlignment(rightSidebar, Pos.CENTER);
        BorderPane.setAlignment(footer, Pos.CENTER);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX BorderPane: Designing With Divisions");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}