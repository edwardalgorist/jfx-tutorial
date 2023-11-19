package com.coderscratchpad.javafxtutorial.tilepane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-tilepane-tile-arrangements-for-ui-elements/">coderscratchpad.com</a>
 */
public class BasicTilePane extends Application {

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

        // Create the TilePane
        TilePane tilePane = new TilePane();

        // Set horizontal gap between tiles
        tilePane.setHgap(10);

        // Set vertical gap between tiles
        tilePane.setVgap(10);

        // Set preferred number of columns
        tilePane.setPrefColumns(3);

        // Add ImageViews to the TilePane
        for (int i = 1; i <= 12; i++) {

            Image image = new Image("image" + i + ".jpg");

            ImageView imageView = new ImageView(image);

            imageView.setFitWidth(150);

            imageView.setFitHeight(150);

            tilePane.getChildren().add(imageView);

        }

        // Add the TilePane to the BorderPane
        this.parent.setCenter(tilePane);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX TilePane: Tile Arrangements for UI Elements");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}