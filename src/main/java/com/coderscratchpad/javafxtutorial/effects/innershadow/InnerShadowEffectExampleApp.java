package com.coderscratchpad.javafxtutorial.effects.innershadow;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-innershadow-effect/">coderscratchpad.com</a>
 */
public class InnerShadowEffectExampleApp extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    /* The parent layout manager */
    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("InnerShadow Effect");

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
        imageView.setFitWidth(280);

        // Create the InnerShadow
        InnerShadow innerShadow = new InnerShadow();

        // Create the Control Panel for the InnerShadow
        InnerShadowControlPanel controlPanel = new InnerShadowControlPanel(innerShadow);

        // Apply the InnerShadow Effect to the ImageView
        imageView.setEffect(innerShadow);

        /* Add the ImageView to the BorderPane center region */
        this.parent.setCenter(imageView);
        BorderPane.setAlignment(imageView, Pos.CENTER_LEFT);
        BorderPane.setMargin(imageView, new Insets(20));

        /* Add the InnerShadowControlPanel to the BorderPane left region */
        this.parent.setLeft(controlPanel);

    }

}