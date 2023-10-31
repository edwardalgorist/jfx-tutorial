package com.coderscratchpad.javafxtutorial.effects;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-coloradjust-effect/">coderscratchpad.com</a>
 */
public class ColorAdjustControlPanel extends VBox {

    public ColorAdjustControlPanel(ColorAdjust colorAdjust) {
        super(5);

        // Create sliders for adjusting color properties
        Slider brightnessSlider = new Slider(-1.0, 1.0, 0.0);
        Slider contrastSlider = new Slider(-1.0, 1.0, 0.0);
        Slider hueSlider = new Slider(-1.0, 1.0, 0.0);
        Slider saturationSlider = new Slider(-1.0, 1.0, 0.0);

        // Bind the sliders to ColorAdjust properties
        colorAdjust.brightnessProperty().bind(brightnessSlider.valueProperty());
        colorAdjust.contrastProperty().bind(contrastSlider.valueProperty());
        colorAdjust.hueProperty().bind(hueSlider.valueProperty());
        colorAdjust.saturationProperty().bind(saturationSlider.valueProperty());

        // Create a VBox to arrange Sliders
        this.getChildren().addAll(
                this.createLabeledSlider(brightnessSlider, "Brightness"),
                this.createLabeledSlider(contrastSlider, "Contrast"),
                this.createLabeledSlider(hueSlider, "Hue"),
                this.createLabeledSlider(saturationSlider, "Saturation")
        );

        this.setAlignment(Pos.CENTER_LEFT);
        this.setPadding(new Insets(15));

    }

    private HBox createLabeledSlider(Slider slider, String label) {

        Label value = new Label();
        value.setMinWidth(30);

        // Format the slider value with two decimal places
        value.textProperty().bind(slider.valueProperty().asString("%.2f"));

        Label lblLabel = new Label(String.format("%-10s", label));
        lblLabel.setMinWidth(75);

        // Create the HBox to arrange UI components
        HBox container = new HBox(lblLabel, slider, value);
        container.setAlignment(Pos.CENTER);

        return container;

    }

}
