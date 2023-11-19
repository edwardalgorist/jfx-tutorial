package com.coderscratchpad.javafxtutorial.controlsfx.autocompletion;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

import java.util.Arrays;
import java.util.List;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/textfield-autocompletion-in-javafx-using-controlsfx/">coderscratchpad.com</a>
 */
public class BasicAutoCompletion extends Application {

    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        // Setup and display the stage
        this.setupStage(stage);

    }

    @Override
    public void init() throws Exception {
        super.init();

        // Build the user interface
        this.buildUI();

    }

    private void buildUI() {

        // Create the TextField
        TextField textField = new TextField();

        // Set the TextField width to 300.0 pixels
        textField.setMaxWidth(300.0);

        // A list of possible suggestions
        List<String> possibleSuggestions = Arrays.asList(
                "C", "C#", "C++", "F#", "GoLang",
                "Dart", "Java", "JavaScript", "Kotlin", "PHP",
                "Python", "R", "Swift", "Visual Basic .NET"
        );


        // Bind autocompletion to the TextField
        TextFields.bindAutoCompletion(textField, possibleSuggestions);

        // Add the TextField to the center of the BorderPane
        this.parent.setCenter(textField);

    }

    private void setupStage(Stage stage) {

        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(this.parent, 640, 480);

        // Set the scene for the stage
        stage.setScene(scene);

        // Set the stage title
        stage.setTitle("TextField Autocompletion in JavaFX using ControlsFX");

        // Center the stage on the screen
        stage.centerOnScreen();

        // Display the stage
        stage.show();

    }

}