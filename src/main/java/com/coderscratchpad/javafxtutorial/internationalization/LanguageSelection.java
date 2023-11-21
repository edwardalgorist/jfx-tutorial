package com.coderscratchpad.javafxtutorial.internationalization;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/internationalization-in-javafx-building-multilingual-apps/">coderscratchpad.com</a>
 */
public class LanguageSelection extends Application {

    // The parent layout manager
    private final BorderPane parent = new BorderPane();

    // Determine the user's locale, based on user preferences
    private Locale locale;

    // The resource bundle
    private ResourceBundle bundle;

    @Override
    public void start(Stage stage) throws Exception {

        // Setup and display the stage
        this.setupStage(stage);
    }

    @Override
    public void init() throws Exception {
        super.init();

        // Determine the user's locale, based on user preferences
        this.locale = Locale.getDefault();

        // Load the appropriate resource bundle
        bundle =  ResourceBundle.getBundle("languages.language", this.locale);

        // Build the user interface
        this.buildUI();

    }

    private void buildUI() {

        // Create UI components
        Label label = new Label(this.bundle.getString("label"));

        ObservableList<String> languages = FXCollections.observableArrayList(
                "English", "French", "German", "Spanish"
        );

        // Create a ComboBox for language selection
        ComboBox<String> languageComboBox = new ComboBox<>(languages);

        languageComboBox.setValue(this.locale.getDisplayLanguage());

        // Handle ComboBox selection changes
        languageComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldLanguage, newLanguage) -> {

            this.locale = switch (newLanguage) {
                case "German" -> Locale.forLanguageTag("de");
                case "French" -> Locale.forLanguageTag("fr");
                case "Spanish" -> Locale.forLanguageTag("es");
                default -> Locale.forLanguageTag("en");
            };

            this.bundle = ResourceBundle.getBundle("languages.language", this.locale);

            // Update UI components with localized strings
            label.setText(bundle.getString("label"));

            ((Stage)this.parent.getScene().getWindow()).setTitle(bundle.getString("title"));

        });

        // Create a VBox to hold UI components
        VBox vbox = new VBox(10, label, languageComboBox);
        vbox.setAlignment(Pos.CENTER);

        // Add the VBox to the center of the BorderPane
        this.parent.setCenter(vbox);

    }

    private void setupStage(Stage stage) {

        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle(this.bundle.getString("title"));

        // Set the scene for the stage
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Display the stage
        stage.show();

    }

}