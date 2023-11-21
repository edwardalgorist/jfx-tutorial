package com.coderscratchpad.javafxtutorial.screenshot;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import javafx.scene.robot.Robot;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/capturing-screenshots-with-javafx/">coderscratchpad.com</a>
 */
public class SpecificRegion extends Application {

    // The parent layout manager
    private final StackPane parent = new StackPane();

    private static final int SCENE_WIDTH = 640;
    private static final int SCENE_HEIGHT = 480;

    @Override
    public void start(Stage stage) throws Exception {

        // Create a scene with the StackPane as the root
        Scene scene = new Scene(parent, SCENE_WIDTH, SCENE_HEIGHT);

        // Set the stage title
        stage.setTitle("Capturing Screenshots with JavaFX");

        // Set the scene for the stage
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Display the stage
        stage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        buildUI();
    }

    private void buildUI() {

        // Create an ImageView to display the captured screenshot
        ImageView imageView = new ImageView();
        imageView.setFitWidth(600.0);
        imageView.setFitHeight(400.0);

        // Create a Button to trigger the screenshot capture
        Button buttonScreenshot = new Button("Capture Screenshot");

        // Create IntegerTextFields for input
        IntegerTextField textFieldX = new IntegerTextField();
        IntegerTextField textFieldY = new IntegerTextField();
        IntegerTextField textFieldWidth = new IntegerTextField();
        IntegerTextField textFieldHeight = new IntegerTextField();

        // Define the action to take when the button is clicked
        buttonScreenshot.setOnAction(event -> {

            // Retrieve the user input for X, Y, width, and height
            int x = textFieldX.getInteger();
            int y = textFieldY.getInteger();
            int width = textFieldWidth.getInteger();
            int height = textFieldHeight.getInteger();

            // Capture a screenshot of the specified region
            WritableImage image = captureScreenshot(x, y, width, height);

            // Display the captured screenshot in the ImageView
            if (image != null) {
                imageView.setImage(image);
            }
        });

        // Create an HBox to hold labeled text fields and the capture button
        HBox buttonTextFieldsContainer = new HBox(
                10,
                new LabeledTextField(5, "X: ", textFieldX).build(),
                new LabeledTextField(5, "Y: ", textFieldY).build(),
                new LabeledTextField(5, "WIDTH: ", textFieldWidth).build(),
                new LabeledTextField(5, "HEIGHT: ", textFieldHeight).build(),
                buttonScreenshot
        );

        buttonTextFieldsContainer.setAlignment(Pos.CENTER);

        // Create a VBox to hold the ImageView and the HBox
        VBox container = new VBox(20, imageView, buttonTextFieldsContainer);

        // Center-align the container contents
        container.setAlignment(Pos.CENTER);

        // Add the Container (VBox) to the parent layout (StackPane)
        this.parent.getChildren().add(container);
    }

    // Method to capture a screenshot of a specified region
    private WritableImage captureScreenshot(int x, int y, int width, int height) {
        Robot robot = new Robot();

        try {

            // Capture the screenshot and return it as a WritableImage
            return robot.getScreenCapture(null, x, y, width, height);

        } catch (IllegalArgumentException exception) {

            // Handle any exceptions (e.g., width or height less than or equal to 0)
            exception.printStackTrace();
            return null;
        }
    }

}