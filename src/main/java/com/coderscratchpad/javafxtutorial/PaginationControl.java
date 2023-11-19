package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-pagination-made-simple/">coderscratchpad.com</a>
 */
public class PaginationControl extends Application {

    private static final int ITEMS_PER_PAGE = 10;
    private static final int TOTAL_ITEMS = 100;

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

        Pagination pagination = new Pagination(TOTAL_ITEMS / ITEMS_PER_PAGE);

        pagination.setPageFactory(this::createPage);

        pagination.setMaxPageIndicatorCount(5);

        this.parent.setCenter(pagination);

    }

    private VBox createPage(int pageIndex) {

        int startIndex = pageIndex * ITEMS_PER_PAGE;

        int endIndex = Math.min(startIndex + ITEMS_PER_PAGE, TOTAL_ITEMS);

        VBox page = new VBox(10);
        page.setAlignment(Pos.CENTER);

        for (int i = startIndex; i < endIndex; i++) {

            Label label = new Label("Item " + (i + 1));

            page.getChildren().add(label);

        }

        return page;

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("JavaFX Pagination Made Simple");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}