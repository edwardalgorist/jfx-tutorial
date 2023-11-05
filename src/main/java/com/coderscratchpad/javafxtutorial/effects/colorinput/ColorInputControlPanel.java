package com.coderscratchpad.javafxtutorial.effects.colorinput;

import javafx.beans.property.DoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorInput;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-colorinput-effect/">coderscratchpad.com</a>
 */
public class ColorInputControlPanel extends VBox {

    public ColorInputControlPanel(ColorInput colorInput, double width, double height) {
        super(5);

        // Create the ColorPicker, and set BLACK as the default color
        ColorPicker colorPicker = new ColorPicker(Color.BLACK);

        // Create the HBox container to arrange the Label, and the ColorPicker
        HBox colorContainer = new HBox(
                13,
                new Label(String.format("%-15s", "Color")),
                colorPicker
        );

        colorContainer.setAlignment(Pos.CENTER_LEFT);

        // Bind the ColorInput paintProperty to the ColorPicker valueProperty
        colorInput.paintProperty().bind(colorPicker.valueProperty());

        // Create a VBox to arrange the Sliders, and the ColorPicker
        this.getChildren().addAll(
                this.createLabeledBoundSlider(colorInput.xProperty(),"X", width / 2),
                this.createLabeledBoundSlider(colorInput.yProperty(),"Y", height / 2),
                this.createLabeledBoundSlider(colorInput.widthProperty(), "Width", width),
                this.createLabeledBoundSlider(colorInput.heightProperty(),"Height", height),
                colorContainer
        );

        this.setAlignment(Pos.CENTER_LEFT);
        this.setPadding(new Insets(15));

    }

    private HBox createLabeledBoundSlider(DoubleProperty property, String label, double max) {

        // 0 min, and 0 default
        Slider slider = new Slider(0, max, 0);
        property.bind(slider.valueProperty());

        Label value = new Label();
        value.setMinWidth(50);

        // Format the slider value with two decimal places
        value.textProperty().bind(slider.valueProperty().asString("%.2f"));

        Label lblLabel = new Label(String.format("%-15s", label));
        lblLabel.setMinWidth(65);
        lblLabel.setAlignment(Pos.CENTER_LEFT);

        // Create the HBox to arrange UI components
        return new HBox(5, lblLabel, slider, value);

    }
}
