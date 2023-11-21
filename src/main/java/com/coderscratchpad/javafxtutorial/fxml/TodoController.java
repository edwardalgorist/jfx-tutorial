package com.coderscratchpad.javafxtutorial.fxml;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-and-fxml-separating-ui-from-logic/">coderscratchpad.com</a>
 */
public class TodoController {

    // Reference to the TextField for task input
    @FXML
    private TextField taskInput;

    // Reference to the ListView for displaying tasks
    @FXML
    private ListView<String> taskList;

    @FXML
    public void addTask() {

        // Retrieve the task text from the input field
        // and trim any leading/trailing spaces
        String task = taskInput.getText().trim();

        // Check if the task is not empty
        if (!task.isEmpty()) {

            // Add the task to the ListView
            taskList.getItems().add(task);

            // Clear the input field for the next task
            taskInput.clear();

        }

    }

}