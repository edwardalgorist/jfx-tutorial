package com.coderscratchpad.javafxtutorial.effects.perspectivetransform;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-perspectivetransform-effect/">coderscratchpad.com</a>
 */
public class PerspectiveTransformEffectExampleApp extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    /* The parent layout manager */
    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("PerspectiveTransform Effect");

        // Set the stage scene
        stage.setScene(scene);

        // Center stage on screen
        stage.centerOnScreen();

        // Show stage on screen
        stage.show();

    }

    @Override
    public void init() throws Exception {
        super.init();

        Image image = new Image("scorpion.jpg");

        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(400);

        // Create the PerspectiveTransform
        PerspectiveTransform perspectiveTransform = new PerspectiveTransform();

        // Create the Control Panel for the PerspectiveTransform
        PerspectiveTransformControlPanel controlPanel = new PerspectiveTransformControlPanel(perspectiveTransform);

        // Apply the PerspectiveTransform Effect to the ImageView
        imageView.setEffect(perspectiveTransform);

        /* Add the ImageView to the BorderPane right region */
        this.parent.setRight(imageView);
        BorderPane.setAlignment(imageView, Pos.CENTER);
        BorderPane.setMargin(imageView, new Insets(15));

        /* Add the PerspectiveTransformControlPanel to the BorderPane left region */
        this.parent.setLeft(controlPanel);

    }

}