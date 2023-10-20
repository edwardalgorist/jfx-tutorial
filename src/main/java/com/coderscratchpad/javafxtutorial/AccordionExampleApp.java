package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/getting-started-with-accordions-in-javafx-for-beginners/">coderscratchpad.com</a>
 */
public class AccordionExampleApp extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        // Set the scene for the stage
        stage.setScene(this.scene);
        stage.setTitle("Getting Started with Accordions in JavaFX for Beginners");
        stage.centerOnScreen();
        stage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        buildUI();
    }

    private void buildUI() {
        // Create the main content pane using a VBox with vertical spacing of 10 and padding of 15
        VBox mainContent = new VBox(10);
        mainContent.setPadding(new Insets(15));

        // Create the header label
        Label header = new Label("FAQs");
        header.setStyle("-fx-font-size: 20px; -fx-font-weight: bold");

        // Create the Accordion container
        Accordion accordion = new Accordion();

        // Create nodes for the content sections
        Label content1 = new Label("Content 1");
        Label content2 = new Label("Content 2");
        Label content3 = new Label("Content 3");
        Label content4 = new Label("Content 4");

        // Create titled panes for the questions
        TitledPane question1 = new TitledPane("Is JavaFX still used today?", content1);
        TitledPane question2 = new TitledPane("What is JavaFX used for?", content2);
        TitledPane question3 = new TitledPane("Should I use JavaFX or Swing?", content3);
        TitledPane question4 = new TitledPane("Is JavaFX available for Android?", content4);

        // Add the titled panes to the accordion
        accordion.getPanes().addAll(question1, question2, question3, question4);

        // Add the header and accordion to the main content pane
        mainContent.getChildren().addAll(header, accordion);

        // Create the layout manager using BorderPane
        BorderPane layoutManager = new BorderPane(mainContent);

        // Create the scene with specified dimensions
        this.scene = new Scene(layoutManager, WIDTH, HEIGHT);
    }
}