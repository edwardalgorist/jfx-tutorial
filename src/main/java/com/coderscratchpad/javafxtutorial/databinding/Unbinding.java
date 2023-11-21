package com.coderscratchpad.javafxtutorial.databinding;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/data-binding-in-javafx-simplifying-ui-data-synchronization/">coderscratchpad.com</a>
 */
public class Unbinding extends Application {

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

        // Create a text field for user input
        TextField textField = new TextField();

        // Create a label to display the text from the text field
        Label label = new Label();

        // Bind the label's text to the text property of the text field
        label.textProperty().bind(textField.textProperty());

        // Create a button to bind the label to the text field
        Button bind = new Button("Bind");
        bind.setOnAction(actionEvent -> label.textProperty().bind(textField.textProperty()));

        // Create a button to unbind the label from the text field
        Button unbind = new Button("Unbind");
        unbind.setOnAction(actionEvent -> label.textProperty().unbind());

        // Create a container for the UI components
        VBox container = new VBox(
                15, // Spacing between components
                new VBox(10, textField, label), // Text field and label
                new HBox(10, bind, unbind) // Bind and unbind buttons
        );

        container.setAlignment(Pos.CENTER);
        container.setMaxWidth(300.0);

        // Add the container to the parent StackPane
        this.parent.getChildren().add(container);
    }

}