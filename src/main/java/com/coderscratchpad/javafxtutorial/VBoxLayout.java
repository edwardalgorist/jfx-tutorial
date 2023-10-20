package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-layouts-with-vbox/">coderscratchpad.com</a>
 */
public class VBoxLayout extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    @Override
    public void start(Stage stage) {

        // Create a vertical layout (VBox) to hold the UI elements and center its content
        VBox layoutManager = new VBox();
        layoutManager.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layoutManager, WIDTH, HEIGHT);

        // Add nodes to the VBox layout
        layoutManager.getChildren().add(new FormFields());

        // Set the title of the application window
        stage.setTitle("JavaFX Layouts with VBox");

        // Set the scene for the stage (window)
        stage.setScene(scene);

        // Center the window on the screen
        stage.centerOnScreen();

        // Show the application window
        stage.show();
    }

    // Inner class to create a form with various fields
    private static class FormFields extends VBox {

        public FormFields() {

            // Set a 15-pixel spacing between nodes in the VBox
            super(15);

            // Set the preferred, minimum, and maximum width of the VBox
            this.setMinWidth(300);
            this.setMaxWidth(300);
            this.setPrefWidth(300);

            // Add form fields and elements to the VBox
            getChildren().addAll(
                    new RegistrationFormField("First Name"),
                    new RegistrationFormField("Last Name"),
                    new RegistrationFormField("Email"),
                    new RegistrationFormField("Password", true),
                    new RegistrationFormField("Confirm Password", true),
                    new CheckBox("I agree to the terms & conditions"),
                    new Button("Register")
            );
        }
    }

    // Inner class to create form fields with labels and text fields
    private static class RegistrationFormField extends VBox {

        private TextField textField;

        public RegistrationFormField(String label) {
            super(2);
            init(label, false);
        }

        public RegistrationFormField(String label, boolean obscure) {
            super(2);
            init(label, obscure);
        }

        public String getText() {
            return this.textField.getText();
        }

        private void init(String label, boolean obscure) {
            this.textField = obscure ? new PasswordField() : new TextField();
            this.textField.setPadding(new Insets(6));
            this.getChildren().addAll(new Label(label), textField);
        }

    }

}