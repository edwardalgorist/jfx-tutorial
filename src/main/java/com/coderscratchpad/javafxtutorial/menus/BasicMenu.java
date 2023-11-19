package com.coderscratchpad.javafxtutorial.menus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-menus/">coderscratchpad.com</a>
 */
public class BasicMenu extends Application {

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

        // Create the MenuBar
        MenuBar menuBar = new MenuBar();

        // Create the File Menu
        Menu fileMenu = new Menu("File");

        // Create Menu Items for File Menu
        MenuItem openMenuItem = new MenuItem("Open");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem closeMenuItem = new MenuItem("Close");

        // Add Menu Items to the File menu
        fileMenu.getItems().addAll(openMenuItem, saveMenuItem, closeMenuItem);

        // Create the Edit Menu with a Submenu
        Menu editMenu = new Menu("Edit");

        // Create Menu Items for Edit Menu
        MenuItem cutMenuItem = new MenuItem("Cut");
        MenuItem copyMenuItem = new MenuItem("Copy");
        MenuItem pasteMenuItem = new MenuItem("Paste");

        // Create the Format Menu with Submenu
        Menu formatMenu = new Menu("Format");

        // Create Format Submenu Items
        MenuItem fontMenuItem = new MenuItem("Font");
        MenuItem uppercaseMenuItem = new MenuItem("UPPERCASE");
        MenuItem lowercaseMenuItem = new MenuItem("lowercase");

        // Add Submenu Items to the Format Menu
        formatMenu.getItems().addAll(fontMenuItem, uppercaseMenuItem, lowercaseMenuItem);

        // Add Menu Items to the Edit menu
        editMenu.getItems().addAll(cutMenuItem, copyMenuItem, pasteMenuItem, formatMenu);

        // Add both menus to the MenuBar
        menuBar.getMenus().addAll(fileMenu, editMenu);

        // Add MenuBar to the Top of the BorderPane
        this.parent.setTop(menuBar);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("JavaFX Menus");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}
