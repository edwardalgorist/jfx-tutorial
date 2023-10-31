package com.coderscratchpad.javafxtutorial.effects;

import javafx.beans.property.DoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-dropshadow-effect/">coderscratchpad.com</a>
 */
public class DropShadowControlPanel extends VBox {

    public DropShadowControlPanel(DropShadow dropShadow) {
        super(5);

        // Create BlurTypes Collection
        ObservableList<BlurType> blurTypes = FXCollections.observableArrayList(
                BlurType.GAUSSIAN,
                BlurType.ONE_PASS_BOX,
                BlurType.TWO_PASS_BOX,
                BlurType.THREE_PASS_BOX
        );

        // Create BlurType ComboBox, and provide the created BlurTypes
        ComboBox<BlurType> blurTypeComboBox = new ComboBox<>(blurTypes);
        blurTypeComboBox.getSelectionModel().selectFirst(); // Select the first BlurType

        // Bind the DropShadow blurTypeProperty to the ComboBox valueProperty
        dropShadow.blurTypeProperty().bind(blurTypeComboBox.valueProperty());

        // Create the HBox to arrange the Label, and BlurType ComboBox
        HBox blurTypeContainer = this.createLabeledNode(5, blurTypeComboBox, "Blur Type");


        // Create the ColorPicker, and set BLACK as the default color
        ColorPicker colorPicker = new ColorPicker(Color.BLACK);

        // Create the HBox to arrange the Label, and the ColorPicker
        HBox colorContainer = this.createLabeledNode( 13, colorPicker, "Color" );

        // Bind the DropShadow colorProperty to the ColorPicker valueProperty
        dropShadow.colorProperty().bind(colorPicker.valueProperty());

        // Create a VBox to arrange Sliders, the BlurType ComboBox, and the ColorPicker
        this.getChildren().addAll(
                this.createLabeledBoundSlider(dropShadow.offsetXProperty(),"Offset X", 0, 100, 0),
                this.createLabeledBoundSlider(dropShadow.offsetYProperty(),"Offset Y", 0, 100, 0),
                this.createLabeledBoundSlider(dropShadow.widthProperty(), "Width", 0, 255, 21),
                this.createLabeledBoundSlider(dropShadow.heightProperty(),"Height",0, 255, 21),
                this.createLabeledBoundSlider(dropShadow.radiusProperty(), "Radius",0, 127, 10),
                this.createLabeledBoundSlider(dropShadow.spreadProperty(), "Spread",0.0, 1.0, 0.0),
                blurTypeContainer,
                colorContainer
        );

        this.setAlignment(Pos.CENTER_LEFT);
        this.setPadding(new Insets(15));

    }

    private HBox createLabeledBoundSlider(DoubleProperty property, String label, double min, double max, double defaultValue) {

        Slider slider = new Slider(min, max, defaultValue);
        property.bind(slider.valueProperty());

        Label value = new Label();
        value.setMinWidth(50);

        // Format the slider value with two decimal places
        value.textProperty().bind(slider.valueProperty().asString("%.2f"));

        Label lblLabel = new Label(String.format("%-20s", label));
        lblLabel.setMinWidth(80);
        lblLabel.setAlignment(Pos.CENTER_RIGHT);

        // Create the HBox to arrange UI components

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
