package com.coderscratchpad.javafxtutorial.tabpane;

import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-tabpane-building-user-friendly-tabbed-interfaces/">coderscratchpad.com</a>
 */
public class TabPaneHandlingTabClosure extends Application {

    private final BorderPane parent = new BorderPane();

    private final TabPane tabPane = new TabPane();

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

        // Create tabs
        Tab tab1 = new Tab("Tab 1");
        Tab tab2 = new Tab("Tab 2");

        // Add content to tabs
        tab1.setContent(new BorderPane(new Label("Content 1")));
        tab2.setContent(new BorderPane(new Label("Content 2")));

        // Add tabs to the TabPane
        this.tabPane.getTabs().addAll(tab1, tab2);

        // Handle tab closure request
        this.tabPane.getTabs().forEach(tab -> tab.setOnCloseRequest(this::onTabCloseRequest));

        // Add the TabPane to the BorderPane layout manager
        this.parent.setCenter(tabPane);

    }

    private void onTabCloseRequest(Event event) {

        Tab tab = (Tab) event.getSource();

        event.consume(); // Consume the event to prevent the default tab closure action

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Close Tab");
        alert.setHeaderText(null);
        alert.setContentText("Do you want to close this tab?");
        alert.showAndWait()
                .filter(response -> response == ButtonType.OK)
                .ifPresent(response -> this.tabPane.getTabs().remove(tab));

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("JavaFX TabPane: Building User-Friendly Tabbed Interfaces");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}