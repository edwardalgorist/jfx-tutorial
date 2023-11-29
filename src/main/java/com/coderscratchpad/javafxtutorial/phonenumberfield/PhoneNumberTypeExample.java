package com.coderscratchpad.javafxtutorial.phonenumberfield;

import com.dlsc.phonenumberfx.PhoneNumberField;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-phone-number-input-field/">coderscratchpad.com</a>
 */
public class PhoneNumberTypeExample extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Set the stage title
        stage.setTitle("JavaFX: Phone Number Input Field - Phone Number Type");

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
        buildUI();
    }

    private void buildUI() {

        BasicForm basicForm = new BasicForm();

        // Add the BasicForm to the center of the BorderPane
        parent.setCenter(basicForm);
    }

    /**
     * A form demonstrating the usage of PhoneNumberField with expected phone number types.
     */
    static class BasicForm extends VBox {

        private final PhoneNumberField phoneNumberField;
        private final Label labelValidity;

        public BasicForm() {

            // Phone number types list
            PhoneNumberUtil.PhoneNumberType[] phoneNumberTypes = PhoneNumberUtil.PhoneNumberType.values();
            ComboBox<PhoneNumberUtil.PhoneNumberType> phoneNumberTypeComboBox =
                    new ComboBox<>(FXCollections.observableArrayList(phoneNumberTypes));

            // Create an instance of PhoneNumberField
            this.phoneNumberField = new PhoneNumberField();
            this.phoneNumberField.expectedPhoneNumberTypeProperty().bind(phoneNumberTypeComboBox.valueProperty());

            // Create a show example number CheckBox
            CheckBox showExampleNumberCheckBox = new CheckBox("Show Example Number");
            showExampleNumberCheckBox.setSelected(this.phoneNumberField.isShowExampleNumbers());
            showExampleNumberCheckBox.selectedProperty().addListener(this::onShowExampleNumber);

            // Create a Label to show example phone numbers
            Label labelExample = new Label();
            labelExample.textProperty().bind(this.phoneNumberField.promptTextProperty());

            // Create a Button to submit entered phone number
            Button button = new Button("Submit");
            button.setOnAction(this::onSubmit);

            // Create a Label to show the validity of the number
            this.labelValidity = new Label();

            // Add controls to the VBox container
            VBox container = new VBox(
                    15.0,
                    new VBox(
                            5.0,
                            this.phoneNumberField,
                            labelExample
                    ),
                    phoneNumberTypeComboBox,
                    showExampleNumberCheckBox,
                    button,
                    this.labelValidity
            );

            // Set the VBox container max width
            container.setMaxWidth(500.0);

            this.setAlignment(Pos.CENTER);
            this.getChildren().addAll(container);
        }

        private void onSubmit(ActionEvent actionEvent) {
            if (this.phoneNumberField.isValid()) {
                labelValidity.setText("The entered phone number is valid.");
                labelValidity.setStyle("-fx-text-fill: green;");
            } else {
                labelValidity.setText("The entered phone number is not valid.");
                labelValidity.setStyle("-fx-text-fill: red;");
            }
        }

        private void onShowExampleNumber(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
            phoneNumberField.showExampleNumbersProperty().set(newValue);
        }
    }
}