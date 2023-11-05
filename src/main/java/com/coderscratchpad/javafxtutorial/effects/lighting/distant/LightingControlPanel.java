package com.coderscratchpad.javafxtutorial.effects.lighting.distant;

import javafx.beans.property.DoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-lighting-effect-light-distant/">coderscratchpad.com</a>
 */
public class LightingControlPanel extends VBox {

    /**
     * Constructor for the LightingControlPanel.
     *
     * @param lighting The Lighting object to configure.
     * @param distantLight The Distant Light object to configure.
     */
    public LightingControlPanel(Lighting lighting, Light.Distant distantLight) {
        super(15);

        // Create a label for lighting properties
        Label lightingPropertiesHeader = new Label("Lighting Properties");
        lightingPropertiesHeader.setFont(new Font(18.0));

        // Create a VBox for lighting properties with sliders
        VBox lightingProperties = new VBox(
                5,
                lightingPropertiesHeader,
                createLabeledBoundSlider(lighting.diffuseConstantProperty(), "Diffuse Constant", 2.0, 1.0),
                createLabeledBoundSlider(lighting.specularConstantProperty(), "Specular Constant", 2.0, 0.3),
                createLabeledBoundSlider(lighting.specularExponentProperty(), "Specular Exponent", 40.0, 20.0),
                createLabeledBoundSlider(lighting.surfaceScaleProperty(), "Surface Scale", 10.0, 1.5)
        );

        // Create a label for distant light properties
        Label distantLightPropertiesHeader = new Label("Light.Distant Properties");
        distantLightPropertiesHeader.setFont(new Font(18.0));

        // Create the ColorPicker, and set BLACK as the default color
        ColorPicker colorPicker = new ColorPicker(Color.BLACK);

        // Bind the Light.Distant colorProperty to the ColorPicker valueProperty
        distantLight.colorProperty().bind(colorPicker.valueProperty());

        // Create the HBox to arrange the Label, and the ColorPicker
        HBox colorContainer = this.createLabeledNode( 40, colorPicker, "Color" );

        // Create a VBox for distant light properties with sliders
        VBox distantLightProperties = new VBox(
                5,
                distantLightPropertiesHeader,
                createLabeledBoundSlider(distantLight.azimuthProperty(), "Azimuth", 360.0, 45.0),
                createLabeledBoundSlider(distantLight.elevationProperty(), "Elevation", 360.0, 45.0),
                colorContainer
        );

        // Add lighting and distant light property sections to the main VBox
        getChildren().addAll(
                lightingProperties,
                distantLightProperties
        );

        // Set alignment and padding for the control panel
        setAlignment(Pos.CENTER_LEFT);
        setPadding(new Insets(15));
    }

    /**
     * Create an HBox with a labeled bound slider for a property.
     *
     * @param property The DoubleProperty to bind to the slider.
     * @param label The label for the slider.
     * @param max The maximum value for the slider.
     * @param defaultValue The default value for the slider.
     * @return An HBox containing the labeled slider and its value label.
     */
    private HBox createLabeledBoundSlider(DoubleProperty property, String label, double max, double defaultValue) {
        Slider slider = new Slider(0.0, max, defaultValue);
        property.bind(slider.valueProperty());

        Label value = new Label();
        value.setMinWidth(50);
        value.textProperty().bind(slider.valueProperty().asString("%.2f"));

        Label lblLabel = new Label(String.format("%-20s", label));
        lblLabel.setMinWidth(110);
        lblLabel.setAlignment(Pos.CENTER_LEFT);

        return new HBox(5, lblLabel, slider, value);
    }

    private HBox createLabeledNode(double spacing, Node node, String label) {

        HBox container = new HBox(
                spacing,
                new Label(String.format("%-20s", label)),
                node
        );

        container.setAlignment(Pos.CENTER_LEFT);

        return container;

    }

}