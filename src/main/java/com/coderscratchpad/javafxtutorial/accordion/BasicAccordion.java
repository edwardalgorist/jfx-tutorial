package com.coderscratchpad.javafxtutorial.accordion;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-accordion-creating-collapsible-ui-sections/">coderscratchpad.com</a>
 */
public class BasicAccordion extends Application {

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
        TitledPane pane1 = new TitledPane("Section 1", new VBox());
        TitledPane pane2 = new TitledPane("Section 2", new VBox());
        TitledPane pane3 = new TitledPane("Section 3", new VBox());

        // Add TitledPanes to the Accordion
        accordion.getPanes().addAll(pane1, pane2, pane3);

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