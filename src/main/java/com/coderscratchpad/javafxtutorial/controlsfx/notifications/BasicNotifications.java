package com.coderscratchpad.javafxtutorial.controlsfx.notifications;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-controlsfx-notifications-api/">coderscratchpad.com</a>
 */
public class BasicNotifications extends Application {

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

        Button button = new Button("Open Notification");

        button.setOnAction(this::onOpenNotification);

        // Add the Button to the BorderPane layout manager
        this.parent.setCenter(button);

    }

    private void onOpenNotification(ActionEvent actionEvent) {

        // Create an informational notification
        Notifications.create()
                .title("Hello, World!")
                .text("This is a basic ControlsFX notification.")
                .showInformation();

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX ControlsFX Notifications API");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}