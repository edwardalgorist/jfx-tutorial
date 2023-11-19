package com.coderscratchpad.javafxtutorial.anchorpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-anchorpane-anchoring-your-ui/">coderscratchpad.com</a>
 */
public class AnchoringElements extends Application {

    private final AnchorPane parent = new AnchorPane();

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

        Button topLeftButton = new Button("Top Left");
        Button bottomRightButton = new Button("Bottom Right");

        // Anchoring elements
        AnchorPane.setTopAnchor(topLeftButton, 10.0);
        AnchorPane.setLeftAnchor(topLeftButton, 10.0);

        AnchorPane.setBottomAnchor(bottomRightButton, 10.0);
        AnchorPane.setRightAnchor(bottomRightButton, 10.0);

        this.parent.getChildren().addAll(topLeftButton, bottomRightButton);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX AnchorPane: Anchoring Your UI");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}