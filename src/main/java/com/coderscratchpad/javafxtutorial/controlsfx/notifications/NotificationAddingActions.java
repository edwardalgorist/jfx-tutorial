package com.coderscratchpad.javafxtutorial.controlsfx.notifications;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.action.Action;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-controlsfx-notifications-api/">coderscratchpad.com</a>
 */
public class NotificationAddingActions extends Application {

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

        Notifications.create()
                .title("Notification with Action")
                .text("Click the button below to perform an action.")
                .action(new Action("Button Label", event -> {

                    // Your action code here
                    System.out.println("Button Pressed!");

                })).showInformation();

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