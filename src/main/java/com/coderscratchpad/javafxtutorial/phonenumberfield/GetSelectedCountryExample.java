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

import java.util.Arrays;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-phone-number-input-field/">coderscratchpad.com</a>
 */
public class GetSelectedCountryExample extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Set the stage title
        stage.setTitle("JavaFX: Phone Number Input Field - Get Selected Country");

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
        private final Label selectedCountryLabel;

        public BasicForm() {

            // Create an instance of PhoneNumberField
            this.phoneNumberField = new PhoneNumberField();

            // Create a submit Button
            Button button = new Button("Submit");
            button.setOnAction(this::onSubmit);

            // Create a selectedCountry label
            this.selectedCountryLabel = new Label();

            // Add the PhoneNumberField,
            // Button, and the selectedCountry Label to the VBox container
            VBox container = new VBox(
                    10.0,
                    this.phoneNumberField,
                    button,
                    this.selectedCountryLabel
            );

            // Set the VBox container max width
            container.setMaxWidth(200.0);

            this.setAlignment(Pos.CENTER);
            this.getChildren().addAll(container);

        }

        public void onSubmit(ActionEvent event) {

            if(this.phoneNumberField.isValid()) {

                // Retrieve the selected country
                PhoneNumberField.Country country = phoneNumberField.getSelectedCountry();

                // Display the selected country
                this.selectedCountryLabel.setText(
                        "NAME: " + country.name() +
                        "\nCOUNTRY CODE: " + country.countryCode() +
                        "\nCOUNTRY CODE PREFIX: " + country.countryCodePrefix() +
                        "\nISO2 CODE: " + country.iso2Code() +
                        "\nAREA CODES: " + Arrays.toString(country.areaCodes()) +
                        "\nDEFAULT AREA CODES: " + country.defaultAreaCode()
                );

            }

        }

    }

}
