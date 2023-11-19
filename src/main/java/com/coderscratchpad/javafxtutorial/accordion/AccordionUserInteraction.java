package com.coderscratchpad.javafxtutorial.accordion;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-accordion-creating-collapsible-ui-sections/">coderscratchpad.com</a>
 */
public class AccordionUserInteraction extends Application {

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

        // Create an Accordion
        Accordion accordion = new Accordion();

        // Create TitledPanes with content
        for(int i = 1; i <= 3; ++i) {

            // Create the TitlePane content
            VBox content = new VBox(
                    new VBox(10,  // Space between Nodes
                            new Label("Content for Section %d".formatted(i)),
                            new Button("Button %d".formatted(i)),
                            new CheckBox("Check Box %d".formatted(i))
                    )
            );

            content.setMaxWidth(200.0);
            content.setAlignment(Pos.CENTER);

            // Create the TitlePane with content
            TitledPane pane = new TitledPane("Section %d".formatted(i), content);

            // Add TitledPane to the Accordion
            accordion.getPanes().addAll(pane);

        }

        accordion.expandedPaneProperty().addListener((observable, oldPane, newPane) -> {

            if (newPane != null) {
                System.out.println("Expanded: " + newPane.getText());
            }

            if(oldPane != null) {
                System.out.println("Collapsed: " + oldPane.getText());
            }

        });

        // Add the Accordion to the BorderPane
        this.parent.setCenter(accordion);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX Accordion: Creating Collapsible UI Sections");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}