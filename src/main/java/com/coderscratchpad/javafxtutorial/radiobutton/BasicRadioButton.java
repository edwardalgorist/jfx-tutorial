package com.coderscratchpad.javafxtutorial.radiobutton;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/how-to-create-radiobuttons-in-javafx/">coderscratchpad.com</a>
 */
public class BasicRadioButton extends Application {

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

        VBox optionSelector = new OptionSelector(
                new String[]{"C++", "Java", "JavaScript", "Python"},
                "JavaScript", // Default selected option
                "What's your favorite language?" // Prompt label
        );

        optionSelector.setPadding(new Insets(50.0));

        this.parent.setCenter(optionSelector);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("How to Create JavaFX RadioButtons");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}

