package com.coderscratchpad.javafxtutorial.scrollpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/creating-scrollable-content-with-javafx-scrollpane/">coderscratchpad.com</a>
 */
public class ScrollPaneScrollEvents extends Application {

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

        VBox content = new VBox();

        for (int i = 1; i <= 100; i++) {
            content.getChildren().add(new Label("Item " + i));
        }

        ScrollPane scrollPane = new ScrollPane(content);

        // Handle scroll events on the ScrollPane
        scrollPane.addEventFilter(ScrollEvent.SCROLL, event -> {

            double deltaY = event.getDeltaY();

            if (deltaY > 0) {

                System.out.println("Scrolling Up");

            } else {

                System.out.println("Scrolling Down");

            }

        });

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