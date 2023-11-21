package com.coderscratchpad.javafxtutorial.excel.exporting;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.File;
import java.io.IOException;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/exporting-javafx-table-data-to-excel/">coderscratchpad.com</a>
 */
public class ExportingExcelData extends Application {

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

        // Create a BorderPane to arrange the TableView and export button
        BorderPane borderPane = new BorderPane(userTableView);

        // Create an "Export to Excel" button
        Button exportButton = new Button("Export to Excel");

        // Set an action for the export button
        exportButton.setOnAction(e -> {

            try {

                exportTable(userTableView);

            } catch (IOException ex) {

                // Handle any exceptions that occur during the export process
                System.out.println("Couldn't export table data.");
                throw new RuntimeException(ex);

            }

        });

        // Add the export button to the bottom of the BorderPane
        borderPane.setBottom(exportButton);
        BorderPane.setAlignment(exportButton, Pos.CENTER);
        BorderPane.setMargin(exportButton, new Insets(10));

        // Add the BorderPane to the parent layout
        this.parent.getChildren().add(borderPane);
    }

    private void exportTable(UserTableView tableView) throws IOException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", "*.xlsx"));

        File file = fileChooser.showSaveDialog(tableView.getScene().getWindow());

        if (file != null) {
            ExcelExporter.exportToExcel(tableView, "FXUserData", file.getAbsolutePath());
        }
    }

}

