package com.coderscratchpad.javafxtutorial.phonenumberfield;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.dlsc.phonenumberfx.PhoneNumberField;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-phone-number-input-field/">coderscratchpad.com</a>
 */
public class ShowExampleNumberExample extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Set the stage title
        stage.setTitle("JavaFX: Phone Number Input Field - Show Example Number");

        // Sets the stage scene
        stage.setScene(scene);

        // Centers stage on screen
        stage.centerOnScreen();

        // Show stage on screen
        stage.show();

    }

    @Override
    public void init() throws Exception {
        super.init();
        this.buildUI();
    }

    private void buildUI() {

        BasicForm basicForm = new BasicForm();

        // Add the BasicForm to the center of the BorderPane
        parent.setCenter(basicForm);

    }

    static class BasicForm extends VBox {

        private final PhoneNumberField phoneNumberField;

        public BasicForm() {

            // Create an instance of PhoneNumberField
            this.phoneNumberField = new PhoneNumberField();

            // Create a show example number CheckBox
            CheckBox showExampleNumber = new CheckBox("Show Example Number");
            showExampleNumber.selectedProperty().addListener(this::onShowExampleNumber);

            // Create a Label to show example phone numbers
            Label labelExample = new Label();
            labelExample.textProperty().bind(this.phoneNumberField.promptTextProperty());

            // Add the PhoneNumberField,
            // Button, and the CheckBox to the VBox container
            VBox container = new VBox(
                    15.0,
                    this.phoneNumberField,
                    labelExample,
                    showExampleNumber
            );

            // Set the VBox container max width
            container.setMaxWidth(200.0);

            this.setAlignment(Pos.CENTER);
            this.getChildren().addAll(container);

        }

        private void onShowExampleNumber(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
            this.phoneNumberField.showExampleNumbersProperty().set(newValue);
        }

    }

}