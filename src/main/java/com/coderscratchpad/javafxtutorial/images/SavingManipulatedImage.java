package com.coderscratchpad.javafxtutorial.images;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-image-cropping-and-scaling/">coderscratchpad.com</a>
 */
public class SavingManipulatedImage extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    /* The parent layout manager */
    private final StackPane parent = new StackPane();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("Saving Manipulated Image");

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

        // Crop the image to a specific region
        Rectangle2D cropRegion = new Rectangle2D(270, 30, 400, 400);
        imageView.setViewport(cropRegion);

        // Scale the image proportionally to fit a specific width
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(350);

        Button btnSaveImage = new Button("Save Image");

        // Set save image button action using the SaveImageAction handler
        btnSaveImage.setOnAction(
                new SaveImageAction(imageView, "cropped-scaled.png", "png")
        );

        // Create a VBox container to hold the ImageView and Save Image Button
        VBox container = new VBox(10, imageView, btnSaveImage);
        container.setAlignment(Pos.CENTER);

        /* Add the VBox container to the StackPane */
        this.parent.getChildren().addAll(container);

    }

    static class SaveImageAction implements EventHandler<ActionEvent> {

        private final ImageView imageView;
        private final String outputPath;
        private final String formatName;

        public SaveImageAction(ImageView imageView, String outputPath, String formatName) {
            this.imageView = imageView;
            this.outputPath = outputPath;
            this.formatName = formatName;
        }

        @Override
        public void handle(ActionEvent actionEvent) {

            // Convert JavaFX Image to BufferedImage
            WritableImage image = this.imageView.snapshot(null, null);
            BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);

            File outputFile = new File(this.outputPath);

            try (FileOutputStream output = new FileOutputStream(outputFile)) {

                // Save the image using ImageIO
                ImageIO.write(bufferedImage, this.formatName, output);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}