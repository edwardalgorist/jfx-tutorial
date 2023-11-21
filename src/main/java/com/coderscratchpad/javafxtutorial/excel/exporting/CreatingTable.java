package com.coderscratchpad.javafxtutorial.excel.exporting;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/exporting-javafx-table-data-to-excel/">coderscratchpad.com</a>
 */
public class CreatingTable extends Application {

    // The parent layout manager
    private final StackPane parent = new StackPane();

    @Override
    public void start(Stage stage) throws Exception {

        // Create a scene with the StackPane as the root
        Scene scene = new Scene(parent, 640, 480);

        // Set the stage title
        stage.setTitle("Exporting JavaFX Table Data to Excel");

        // Set the scene for the stage
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Display the stage
        stage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        buildUI();
    }

    private void buildUI() throws IOException {

        ObservableList<User> users = UserData.getUsers();

        // Create a UserTableView to display the data
        UserTableView userTableView = new UserTableView(users);

        // Add the TableView to the parent layout
        this.parent.getChildren().add(userTableView);
    }

}