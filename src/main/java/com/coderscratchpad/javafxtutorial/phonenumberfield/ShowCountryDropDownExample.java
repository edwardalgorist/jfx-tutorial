package com.coderscratchpad.javafxtutorial.phonenumberfield;

import com.dlsc.phonenumberfx.PhoneNumberField;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-phone-number-input-field/">coderscratchpad.com</a>
 */
public class ShowCountryDropDownExample extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Set the stage title
        stage.setTitle("JavaFX: Phone Number Input Field - CountryDropDown Visibility");

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

            // Create a show country drop down CheckBox
            CheckBox showCountryDropdownCheckBox = new CheckBox("Show Country Dropdown");
            showCountryDropdownCheckBox.setSelected(this.phoneNumberField.isShowCountryDropdown());
            showCountryDropdownCheckBox.selectedProperty().addListener(this::onShowCountryDropDown);

            // Add controls to the VBox container
            VBox container = new VBox(
                    15.0,
                    this.phoneNumberField,
                    showCountryDropdownCheckBox
            );

            // Set the VBox container max width
            container.setMaxWidth(200.0);

            this.setAlignment(Pos.CENTER);
            this.getChildren().addAll(container);

        }

        private void onShowCountryDropDown(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
            this.phoneNumberField.showCountryDropdownProperty().set(newValue);
        }

    }

}