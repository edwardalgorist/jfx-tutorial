package com.coderscratchpad.javafxtutorial.excel.exporting;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/exporting-javafx-table-data-to-excel/">coderscratchpad.com</a>
 */
public class UserTableView extends TableView<User> {

    public UserTableView(ObservableList<User> users) {
        super(users);

        // Create TableColumn instances for each attribute
        TableColumn<User, Integer> idColumn = this.createColumn("ID", "id");
        TableColumn<User, String> nameColumn = this.createColumn("Name", "name");
        TableColumn<User, Integer> ageColumn = this.createColumn("Age", "age");
        TableColumn<User, String> genderColumn = this.createColumn("Gender", "gender");
        TableColumn<User, String> languageColumn = this.createColumn("Language", "language");
        TableColumn<User, String> countryColumn = this.createColumn("Country", "country");

        // Add the TableColumn instances to the TableView
        this.getColumns().addAll(idColumn, nameColumn, ageColumn, genderColumn, languageColumn, countryColumn);
    }

    private <T> TableColumn<User, T> createColumn(String title, String property) {
        TableColumn<User, T> column = new TableColumn<>(title);
        column.setCellValueFactory(new PropertyValueFactory<>(property));
        return column;
    }
}
