package com.coderscratchpad.javafxtutorial.scrollpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.skin.ScrollPaneSkin;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/creating-scrollable-content-with-javafx-scrollpane/">coderscratchpad.com</a>
 */
public class ScrollPaneScrollBars extends Application {

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

        // Add listener to the skin property of the ScrollPane
        scrollPane.skinProperty().addListener((skinObservable, oldSkin, newSkin) -> {

            if(newSkin != null) {

                ScrollBar hScrollBar = ((ScrollPaneSkin) newSkin).getHorizontalScrollBar();
                ScrollBar vScrollBar = ((ScrollPaneSkin) newSkin).getVerticalScrollBar();

                // Add event listeners to ScrollBars
                hScrollBar.valueProperty().addListener((observable, oldValue, newValue) -> {
                    System.out.println("Horizontal Scroll Value: " + newValue);
                });

                vScrollBar.valueProperty().addListener((observable, oldValue, newValue) -> {
                    System.out.println("Vertical Scroll Value: " + newValue);
                });

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