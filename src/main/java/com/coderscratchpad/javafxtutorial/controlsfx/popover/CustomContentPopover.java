package com.coderscratchpad.javafxtutorial.controlsfx.popover;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.PopOver;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-popover-enhancing-ui-with-contextual-information/">coderscratchpad.com</a>
 */
public class CustomContentPopover extends Application {

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

        Button button = new Button("Show Popover");

        VBox content = new VBox();

        content.setSpacing(10);

        content.setPadding(new Insets(10));

        content.getChildren().addAll(
                new Label("Name:"),
                new TextField(),
                new Label("Email:"),
                new TextField(),
                new Button("Submit")
        );

        PopOver popover = new PopOver(content);

        button.setOnAction(e -> popover.show(button));

        // Add the Button to the BorderPane layout manager
        this.parent.setCenter(button);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("JavaFX Popover: Enhancing UI with Contextual Information");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}