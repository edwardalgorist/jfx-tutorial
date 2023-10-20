package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/getting-started-with-javafx-checkboxes/">coderscratchpad.com</a>
 */
public class CheckBoxBasicExample extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private Scene scene;

    @Override
    public void start(Stage stage) throws Exception {

        // set the scene for the stage
        stage.setScene(this.scene);

        stage.setTitle("Getting Started with JavaFX CheckBoxes");

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
        Button button = new Button("Install Software");

        // disable button
        button.setDisable(true);

        CheckBox checkBox = new CheckBox("I agree to the license and terms.");

        // set check box change listener
        checkBox.selectedProperty().addListener((observableValue, prevState, currentState) -> button.setDisable(!currentState));

        // create button container, and add check box and button
        VBox buttonContainer = new VBox(10, checkBox, button);
        buttonContainer.setMaxWidth(200.0);

        // add button container to the main content pane
        mainContent.getChildren().addAll(buttonContainer);

        // Create the layout manager using BorderPane
        BorderPane layoutManager = new BorderPane(mainContent);

        // create the scene with specified dimensions
        this.scene = new Scene(layoutManager, WIDTH, HEIGHT);

    }

}
