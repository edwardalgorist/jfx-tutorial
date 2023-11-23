package com.coderscratchpad.javafxtutorial.phonenumberfield;

import com.dlsc.phonenumberfx.PhoneNumberField;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-phone-number-input-field/">coderscratchpad.com</a>
 */
public class PhoneNumberInputCSSStyling extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        scene.getStylesheets().add("styles.css");

        // Set the stage title
        stage.setTitle("JavaFX: Phone Number Input Field - CSS Styling");

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

        // Create an instance of PhoneNumberField
        PhoneNumberField phoneNumberField = new PhoneNumberField();

        // Set the PhoneNumberField max width to 200.0px
        phoneNumberField.setMaxWidth(200.0);

        // Add the PhoneNumberField to the center of the BorderPane
        parent.setCenter(phoneNumberField);

    }

}
