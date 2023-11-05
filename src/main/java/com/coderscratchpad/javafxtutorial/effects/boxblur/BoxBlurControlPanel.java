package com.coderscratchpad.javafxtutorial.effects.boxblur;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-boxblur-effect/">coderscratchpad.com</a>
 */
public class BoxBlurControlPanel extends VBox {

    public BoxBlurControlPanel(BoxBlur boxBlur) {
        super(5);

        // Create sliders for adjusting BoxBlur properties
        Slider width = new Slider(0, 255, 5);
        Slider height = new Slider(0, 255, 5);
        Slider iterations = new Slider(0, 3, 1);

        // Bind the sliders to BoxBlur properties
        boxBlur.widthProperty().bind(width.valueProperty());
        boxBlur.heightProperty().bind(height.valueProperty());
        boxBlur.iterationsProperty().bind(iterations.valueProperty());

        // Create a VBox to arrange Sliders
        this.getChildren().addAll(
                this.createLabeledSlider(width, "Width"),
                this.createLabeledSlider(height, "Height"),
                this.createLabeledSlider(iterations, "Iterations")
        );

        this.setAlignment(Pos.CENTER_LEFT);
        this.setPadding(new Insets(15));

    }

    private HBox createLabeledSlider(Slider slider, String label) {

        Label value = new Label();
        value.setMinWidth(30);

        // Format the slider value with two decimal places
        value.textProperty().bind(slider.valueProperty().asString("%.0f"));

        Label lblLabel = new Label(String.format("%-10s", label));

        // Create the HBox to arrange UI components
        HBox container = new HBox(5, lblLabel, slider, value);
        container.setAlignment(Pos.CENTER);

        return container;

    }

}
