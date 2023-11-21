package com.coderscratchpad.javafxtutorial.databinding;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/data-binding-in-javafx-simplifying-ui-data-synchronization/">coderscratchpad.com</a>
 */
public class DidirectionalBinding extends Application {

    // The parent layout manager
    private final StackPane parent = new StackPane();

    @Override
    public void start(Stage stage) throws Exception {

        // Create a scene with the StackPane as the root
        Scene scene = new Scene(parent, 640, 480);

        // Set the stage title
        stage.setTitle("Data Binding in JavaFX: Simplifying UI-Data Synchronization");

        // Set the scene for the stage
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Display the stage
        stage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        buildUI();
    }

    private void buildUI() {

        // Create a TextField for user input
        TextField textField1 = new TextField();

        // Create another TextField for user input
        TextField textField2 = new TextField();

        // Bind both text properties bidirectionally, making them mirror each other
        textField1.textProperty().bindBidirectional(textField2.textProperty());

        // Create a container to arrange the UI components
        VBox container = new VBox(
                // Arrange the TextFields vertically with spacing
                new VBox(15, textField1, textField2)
        );

        // Center align the container within its parent
        container.setAlignment(Pos.CENTER);

        // Set a maximum width for the container
        container.setMaxWidth(300.0);

        // Add the container to the parent StackPane
        this.parent.getChildren().add(container);
    }

}