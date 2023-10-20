package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/getting-started-with-javafx-buttons/">coderscratchpad.com</a>
 */
public class ButtonBasicExample extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private Scene scene;

    private Label label;

    @Override
    public void start(Stage stage) throws Exception {

        // set the scene for the stage
        stage.setScene(this.scene);
        stage.setTitle("Getting Started with JavaFX Buttons");
        stage.centerOnScreen();
        stage.show();

    }

    @Override
    public void init() throws Exception {
        super.init();
        buildUI();
    }

    private void buildUI() {

        // create the main content pane
        VBox mainContent = new VBox(10);
        mainContent.setAlignment(Pos.CENTER);

        // create button
        Button button = new Button("Button");

        this.label = new Label("I dare you to click on the button!");

        // setting a button handler
        button.setOnAction(this::buttonHandler);

        // add label and button to the main content pane
        mainContent.getChildren().addAll(this.label, button);

        // Create the layout manager using BorderPane
        BorderPane layoutManager = new BorderPane(mainContent);

        // create the scene with specified dimensions
        this.scene = new Scene(layoutManager, WIDTH, HEIGHT);

    }

    // button handler
    private void buttonHandler(ActionEvent actionEvent) {
        this.label.setText("Oh, you just did. I am offended!");
    }

}

