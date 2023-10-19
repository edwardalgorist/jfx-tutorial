package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/getting-started-with-javafx-alerts/">coderscratchpad.com</a>
 */
public class Alerts extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private Scene scene;

    private Alert alert;

    @Override
    public void init() throws Exception {
        super.init();
        buildUI();
    }

    private void buildUI() {

        // create the main content pane
        VBox mainContent = new VBox(10);
        mainContent.setAlignment(Pos.CENTER);

        // confirmation button
        Button btnConfirmation = new Button("Confirmation");
        btnConfirmation.setOnAction(this::btnConfirmationHandler);

        // error button
        Button btnError = new Button("Error");
        btnError.setOnAction(this::btnErrorHandler);

        // information button
        Button btnInformation = new Button("Information");
        btnInformation.setOnAction(this::btnInformationHandler);

        // warning button
        Button btnWarning = new Button("Warning");
        btnWarning.setOnAction(this::btnWarningHandler);

        // add buttons to the main content pane
        mainContent.getChildren().addAll(
                btnConfirmation,
                btnError,
                btnInformation,
                btnWarning
        );

        // Create the layout manager using BorderPane
        BorderPane layoutManager = new BorderPane(mainContent);

        // create the scene with specified dimensions
        this.scene = new Scene(layoutManager, WIDTH, HEIGHT);

    }

    private void btnWarningHandler(ActionEvent actionEvent) {

        this.alert = new Alert(
                Alert.AlertType.INFORMATION,
                "Opening this program would result in other programs not working."
        );

        ButtonType okButton = new ButtonType("Continue", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(okButton, cancelButton);

        this.alert.showAndWait().ifPresent(buttonType -> {

            if(buttonType == okButton) System.out.println("Opening the program...");

        });

    }

    private void btnInformationHandler(ActionEvent actionEvent) {

        this.alert = new Alert(
                Alert.AlertType.INFORMATION,
                "Completed game level successfully."
        );

        this.alert.show();

    }

    private void btnErrorHandler(ActionEvent actionEvent) {

        this.alert = new Alert(
                Alert.AlertType.ERROR,
                "An error occurred while opening the program."
        );

        this.alert.show();

    }

    private void btnConfirmationHandler(ActionEvent actionEvent) {

        this.alert = new Alert(
                Alert.AlertType.CONFIRMATION,
                "Are you sure you want to close the program?",
                ButtonType.YES, ButtonType.CANCEL
        );

        this.alert.showAndWait().ifPresent(buttonType -> {

            if(buttonType == ButtonType.YES) System.out.println("Closing the program...");

        });

    }

    @Override
    public void start(Stage stage) throws Exception {

        // set the scene for the stage
        stage.setScene(this.scene);
        stage.setTitle("Getting Started with JavaFX Alerts");
        stage.centerOnScreen();
        stage.show();

    }

}
