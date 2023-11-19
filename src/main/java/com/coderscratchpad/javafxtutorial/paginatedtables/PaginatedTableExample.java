package com.coderscratchpad.javafxtutorial.paginatedtables;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/handling-big-data-with-javafx-paginated-tables/">coderscratchpad.com</a>
 */
public class PaginatedTableExample extends Application {

    // Adjust the number of items per page as needed
    private static final int ITEMS_PER_PAGE = 10;

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

        TableView<Student> tableView = new TableView<>();

        TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
        TableColumn<Student, Integer> ageColumn = new TableColumn<>("Age");
        TableColumn<Student, String> gradeColumn = new TableColumn<>("Grade");

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));

        tableView.getColumns().addAll(nameColumn, ageColumn, gradeColumn);

        // Replace this with your actual data list
        ObservableList<Student> data = generateDummyData();

        // Wrap the data in a paginated list
        PaginatedList<Student> paginatedData = new PaginatedList<>(data, ITEMS_PER_PAGE);

        // Set the data for the current page
        tableView.setItems(paginatedData.getCurrentPageData());

        // Set the TableView's row height to a fixed value (in pixels)
        tableView.setFixedCellSize(25);

        // Bind the preferred height of the TableView to the size of its content (rows).
        // This ensures that the TableView height adjusts dynamically based on the number of rows.
        // We add a small buffer (1.01) to provide a little extra space at the bottom.
        tableView.prefHeightProperty().bind(
                tableView.fixedCellSizeProperty().multiply(Bindings.size(tableView.getItems()).add(1.01))
        );

        // Create the Pagination control
        Pagination pagination = new Pagination(paginatedData.getTotalPages());

        // Set the maximum number of page indicators shown
        pagination.setMaxPageIndicatorCount(5);

        // Listener to update the TableView when the page changes
        pagination.currentPageIndexProperty().addListener((observable, oldValue, newValue) -> {

            paginatedData.setCurrentPageIndex(newValue.intValue());

            tableView.setItems(paginatedData.getCurrentPageData());

        });

        VBox tableViewContainer = new VBox(tableView, pagination);

        this.parent.setCenter(tableViewContainer);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("Handling Big Data with JavaFX Paginated Tables");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

    // Generate some dummy data
    private ObservableList<Student> generateDummyData() {

        ObservableList<Student> data = FXCollections.observableArrayList();

        for (int i = 1; i <= 100; i++) {

            Student student = new Student("Student " + i, i, "Grade " + i);

            data.add(student);

        }

        return data;

    }

}