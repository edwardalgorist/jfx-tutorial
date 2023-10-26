package com.coderscratchpad.javafxtutorial.datepicker;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.time.LocalDate;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-datepicker/">coderscratchpad.com</a>
 */
public class DatePickerRestrictingRange extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private final StackPane parent = new StackPane();

    @Override
    public void start(Stage stage) throws Exception {
        this.setupStage(stage);
    }

    @Override
    public void init() throws Exception {
        super.init();
        this.buildUI();
    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("JavaFX DatePicker");

        // Set the stage scene
        stage.setScene(scene);

        // Center stage on screen
        stage.centerOnScreen();

        // Show stage on screen
        stage.show();

    }

    private void buildUI() {

        DatePicker datePicker = new DatePicker();

        datePicker.setDayCellFactory(picker -> new DateCell() {

            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);

                LocalDate minDate = LocalDate.now().minusDays(5);
                LocalDate maxDate = LocalDate.now().plusDays(5);

                setDisable(date.isBefore(minDate) || date.isAfter(maxDate));

            }

        });

        this.parent.getChildren().addAll(datePicker);

    }

}