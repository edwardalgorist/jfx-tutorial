package com.coderscratchpad.javafxtutorial.toolbar;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/how-to-create-a-toolbar-in-javafx/">coderscratchpad.com</a>
 */
public class ToolBarSeparators extends Application {

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

        // Create Toolbar Buttons with Icons
        Button tbNew = createButton("New", FontAwesomeIcon.PLUS);
        Button tbOpen = createButton("Open", FontAwesomeIcon.FOLDER_OPEN);
        Button tbSave = createButton("Save", FontAwesomeIcon.SAVE);
        Button tbSaveAll = createButton("Save All", FontAwesomeIcon.SAVE);

        // Adding Event Handlers to Buttons
        tbNew.setOnAction(this::onNew);
        tbOpen.setOnAction(this::onOpen);
        tbSave.setOnAction(this::onSave);
        tbSaveAll.setOnAction(this::onSaveAll);

        // Create a Separator
        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);

        toolbar.getItems().addAll(tbNew, tbOpen, separator, tbSave, tbSaveAll);

        // Add Toolbar to the top of the content BorderPane
        contentPane.setTop(toolbar);

        // Add Menu to the top of the primary layout BorderPane
        this.parent.setTop(menu);

        // Add content BorderPane to the center of the primary layout BorderPane
        this.parent.setCenter(contentPane);

    }

    private Button createButton(String text, FontAwesomeIcon fontAwesomeIcon) {

        FontAwesomeIconView icon = new FontAwesomeIconView(fontAwesomeIcon);

        icon.setSize("16px");

        Button button = new Button(text, icon);

        button.getStyleClass().add("toolbar-button");

        return button;

    }

    private void onSaveAll(ActionEvent actionEvent) {
        System.out.println("Saving all the Files...");
    }

    private void onSave(ActionEvent actionEvent) {
        System.out.println("Saving File...");
    }

    private void onOpen(ActionEvent actionEvent) {
        System.out.println("Opening File...");
    }

    private void onNew(ActionEvent actionEvent) {
        System.out.println("New File Created...");
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

    class AppMenu extends MenuBar {

        public AppMenu() {

            // File Menu
            Menu mnuFile = new Menu("File");

            // File Menu Items
            MenuItem mnuNew = new MenuItem("New");

            // Add event handler to the new menu item
            mnuNew.setOnAction(ToolBarSeparators.this::onNew);

            MenuItem mnuOpen = new MenuItem("Open");

            // Add event handler to the open menu item
            mnuOpen.setOnAction(ToolBarSeparators.this::onOpen);

            MenuItem mnuClose = new MenuItem("Close");

            MenuItem mnuSettings = new MenuItem("Settings");

            MenuItem mnuSave = new MenuItem("Save");

            // Add event handler to the save menu item
            mnuSave.setOnAction(ToolBarSeparators.this::onSave);

            MenuItem mnuSaveAll = new MenuItem("Save All");

            // Add event handler to the save all menu item
            mnuSaveAll.setOnAction(ToolBarSeparators.this::onSaveAll);

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