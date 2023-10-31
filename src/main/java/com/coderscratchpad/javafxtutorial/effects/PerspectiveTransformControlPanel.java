package com.coderscratchpad.javafxtutorial.effects;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-perspectivetransform-effect/">coderscratchpad.com</a>
 */
public class PerspectiveTransformControlPanel extends VBox {

    public PerspectiveTransformControlPanel(PerspectiveTransform transform) {
        super(5);

        // Create sliders for adjusting PerspectiveTransform properties
        Slider upperLeftX = new Slider(0, 300, 171);
        Slider upperLeftY = new Slider(0, 300, 45);
        Slider upperRightX = new Slider(0, 300, 76);
        Slider upperRightY = new Slider(0, 300, 19);

        Slider lowerLeftX = new Slider(0, 300, 160);
        Slider lowerLeftY = new Slider(0, 300, 264);
        Slider lowerRightX = new Slider(0, 300, 98);
        Slider lowerRightY = new Slider(0, 300, 295);

        // Bind the sliders to PerspectiveTransform properties
        transform.ulxProperty().bind(upperLeftX.valueProperty());
        transform.ulyProperty().bind(upperLeftY.valueProperty());
        transform.urxProperty().bind(upperRightX.valueProperty());
        transform.uryProperty().bind(upperRightY.valueProperty());

        transform.llxProperty().bind(lowerLeftX.valueProperty());
        transform.llyProperty().bind(lowerLeftY.valueProperty());
        transform.lrxProperty().bind(lowerRightX.valueProperty());
        transform.lryProperty().bind(lowerRightY.valueProperty());

        // Create a VBox to arrange Sliders
        this.getChildren().addAll(
                this.createLabeledSlider(upperLeftX, "Upper Left X"),
                this.createLabeledSlider(upperLeftY, "Upper Left Y"),
                this.createLabeledSlider(upperRightX, "Upper Right X"),
                this.createLabeledSlider(upperRightY, "Upper Right Y"),
                this.createLabeledSlider(lowerLeftX, "Lower Left X"),
                this.createLabeledSlider(lowerLeftY, "Lower Left Y"),
                this.createLabeledSlider(lowerRightX, "Lower Right X"),
                this.createLabeledSlider(lowerRightY, "Lower Right Y")
        );

        this.setAlignment(Pos.CENTER_LEFT);
        this.setPadding(new Insets(15));

    }

    private HBox createLabeledSlider(Slider slider, String label) {

        Label value = new Label();
        value.setMinWidth(50);

        // Format the slider value with two decimal places
        value.textProperty().bind(slider.valueProperty().asString("%.0f"));

        Label lblLabel = new Label(String.format("%20s", label));
        lblLabel.setMinWidth(80);
        lblLabel.setAlignment(Pos.CENTER_RIGHT);

        // Create the HBox to arrange UI components
        HBox container = new HBox(5, lblLabel, slider, value);
        container.setAlignment(Pos.CENTER);

        return container;

    }

}
