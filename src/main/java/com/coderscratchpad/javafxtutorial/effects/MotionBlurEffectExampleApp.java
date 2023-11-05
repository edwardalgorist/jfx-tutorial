package com.coderscratchpad.javafxtutorial.effects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Builder;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-motionblur-effect/">coderscratchpad.com</a>
 */
public class MotionBlurEffectExampleApp extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    /* The parent layout manager */
    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("MotionBlur Effect");

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
        Slider sliderAngle = new Slider(0, 360, 90);
        Slider sliderRadius = new Slider(0, 63, 10);

        // Create the MotionBlur Effect
        MotionBlur motionBlur = new MotionBlur();

        // Bind MotionBlur properties to the Sliders value property
        motionBlur.angleProperty().bind(sliderAngle.valueProperty());
        motionBlur.radiusProperty().bind(sliderRadius.valueProperty());

        // Apply the MotionBlur Effect to the ImageView
        imageView.setEffect(motionBlur);

        /* Add the ImageView to the BorderPane center region */
        this.parent.setRight(imageView);
        BorderPane.setAlignment(imageView, Pos.CENTER);
        BorderPane.setMargin(imageView, new Insets(15));

        /* Create a VBox container to arrange angle, and radius sliders */
        VBox controlPanel = new VBox(
                5,
                (new LabeledValueSlider(sliderAngle, "Angle")).build(),
                (new LabeledValueSlider(sliderRadius, "Radius")).build()
        );

        controlPanel.setAlignment(Pos.CENTER);
        controlPanel.setPadding(new Insets(17.0));

        // Add the ControlPane to the BorderPane left region
        this.parent.setLeft(controlPanel);

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
            value.setMinWidth(50);

            // Format the slider value with two decimal places
            value.textProperty().bind(this.slider.valueProperty().asString("%.0f"));

            Label lblLabel = new Label(String.format("%-10s",this.label));

            // Create the HBox to arrange UI components
            HBox container = new HBox(5, lblLabel, this.slider, value);
            container.setAlignment(Pos.CENTER);

            return container;

        }

    }

}