package com.coderscratchpad.javafxtutorial.listview;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/how-to-create-a-listview-in-javafx/">coderscratchpad.com</a>
 */
public class ListViewCustomization extends Application {

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

        ObservableList<String> languages = FXCollections.observableArrayList(
                "C++", "Java", "JavaScript", "Python"
        );

        // Create a ListView and set the items
        ListView<String> listView = new ListView<>(languages);

        // Custom cell factory to display each item with an icon
        listView.setCellFactory(param -> new ListCell<>() {

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (item != null) {

                    setText(item);
                    setGraphic(getLanguageIcon(item));

                } else {

                    setText(null);
                    setGraphic(null);

                }

            }

        });

        this.parent.setCenter(listView);

    }

    // Helper method to get the corresponding language icon
    private ImageView getLanguageIcon(String language) {

        String iconPath = language.toLowerCase().replace("++", "pp") + ".png";
        return new ImageView(new Image(iconPath));

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("How to Create a ListView in JavaFX");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}