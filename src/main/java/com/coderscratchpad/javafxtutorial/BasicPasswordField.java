package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-passwordfield-secure-input-handling-in-your-java-applications/">coderscratchpad.com</a>
 */
public class BasicPasswordField extends Application {

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

        // Create PasswordField
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");

        // Create Button to retrieve the password
        Button submitButton = new Button("Submit");

        submitButton.setOnAction(e -> {

            String password = passwordField.getText();

            // Print the password out to the console
            System.out.println("Entered password: " + password);

        });

        // Create layout and add controls
        VBox vbox = new VBox(10, passwordField, new VBox(submitButton));
        vbox.setAlignment(Pos.CENTER);

        vbox.setMaxWidth(400.0);

        this.parent.setCenter(vbox);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("JavaFX PasswordField: Secure Input Handling in Your Java Applications");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}