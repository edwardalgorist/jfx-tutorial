package com.coderscratchpad.javafxtutorial.checkbox;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Builder;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/a-guide-to-using-checkboxes-for-multiple-selection-in-javafx/">coderscratchpad.com</a>
 */
public class CheckBoxMultipleSelection extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private Scene scene;

    Set<String> selectedLanguages;

    private static final String[] languages = {
            "Assembly Language",
            "C",
            "C#",
            "C++",
            "F#",
            "Java",
            "JavaScript",
            "Python"
    };

    private Button button;

    private Label label;

    @Override
    public void start(Stage stage) throws Exception {

        // set the scene for the stage
        stage.setScene(this.scene);

        // set the title for the stage
        stage.setTitle("A Guide to Using Checkboxes for Multiple Selection in JavaFX");

        // center the stage on screen on startup
        stage.centerOnScreen();

        // show the stage
        stage.show();

    }

    @Override
    public void init() throws Exception {
        super.init();
        buildUI();
    }

    private void buildUI() {

        // create the main content pane
        VBox mainContent = new VBox(10);
        mainContent.setAlignment(Pos.CENTER);

        // create a set to store selected languages
        this.selectedLanguages = new TreeSet<>();

        // create the submit button
        this.button = new Button("Submit");
        this.button.setDisable(true);
        this.button.setOnAction(this::buttonSubmitHandler);

        // create the label
        this.label = new Label();

        // hide label
        this.label.setVisible(false);

        // creates a language mapper, each to a checkbox
        // and attach listener
        Function<String, CheckBox> mapper = language -> {
            return (new CheckBoxBuilder(language, this::languageChangeListener)).build();
        };

        // create language checkboxes
        CheckBox[] languageCheckboxes = Arrays.stream(languages)
                .map(mapper)
                .toArray(CheckBox[]::new);

        // create the language container and add all checkboxes
        VBox languageContainer = new VBox(

                // add 10px spacing between nodes
                10,

                new Label("Select Your Favorite Languages:"),

                // add language checkboxes to a different VBox container,
                // with a 5px spacing
                new VBox(5, languageCheckboxes),

                this.button,
                this.label

        );

        languageContainer.setMaxWidth(400.0);

        // add the language container to the main content pane
        mainContent.getChildren().addAll(languageContainer);

        // create the layout manager using BorderPane
        BorderPane layoutManager = new BorderPane(mainContent);

        // create the scene with specified dimensions
        this.scene = new Scene(layoutManager, WIDTH, HEIGHT);

    }

    private void buttonSubmitHandler(ActionEvent actionEvent) {

        this.label.setText(selectedLanguages.toString());

        // hide or show label, depending on selected languages
        this.label.setVisible(!selectedLanguages.isEmpty());

    }

    private void languageChangeListener(ObservableValue<? extends Boolean> observableValue, Boolean prevState, Boolean currentState) {

        // get the property's underlying bean
        Object bean = ((BooleanProperty) observableValue).getBean();

        // cast the bean to a checkbox
        CheckBox language = (CheckBox) bean;

        if(currentState) {
            // add the selected language to the set
            this.selectedLanguages.add(language.getText());
        } else {
            // remove the deselected language from the set
            this.selectedLanguages.remove(language.getText());
        }

        // enable or disable the button based on selected languages
        this.button.setDisable(selectedLanguages.isEmpty());

    }

    private static class CheckBoxBuilder implements Builder<CheckBox> {

        private final CheckBox checkBox;

        public CheckBoxBuilder(String label, ChangeListener<? super Boolean> changeListener) {
            this.checkBox = new CheckBox(label);
            this.checkBox.selectedProperty().addListener(changeListener);
        }

        @Override
        public CheckBox build() {
            return this.checkBox;
        }

    }

}