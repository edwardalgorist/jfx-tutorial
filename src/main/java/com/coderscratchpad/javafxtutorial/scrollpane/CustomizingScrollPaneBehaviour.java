package com.coderscratchpad.javafxtutorial.scrollpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/creating-scrollable-content-with-javafx-scrollpane/">coderscratchpad.com</a>
 */
public class CustomizingScrollPaneBehaviour extends Application {

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

        VBox content = new VBox(10);

        for (int i = 1; i <= 50; i++) {

            content.getChildren().add(new Label("Item " + i));

        }

        // Add scrolling capability to the content
        ScrollPane scrollPane = new ScrollPane(content);

        // Customize ScrollPane behavior
        // Disable horizontal scrollbar
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        // Always show vertical scrollbar
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        // Set initial vertical scroll position to the middle
        scrollPane.setVvalue(0.5);

        // Add the scroll pane to the BorderPane layout manager
        this.parent.setCenter(scrollPane);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("JavaFX ScrollPane");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}