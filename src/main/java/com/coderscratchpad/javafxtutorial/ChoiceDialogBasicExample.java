package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-choicedialog/">coderscratchpad.com</a>
 */
public class ChoiceDialogBasicExample extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private Scene scene;

    private static final List<String> fruits = List.of(
            "Apple", "Banana", "Orange", "Grapefruit", "Lemon",
            "Lime", "Mango", "Pineapple", "Watermelon", "Strawberry",
            "Blueberry", "Raspberry", "Blackberry", "Cherry", "Peach",
            "Plum", "Pear", "Kiwi", "Avocado", "Papaya", "Pomegranate",
            "Fig", "Coconut", "Guava", "Passion Fruit", "Lychee", "Dragon Fruit",
            "Cranberry", "Apricot", "Cantaloupe", "Honeydew Melon", "Nectarine",
            "Grape", "Kiwifruit", "Persimmon", "Tangerine", "Clementine", "Star Fruit",
            "Jackfruit", "Elderberry"
    );

    private Label label;

    // holds selected fruit
    private String selectedFruit;

    @Override
    public void init() throws Exception {
        super.init();
        buildUI();
    }

    private void buildUI() {

        // create the main content pane
        VBox mainContent = new VBox(10);
        mainContent.setAlignment(Pos.CENTER);

        // create the label to display the fruit on button click
        this.label = new Label();

        // make the first fruit selected by default
        this.selectedFruit = fruits.get(0);

        // create show dialog button
        Button button = new Button("Select Favorite Fruit...");
        button.setOnAction(this::onShowDialog);

        // create label and button container
        VBox container = new VBox(10, button, this.label);
        container.setMaxWidth(200.0);

        // add container to the main content pane
        mainContent.getChildren().addAll(container);

        // create the layout manager using BorderPane
        BorderPane layoutManager = new BorderPane(mainContent);

        // create the scene with specified dimensions
        this.scene = new Scene(layoutManager, WIDTH, HEIGHT);

    }

    private void onShowDialog(ActionEvent actionEvent) {

        // create the fruit choice dialog
        // set previously selected fruit as default
        ChoiceDialog<String> fruitChoiceDialog = new ChoiceDialog<>(this.selectedFruit, fruits);

        // set dialog title
        fruitChoiceDialog.setTitle("Favorite Fruit");

        // set dialog header text
        fruitChoiceDialog.setHeaderText("What's Your Favorite Fruit?");

        // get selected fruit, and display in the label control
        fruitChoiceDialog.showAndWait().ifPresent(selectedFruit -> {
            this.selectedFruit = selectedFruit;
            this.label.setText("The selected fruit is " + this.selectedFruit);
        });

    }

    @Override
    public void start(Stage stage) throws Exception {

        // set the scene for the stage
        stage.setScene(this.scene);

        // set the title for the stage
        stage.setTitle("JavaFX ChoiceDialog");

        // center the stage on screen on startup
        stage.centerOnScreen();

        // show the stage
        stage.show();

    }

}