package com.coderscratchpad.javafxtutorial.controlsfx.autocompletion;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/textfield-autocompletion-in-javafx-using-controlsfx/">coderscratchpad.com</a>
 */
public class AutoCompletionCustomConverter extends Application {

    private final BorderPane parent = new BorderPane();

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
        List<Language> possibleSuggestions = Arrays.asList(
                new Language("C"), new Language("C#"), new Language("C++"),  new Language("F#"),
                new Language("GoLang"), new Language("Dart") , new Language("Java"),  new Language("R"),
                new Language("JavaScript"), new Language("Kotlin"), new Language("PHP"),
                new Language("Python"), new Language("Swift"), new Language("Visual Basic .NET")
        );

        Callback<AutoCompletionBinding.ISuggestionRequest, Collection<Language>> suggestionProvider =
                request -> possibleSuggestions.stream()
                        .filter(suggestion -> suggestion.name().toLowerCase().contains(request.getUserText().toLowerCase()))
                        .toList();

        StringConverter<Language> converter = new StringConverter<>() {

            @Override
            public String toString(Language language) {

                // Convert suggestion to display text
                return language.name();

            }

            @Override
            public Language fromString(String name) {

                // Convert selected display text back to suggestion
                return possibleSuggestions.stream()
                        .filter(suggestion -> suggestion.name().equalsIgnoreCase(name))
                        .findFirst().orElse(null);

            }

        };

        // Bind autocompletion to the TextField using the custom suggestion provider, and converter
        TextFields.bindAutoCompletion(textField, suggestionProvider, converter);

        // Add the TextField to the center of the BorderPane
        this.parent.setCenter(textField);

    }

    @Override
    public void start(Stage stage) throws Exception {

        // Setup and display the stage
        this.setupStage(stage);

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

    record Language(String name) {}

}