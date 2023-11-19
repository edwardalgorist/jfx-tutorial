package com.coderscratchpad.javafxtutorial.scrollpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/creating-scrollable-content-with-javafx-scrollpane/">coderscratchpad.com</a>
 */
public class ScrollPaneZooming extends Application {

    private double scaleValue = 1.0;
    private static final double ZOOM_FACTOR = 1.5;

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

        // Load an image
        Image image = new Image("https://via.placeholder.com/640");

        // Use an ImageView to display the image
        ImageView imageView = new ImageView(image);

        ScrollPane scrollPane = new ScrollPane(imageView);

        // Allow panning
        scrollPane.setPannable(true);

        // Handle scroll events on the ScrollPane
        scrollPane.addEventFilter(ScrollEvent.SCROLL, event -> {

            if (event.isControlDown()) {

                double deltaY = event.getDeltaY();

                if (deltaY < 0) {

                    scaleValue /= ZOOM_FACTOR;

                } else {

                    scaleValue *= ZOOM_FACTOR;

                }

                // Limit the zoom level
                scaleValue = Math.min(2.0, Math.max(0.1, scaleValue));

                // Apply the scale transformation to the content
                scrollPane.getContent().setScaleX(scaleValue);
                scrollPane.getContent().setScaleY(scaleValue);

                event.consume();

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
