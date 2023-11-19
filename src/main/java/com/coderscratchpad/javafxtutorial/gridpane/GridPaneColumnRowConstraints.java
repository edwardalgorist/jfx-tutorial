package com.coderscratchpad.javafxtutorial.gridpane;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-gridpane-grid-based-ui-designs/">coderscratchpad.com</a>
 */
public class GridPaneColumnRowConstraints extends Application {

    private final GridPane parent = new GridPane();

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

        // Horizontal gap between columns
        this.parent.setHgap(10);

        // Vertical gap between rows
        this.parent.setVgap(10);

        // Center the GridPane
        this.parent.setAlignment(Pos.CENTER);

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Login");
        Button cancelButton = new Button("Cancel");

        // Adding components to the grid
        this.parent.add(usernameLabel, 0, 0);
        this.parent.add(usernameField, 1, 0);

        this.parent.add(passwordLabel, 0, 1);
        this.parent.add(passwordField, 1, 1);

        this.parent.add(loginButton, 0, 2);
        this.parent.add(cancelButton, 1, 2);

        ColumnConstraints col1 = new ColumnConstraints(100); // Preferred width

        // Min, pref, max width
        ColumnConstraints col2 = new ColumnConstraints(200, 300, Double.MAX_VALUE);
        this.parent.getColumnConstraints().addAll(col1, col2);

        // Preferred height
        RowConstraints row1 = new RowConstraints(50);
        this.parent.getRowConstraints().add(row1);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX GridPane: Grid-Based UI Designs");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}