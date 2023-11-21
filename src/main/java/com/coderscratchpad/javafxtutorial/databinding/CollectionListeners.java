package com.coderscratchpad.javafxtutorial.databinding;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/data-binding-in-javafx-simplifying-ui-data-synchronization/">coderscratchpad.com</a>
 */
public class CollectionListeners extends Application {

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

        // Create an observable list of names
        ObservableList<String> names = FXCollections.observableArrayList("Name 1");

        // Create a ListView bound to the names list
        ListView<String> listView = new ListView<>();
        listView.setItems(names);

        // Create a text field for entering new names
        TextField textField = new TextField();

        // Create a button to add a new name to the list
        Button submit = new Button("Add Name");

        // Define an action to execute when the button is clicked
        submit.setOnAction(actionEvent -> {

            // Add the text from the text field to the names list
            names.add(textField.getText());

            // Clear the text field for the next entry
            textField.clear();
        });

        // Create a container for the UI components
        VBox container = new VBox(
                15, // Spacing between components
                listView, // Display the list of names
                new HBox(10, textField, submit) // Input field and the "Add Name" button
        );

        container.setAlignment(Pos.CENTER);
        container.setMaxWidth(300.0);

        // Add the container to the parent StackPane
        this.parent.getChildren().add(container);
    }

}