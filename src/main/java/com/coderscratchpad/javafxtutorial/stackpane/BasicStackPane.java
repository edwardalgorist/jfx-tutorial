package com.coderscratchpad.javafxtutorial.stackpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-stackpane-layering-ui-elements/">coderscratchpad.com</a>
 */
public class BasicStackPane extends Application {

    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {
        this.setupStage(stage);
    }

    @Override
    public void init() throws Exception {
        super.init();
        this.buildUI();
    }

    private void buildUI() {

        StackPane contentPane = new StackPane();

        // Create UI Elements
        Rectangle redRectangle = new Rectangle(100, 100, Color.RED);
        Rectangle greenRectangle = new Rectangle(80, 80, Color.GREEN);
        Rectangle blueRectangle = new Rectangle(60, 60, Color.BLUE);
        Rectangle brownRectangle = new Rectangle(40, 40, Color.BROWN);
        Rectangle whiteRectangle = new Rectangle(20, 20, Color.WHITE);

        // Add UI Elements to the StackPane
        contentPane.getChildren().addAll(redRectangle, greenRectangle, blueRectangle, brownRectangle, whiteRectangle);

        this.parent.setCenter(contentPane);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX StackPane: Layering UI Elements");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}