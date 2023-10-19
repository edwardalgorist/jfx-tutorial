package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/ensuring-safe-program-close-in-javafx-with-confirmation-dialogs/">coderscratchpad.com</a>
 */
public class UserConfirmationProgramClose extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    @Override
    public void start(Stage stage) {

        BorderPane layoutManager = new BorderPane();

        Scene scene = new Scene(layoutManager, WIDTH, HEIGHT);

        Image icon = new Image("duck.png");

        /* set stage icon */
        stage.getIcons().add(icon);

        // Set a handler for the close request event
        stage.setOnCloseRequest(new CloseRequestHandler());

        // Set the title of the application window
        stage.setTitle("User Confirmation Program Close");

        stage.setScene(scene);

        // Center the window on the screen
        stage.centerOnScreen();

        // Show the application window
        stage.show();
    }

    // Inner class to handle the window close request
    private static class CloseRequestHandler implements EventHandler<WindowEvent> {

        @Override
        public void handle(WindowEvent event) {

            // Create a confirmation dialog
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

            // Set the dialog title and message
            alert.titleProperty().setValue("Close Program");
            alert.headerTextProperty().setValue("Do you want to save your changes before closing the program?");

            // Show the dialog and handle the user's response
            alert.showAndWait().ifPresent(buttonType -> {

                // If the user selects Cancel, consume the event to prevent closing
                if (buttonType.equals(ButtonType.CANCEL)) {
                    event.consume();
                }

            });
        }
    }
}
