package com.coderscratchpad.javafxtutorial.ribbonmenus;

import com.pixelduke.control.Ribbon;
import com.pixelduke.control.ribbon.RibbonTab;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/ribbon-menus-in-javafx/">coderscratchpad.com</a>
 */
public class BasicRibbonMenu extends Application {

    // The parent layout manager
    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(parent, 640, 480);

        // Set the stage title
        stage.setTitle("Ribbon Menus in JavaFX");

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

    private void buildUI() {

        // Create a Ribbon control
        Ribbon ribbon = new Ribbon();

        // Create a "File" Ribbon Tab
        RibbonTab fileTab = new RibbonTab("File");

        // Create an "Edit" Ribbon Tab
        RibbonTab editTab = new RibbonTab("Edit");

        // Add the tabs to the Ribbon
        ribbon.getTabs().addAll(fileTab, editTab);

        // Add the Ribbon to the center of the parent layout
        this.parent.setCenter(ribbon);
    }

}