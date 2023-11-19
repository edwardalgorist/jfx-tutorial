package com.coderscratchpad.javafxtutorial.toolbar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/how-to-create-a-toolbar-in-javafx/">coderscratchpad.com</a>
 */
public class BasicToolBar extends Application {

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

        // Create App Menu
        AppMenu menu = new AppMenu();

        // Create content BorderPane
        BorderPane contentPane = new BorderPane();

        // Create Toolbar
        ToolBar toolbar = new ToolBar();

        // Create Toolbar Buttons
        Button tbNew = new Button("New");
        Button tbOpen = new Button("Open");
        Button tbSave = new Button("Save");
        Button tbSaveAll = new Button("Save All");

        toolbar.getItems().addAll(tbNew, tbOpen, tbSave, tbSaveAll);

        // Add Toolbar to the top of the content BorderPane
        contentPane.setTop(toolbar);

        // Add Menu to the top of the primary layout BorderPane
        this.parent.setTop(menu);

        // Add content BorderPane to the center of the primary layout BorderPane
        this.parent.setCenter(contentPane);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("How to Create a Toolbar in JavaFX");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

    static class AppMenu extends MenuBar {

        public AppMenu() {

            // File Menu
            Menu mnuFile = new Menu("File");

            // File Menu Items
            MenuItem mnuNew = new MenuItem("New");
            MenuItem mnuOpen = new MenuItem("Open");
            MenuItem mnuClose = new MenuItem("Close");

            MenuItem mnuSettings = new MenuItem("Settings");

            MenuItem mnuSave = new MenuItem("Save");
            MenuItem mnuSaveAll = new MenuItem("Save All");

            MenuItem mnuExit = new MenuItem("Exit");

            mnuFile.getItems().addAll(
                    mnuNew, mnuOpen, mnuClose,
                    new SeparatorMenuItem(),
                    mnuSettings,
                    new SeparatorMenuItem(),
                    mnuSave,
                    mnuSaveAll,
                    new SeparatorMenuItem(),
                    mnuExit
            );

            this.getMenus().addAll(mnuFile);

        }

    }

}