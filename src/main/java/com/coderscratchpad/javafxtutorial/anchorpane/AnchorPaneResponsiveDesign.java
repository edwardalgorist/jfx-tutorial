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
public class AnchorPaneResponsiveDesign extends Application {

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

        Button resizableButton = new Button("Resizable");

        // Anchor the button to all four edges, creating a resizable behavior
        AnchorPane.setTopAnchor(resizableButton, 20.0);
        AnchorPane.setRightAnchor(resizableButton, 20.0);
        AnchorPane.setBottomAnchor(resizableButton, 20.0);
        AnchorPane.setLeftAnchor(resizableButton, 20.0);

        this.parent.getChildren().addAll(resizableButton);

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