package com.coderscratchpad.javafxtutorial.menus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-menus/">coderscratchpad.com</a>
 */
public class ContextMenu extends Application {

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

        // Create a Button
        Button button = new Button("Right-click me!");

        // Create a ContextMenu
        javafx.scene.control.ContextMenu contextMenu = new javafx.scene.control.ContextMenu();

        // Create MenuItem for the context menu
        MenuItem item1 = new MenuItem("Item 1");
        MenuItem item2 = new MenuItem("Item 2");
        MenuItem item3 = new MenuItem("Item 3");

        // Add MenuItems to the ContextMenu
        contextMenu.getItems().addAll(item1, item2, item3);

        // Attach the context menu to the button
        button.setContextMenu(contextMenu);

        this.parent.setCenter(button);

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