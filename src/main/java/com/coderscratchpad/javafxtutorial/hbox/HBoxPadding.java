package com.coderscratchpad.javafxtutorial.hbox;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-hbox-building-horizontal-layouts/">coderscratchpad.com</a>
 */
public class HBoxPadding extends Application {

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

        // Create an HBox container
        HBox content = new HBox();

        // Set alignment to center
        content.setAlignment(Pos.CENTER);

        // Set spacing between nodes
        content.setSpacing(20);

        // Add 10 pixels of padding around the HBox
        content.setPadding(new Insets(10));

        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");

        // Add buttons to HBox
        content.getChildren().addAll(button1, button2);

        this.parent.setCenter(content);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX HBox: Building Horizontal Layouts");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}