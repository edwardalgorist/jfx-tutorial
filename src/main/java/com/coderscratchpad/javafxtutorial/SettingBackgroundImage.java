package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/creating-a-stylish-user-registration-form-with-background-image-in-javafx/">coderscratchpad.com</a>
 */
public class SettingBackgroundImage extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private Scene scene;

    @Override
    public void init() throws Exception {
        super.init();
        buildUI();
    }

    private void buildUI() {

        // create the main content pane
        VBox mainContent = new VBox(15);

        // set main content pane background image
        setRegionBackgroundImage(mainContent, "form-background.jpg");

        mainContent.setAlignment(Pos.CENTER);

        // create input fields
        VTextField name = new VTextField("Name");
        name.setMaxWidth(300.0);

        VTextField email = new VTextField("Email");
        email.setMaxWidth(300.0);

        VTextField password = new VTextField("Password", true);
        password.setMaxWidth(300.0);

        VTextField confirmPassword = new VTextField("Confirm Password", true);
        confirmPassword.setMaxWidth(300.0);

        // create checkbox for terms and conditions
        CheckBox agreeToTerms = new CheckBox("I agree to the terms and conditions.");

        // create register button
        Button register = new Button("Register");

        // create container for checkbox and register button
        VBox buttonContainer = new VBox(15, agreeToTerms, register);
        buttonContainer.setMaxWidth(300.0);

        // add all elements to the main content pane
        mainContent.getChildren().addAll(
                name,
                email,
                password,
                confirmPassword,
                buttonContainer
        );

        // create the layout manager
        BorderPane layoutManager = new BorderPane(mainContent);

        // create the scene with specified dimensions
        this.scene = new Scene(layoutManager, WIDTH,HEIGHT);

    }

    private void setRegionBackgroundImage(Region region, String imageUrl) {

        // load the background image
        Image image = new Image(imageUrl);

        // create the background image with specified properties
        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT
        );

        // apply the background image to the region
        Background background = new Background(backgroundImage);
        region.setBackground(background);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setScene(this.scene);
        stage.setTitle("Creating a Stylish User Registration Form with Background Image in JavaFX");
        stage.centerOnScreen();

        stage.show();

    }

    static class VTextField extends VBox {

        private final TextField textField;

        public VTextField(String label) {
            this(label, false);
        }

        public VTextField(String label, boolean obscure) {

            if(obscure)
                this.textField = new PasswordField();
            else
                this.textField = new TextField();

            this.getChildren().addAll(new Label(label), this.textField);

        }

        public String getText() {
            return this.textField.getText();
        }

    }

}