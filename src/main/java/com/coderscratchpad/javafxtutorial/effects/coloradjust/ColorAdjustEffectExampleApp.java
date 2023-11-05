package com.coderscratchpad.javafxtutorial.effects.coloradjust;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-coloradjust-effect/">coderscratchpad.com</a>
 */
public class ColorAdjustEffectExampleApp extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    /* The parent layout manager */
    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("ColorAdjust Effect");

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
        imageView.setFitWidth(330);

        // Create a ColorAdjust effect
        ColorAdjust colorAdjust = new ColorAdjust();

        ColorAdjustControlPanel colorAdjustControlPanel = new ColorAdjustControlPanel(colorAdjust);

        // Set the ColorAdjust effect on the ImageView
        imageView.setEffect(colorAdjust);

        /* Add the ImageView to the BorderPane right region */
        this.parent.setRight(imageView);
        BorderPane.setAlignment(imageView,Pos.CENTER);
        BorderPane.setMargin(imageView, new Insets(15));

        this.parent.setLeft(colorAdjustControlPanel);

    }

}

