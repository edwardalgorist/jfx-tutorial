package com.coderscratchpad.javafxtutorial.phonenumberfield;

import com.dlsc.phonenumberfx.PhoneNumberField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-phone-number-input-field/">coderscratchpad.com</a>
 */
public class PhoneNumberInformation extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Set the stage title
        stage.setTitle("JavaFX: Phone Number Input Field - Phone Number Information");

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

        // Add the Basic to the center of the BorderPane
        parent.setCenter(basicForm);

    }

    static class BasicForm extends VBox {

        private final PhoneNumberField phoneNumberField;
        private final Label rawPhoneNumberLabel;
        private final Label nationalPhoneNumberLabel;
        private final Label e164PhoneNumberLabel;

        public BasicForm() {

            // Create an instance of PhoneNumberField
            this.phoneNumberField = new PhoneNumberField();

            // Create a submit Button
            Button button = new Button("Submit");
            button.setOnAction(this::onSubmit);

            // Create a rawPhoneNumber label
            this.rawPhoneNumberLabel = new Label();

            // Create a nationalPhoneNumber label
            this.nationalPhoneNumberLabel = new Label();

            // Create a e164PhoneNumber label
            this.e164PhoneNumberLabel = new Label();

            // Add the PhoneNumberField,
            // Button, and the Labels to the VBox container
            VBox container = new VBox(
                    10.0,
                    this.phoneNumberField,
                    button,
                    this.rawPhoneNumberLabel,
                    this.nationalPhoneNumberLabel,
                    this.e164PhoneNumberLabel
            );

            // Set the VBox container max width
            container.setMaxWidth(200.0);

            this.setAlignment(Pos.CENTER);
            this.getChildren().addAll(container);

        }

        public void onSubmit(ActionEvent event) {

            if(this.phoneNumberField.isValid()) {

                // Retrieve the raw phone number
                String rawPhoneNumber = phoneNumberField.getRawPhoneNumber();
                this.rawPhoneNumberLabel.setText("Raw Phone Number: " + rawPhoneNumber);

                // Retrieve the national formatted number
                String nationalPhoneNumber = phoneNumberField.getNationalPhoneNumber();
                this.nationalPhoneNumberLabel.setText("National Phone Number: " + nationalPhoneNumber);

                // Retrieve the E.164 formatted number
                String e164PhoneNumber = phoneNumberField.getE164PhoneNumber();
                this.e164PhoneNumberLabel.setText("E164 Phone Number: " + e164PhoneNumber);

            }

        }

    }

}
