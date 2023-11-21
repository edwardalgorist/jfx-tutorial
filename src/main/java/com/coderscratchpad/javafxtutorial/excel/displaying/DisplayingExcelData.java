package com.coderscratchpad.javafxtutorial.excel.displaying;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.Objects;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/displaying-excel-data-in-javafx/">coderscratchpad.com</a>
 */
public class DisplayingExcelData extends Application {

    // The parent layout manager
    private final StackPane parent = new StackPane();

    @Override
    public void start(Stage stage) throws Exception {

        // Create a scene with the StackPane as the root
        Scene scene = new Scene(parent, 640, 480);

        // Set the stage title
        stage.setTitle("Displaying Excel Data in JavaFX");

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

        String path = Objects.requireNonNull(this.getClass().getClassLoader().getResource("sample.xlsx")).getPath();

        // Create a UserExcelFileReader to read data from the Excel file
        UserExcelFileReader reader = new UserExcelFileReader(path);
        ObservableList<UserExcelFileReader.User> users = reader.getUsers();

        // Create a UserTableView to display the data
        UserTableView userTableView = new UserTableView(users);

        // Add the TableView to the parent layout
        this.parent.getChildren().add(userTableView);
    }

}

class UserTableView extends TableView<UserExcelFileReader.User> {

    public UserTableView(ObservableList<UserExcelFileReader.User> users) {
        super(users);

        // Create TableColumn instances for each attribute
        TableColumn<UserExcelFileReader.User, Integer> idColumn = this.createColumn("ID", "id");
        TableColumn<UserExcelFileReader.User, String> firstNameColumn = this.createColumn("First Name", "firstName");
        TableColumn<UserExcelFileReader.User, String> lastNameColumn = this.createColumn("Last Name", "lastName");
        TableColumn<UserExcelFileReader.User, String> genderColumn = this.createColumn("Gender", "gender");
        TableColumn<UserExcelFileReader.User, String> countryColumn = this.createColumn("Country", "country");
        TableColumn<UserExcelFileReader.User, Integer> ageColumn = this.createColumn("Age", "age");
        TableColumn<UserExcelFileReader.User, String> dateColumn = this.createColumn("Date", "date");

        // Add the TableColumn instances to the TableView
        this.getColumns().addAll(idColumn, firstNameColumn, lastNameColumn, genderColumn, countryColumn, ageColumn, dateColumn);
    }

    private <T> TableColumn<UserExcelFileReader.User, T> createColumn(String title, String property) {

        TableColumn<UserExcelFileReader.User, T> column = new TableColumn<>(title);
        column.setCellValueFactory(new PropertyValueFactory<>(property));
        return column;
    }

}