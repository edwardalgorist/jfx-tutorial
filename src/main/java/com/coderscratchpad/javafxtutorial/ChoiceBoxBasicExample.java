package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-choicebox/">coderscratchpad.com</a>
 */
public class ChoiceBoxBasicExample extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private Scene scene;

    private static final ObservableList<String> fruits = FXCollections.observableArrayList(
            "Apple", "Banana", "Orange", "Grapefruit", "Lemon",
            "Lime", "Mango", "Pineapple", "Watermelon", "Strawberry",
            "Blueberry", "Raspberry", "Blackberry", "Cherry", "Peach",
            "Plum", "Pear", "Kiwi", "Avocado", "Papaya", "Pomegranate",
            "Fig", "Coconut", "Guava", "Passion Fruit", "Lychee", "Dragon Fruit",
            "Cranberry", "Apricot", "Cantaloupe", "Honeydew Melon", "Nectarine",
            "Grape", "Kiwifruit", "Persimmon", "Tangerine", "Clementine", "Star Fruit",
            "Jackfruit", "Elderberry"
    );

    private ChoiceBox<String> fruitChoiceBox;

    private Label buttonLabel;

    @Override
    public void init() throws Exception {
        super.init();
        buildUI();
    }

    private void buildUI() {

        // create the main content pane
        VBox mainContent = new VBox(10);
        mainContent.setAlignment(Pos.CENTER);

        // create the fruit choice box
        this.fruitChoiceBox = new ChoiceBox<>(fruits);

        // create the fruit choice box bound label
        Label boundLabel  = new Label();

        // create the label to display the fruit on button click
        this.buttonLabel = new Label();

        // create submit button
        Button button = new Button("Submit");
        button.setOnAction(this::onFruitSubmit);

        // select first fruit
        fruitChoiceBox.getSelectionModel().selectFirst();

        // bind the label to the choice box selected value
        boundLabel.textProperty().bind(fruitChoiceBox.valueProperty());

        // listen for choice box changes
        fruitChoiceBox.getSelectionModel().selectedItemProperty().addListener(this::onFruitChanged);

        // add all nodes to the vbox container
        VBox container = new VBox(10, fruitChoiceBox, boundLabel, button, buttonLabel);
        container.setMaxWidth(200.0);

        // add container to the main content pane
        mainContent.getChildren().addAll(container);

        // create the layout manager using BorderPane
        BorderPane layoutManager = new BorderPane(mainContent);

        // create the scene with specified dimensions
        this.scene = new Scene(layoutManager, WIDTH, HEIGHT);

    }

    private void onFruitSubmit(ActionEvent actionEvent) {
        // displays the selected fruit in a label on button click
        this.buttonLabel.setText("The Selected Fruit Is: " + fruitChoiceBox.getValue());
    }

    private void onFruitChanged(ObservableValue<? extends String> observableValue, String oldSelectedFruit, String newSelectedFruit) {
        // prints selected fruit out to the console whenever there is a change
        System.out.println(newSelectedFruit);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // set the scene for the stage
        stage.setScene(this.scene);

        // set the title for the stage
        stage.setTitle("JavaFX ChoiceBox");

        // center the stage on screen on startup
        stage.centerOnScreen();

        // show the stage
        stage.show();

    }

}