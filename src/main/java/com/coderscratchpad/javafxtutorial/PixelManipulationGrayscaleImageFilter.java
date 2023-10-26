package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-grayscale-image-filter/">coderscratchpad.com</a>
 */
public class PixelManipulationGrayscaleImageFilter extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    /* The parent layout manager */
    private final StackPane parent = new StackPane();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("Pixel Manipulation Grayscale Image Filter");

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

        // Load the image
        GrayscaleConverter converter = new GrayscaleConverter("scorpion.jpg");
        WritableImage image = converter.convert();

        ImageView imageView = new ImageView(image);

        // Scaling the image proportionally
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(400);

        /* Add the ImageView to the StackPane */
        this.parent.getChildren().addAll(imageView);

    }

    static class GrayscaleConverter {

        // The resulting grayscale image
        private final WritableImage grayscaleImage;

        public GrayscaleConverter(String imagePath) {

            // Load the original image from the provided file path
            Image image = new Image(imagePath);

            // Get the width and height of the original image
            int width = (int) image.getWidth();
            int height = (int) image.getHeight();

            // Create the grayscale image using the provided methods
            this.grayscaleImage = createGrayscaleImage(image, width, height);
        }

        // Get the grayscale image
        public WritableImage convert() {
            return this.grayscaleImage;
        }

        // Create a grayscale image based on the original image
        private WritableImage createGrayscaleImage(Image image, int width, int height) {

            // Create a WritableImage to store the grayscale version
            WritableImage grayImage = new WritableImage(width, height);
            // Obtain a reader to read pixels from the original image
            PixelReader pixelReader = image.getPixelReader();

            // Obtain a writer to write pixels to the grayscale image
            PixelWriter pixelWriter = grayImage.getPixelWriter();

            // Iterate over each pixel in the original image
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {

                    // Get the color of the current pixel
                    Color color = pixelReader.getColor(x, y);

                    // Calculate the grayscale color for the current pixel
                    Color grayColor = calculateGrayscaleColor(color);

                    // Write the grayscale color to the grayscale image
                    pixelWriter.setColor(x, y, grayColor);
                }
            }

            // Return the grayscale image
            return grayImage;

        }

        // Calculate a grayscale color based on the RGB values of the original color
        private Color calculateGrayscaleColor(Color color) {

            // Calculate the grayscale value by averaging the RGB components
            double grayscaleValue = (color.getRed() + color.getGreen() + color.getBlue()) / 3.0;

            // Create a grayscale color with the calculated value for all RGB components
            return Color.color(grayscaleValue, grayscaleValue, grayscaleValue);

        }

    }

}
