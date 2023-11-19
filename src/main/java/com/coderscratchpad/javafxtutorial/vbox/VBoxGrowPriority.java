package com.coderscratchpad.javafxtutorial.vbox;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-vbox-building-vertical-layouts/">coderscratchpad.com</a>
 */
public class VBoxGrowPriority extends Application {

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

        // Create the VBox container
        VBox content = new VBox();

        // Set alignment to center
        content.setAlignment(Pos.CENTER);

        // Set 10px spacing between nodes
        content.setSpacing(10);

        // Add 10 pixels of padding around the VBox
        content.setPadding(new Insets(10));

        // Create UI elements
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");

        // Set grow priorities
        VBox.setVgrow(button1, Priority.ALWAYS);
        button1.setMaxHeight(Double.MAX_VALUE);

        VBox.setVgrow(button2, Priority.SOMETIMES);
        button2.setMaxHeight(Double.MAX_VALUE);

        // Add buttons to VBox
        content.getChildren().addAll(button1, button2, button3);

        this.parent.setCenter(content);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX VBox: Building Vertical Layouts");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}