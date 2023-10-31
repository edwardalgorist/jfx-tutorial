package com.coderscratchpad.javafxtutorial.effects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Builder;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-glow-effect/">coderscratchpad.com</a>
 */
public class GlowEffectExampleApp extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    /* The parent layout manager */
    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("Glow Effect");

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
        imageView.setFitWidth(350);

        // Create the Slider to adjust the Glow level
        Slider sliderLevel = new Slider(0, 1, 0.3);

        // Create the Glow Effect, and bind its level property to the slider value property
        Glow glow = new Glow();
        glow.levelProperty().bind(sliderLevel.valueProperty());

        // Apply the Glow Effect to the ImageView
        imageView.setEffect(glow);

        /* Add the ImageView to the BorderPane right region */
        this.parent.setRight(imageView);
        BorderPane.setAlignment(imageView, Pos.CENTER);
        BorderPane.setMargin(imageView, new Insets(15));

        /* Create, and add the Level Panel to the BorderPane left region */
        HBox levelPanel = (new LabeledValueSlider(sliderLevel, "Level")).build();
        levelPanel.setPadding(new Insets(15.0));

        this.parent.setLeft(levelPanel);

    }

    static class LabeledValueSlider implements Builder<HBox> {

        private final Slider slider;
        private final String label;

        public LabeledValueSlider(Slider slider, String label) {
            this.slider = slider;
            this.label = label;
        }

        @Override
        public HBox build() {

            Label value = new Label();
            value.setMinWidth(30);

            // Format the slider value with two decimal places
            value.textProperty().bind(this.slider.valueProperty().asString("%.2f"));

            Label lblLabel = new Label(this.label);

            // Create the HBox to arrange UI components
            HBox container = new HBox(5, lblLabel, this.slider, value);
            container.setAlignment(Pos.CENTER);

            return container;

        }

    }

}