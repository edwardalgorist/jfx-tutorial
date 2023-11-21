package com.coderscratchpad.javafxtutorial.ribbonmenus;

import com.pixelduke.control.Ribbon;
import com.pixelduke.control.ribbon.RibbonGroup;
import com.pixelduke.control.ribbon.RibbonTab;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Builder;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/ribbon-menus-in-javafx/">coderscratchpad.com</a>
 */
public class RibbonMenuQuickAccessBar extends Application {

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

        // Add a RibbonGroup to the "File" tab
        fileTab.getRibbonGroups().add(new FileGroup("File"));

        // Add the tabs to the Ribbon
        ribbon.getTabs().addAll(fileTab, editTab);

        // Create quick access buttons
        Button newButton = new QuickAccessButtonBuilder("new.png", null).build();
        Button openButton = new QuickAccessButtonBuilder("open.png", null).build();
        Button saveButton = new QuickAccessButtonBuilder("save.png", null).build();

        ribbon.getQuickAccessBar().getButtons().addAll(
                newButton, openButton, saveButton
        );

        // Add the Ribbon to the center of the parent layout
        this.parent.setCenter(ribbon);

    }

    static class FileGroup extends RibbonGroup {

        public FileGroup(String title) {

            // Set the title for the RibbonGroup
            this.setTitle(title);

            // Create buttons and add event handlers
            Button newButton = new ButtonBuilder("New", "new.png", event -> System.out.println("New"))
                    .build();

            Button openButton = new ButtonBuilder("Open", "open.png", event -> System.out.println("Open"))
                    .build();

            Button saveButton = new ButtonBuilder("Save", "save.png", event -> System.out.println("Save"))
                    .build();

            // Add buttons to the RibbonGroup
            this.getNodes().addAll(newButton, openButton, saveButton);
        }

    }

    static class QuickAccessButtonBuilder implements Builder<Button> {

        private final Button button;

        public QuickAccessButtonBuilder(String imagePath, EventHandler<ActionEvent> eventHandler) {

            this.button = new Button();

            ImageView image = new ImageView(new Image(imagePath));
            image.setFitWidth(15.0);
            image.setFitHeight(15.0);

            // Set the image as the button's graphic
            this.button.setGraphic(image);

            // Display only the graphic
            this.button.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

            // Set the event handler for the button
            this.button.setOnAction(eventHandler);
        }

        @Override
        public Button build() {

            // Build and return the button
            return this.button;
        }
    }

    static class ButtonBuilder implements Builder<Button> {

        private final Button button;

        public ButtonBuilder(String label, String imagePath, EventHandler<ActionEvent> eventHandler) {

            // Create a button with a label
            this.button = new Button(label);

            // Create an ImageView with an image
            ImageView image = new ImageView(new Image(imagePath));
            image.setFitWidth(30.0);
            image.setFitHeight(30.0);

            // Set the image as the button's graphic
            this.button.setGraphic(image);

            // Display the label on top of the image
            this.button.setContentDisplay(ContentDisplay.TOP);

            // Set the event handler for the button
            this.button.setOnAction(eventHandler);
        }

        @Override
        public Button build() {

            // Build and return the button
            return this.button;
        }
    }
}