package com.coderscratchpad.javafxtutorial.menus;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-menus/">coderscratchpad.com</a>
 */
public class HandlingMenuItemAction extends Application {

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

        // Create MenuBar
        MenuBar menuBar = new MenuBar();

        // Create File Menu
        Menu fileMenu = new Menu("File");

        // Create Menu Item with action
        MenuItem exitMenuItem = new MenuItem("Exit");

        exitMenuItem.setOnAction(e -> {

            // Show a confirmation dialog before exiting
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

            alert.setTitle("Exit");
            alert.setHeaderText("Confirm Exit");

            alert.setContentText("Are you sure you want to exit?");

            alert.showAndWait().ifPresent(response -> {

                if (response == ButtonType.OK) {

                    // Close application
                    Platform.exit();

                }

            });

        });

        fileMenu.getItems().add(exitMenuItem);

        // Add File menu to the MenuBar
        menuBar.getMenus().add(fileMenu);

        // Add MenuBar to the Top of the BorderPane
        this.parent.setTop(menuBar);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("JavaFX Menus");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}