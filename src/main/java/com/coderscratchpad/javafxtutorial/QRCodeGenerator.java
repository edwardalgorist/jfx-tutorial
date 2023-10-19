package com.coderscratchpad.javafxtutorial;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Builder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-qr-code-generation/">coderscratchpad.com</a>
 */
public class QRCodeGenerator extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private static final int QR_CODE_SIZE = 300;
    private static final String CONTENT_TO_ENCODE = "JavaFX QR Code Generator";

    private final StackPane parent = new StackPane();

    @Override
    public void init() throws Exception {
        super.init();
        this.buildUI();
    }

    private void buildUI() {

        QRGenerator qrGenerator;

        try {

            qrGenerator = new QRGenerator(
                    CONTENT_TO_ENCODE,
                    BarcodeFormat.QR_CODE,
                    QR_CODE_SIZE, QR_CODE_SIZE,
                    BufferedImage.TYPE_INT_ARGB
            );

        } catch (WriterException e) {

            e.printStackTrace();
            return;

        }

        BufferedImage qrImage = qrGenerator.qrImage();

        // Save QR code as an image file (optional)
        try {

            qrGenerator.save("qrcode.png", "PNG");

        } catch (IOException e) {

            e.printStackTrace();

        }

        Image image = SwingFXUtils.toFXImage(qrImage, null);

        // Display QR code in JavaFX window
        ImageView imageView = new ImageView(image);

        parent.getChildren().add(imageView);

    }

    @Override
    public void start(Stage stage) throws Exception {
        this.setupStage(stage);
    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("JavaFX QR Code Generator");

        // Sets the stage scene
        stage.setScene(scene);

        // Centers stage on screen
        stage.centerOnScreen();

        // Show stage on screen
        stage.show();

    }

}

class QRGenerator {

    private final BitMatrix bitMatrix;

    private BufferedImage qrImage;

    public QRGenerator(String data, BarcodeFormat format, int width, int height, int imageType) throws WriterException {

        BitMatrixBuilder builder = new BitMatrixBuilder(data, format, width, height);
        this.bitMatrix = builder.build();

        this.qrImageCreate(width, height, imageType);

    }

    private void qrImageCreate(int width, int height, int imageType) {

        // Convert BitMatrix to BufferedImage
        this.qrImage = new BufferedImage(width, height, imageType);

        for (int x = 0; x < width; x++) {

            for (int y = 0; y < height; y++) {

                qrImage.setRGB(x, y, this.bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);

            }

        }

    }

    public void save(String pathname, String formatName) throws IOException {
        ImageIO.write(qrImage, formatName, new File(pathname));
    }

    public BufferedImage qrImage() {
        return this.qrImage;
    }

    private static class BitMatrixBuilder implements Builder<BitMatrix> {

        private final BitMatrix bitMatrix;

        public BitMatrixBuilder(String data, BarcodeFormat format, int width, int height) throws WriterException {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            this.bitMatrix = qrCodeWriter.encode(data, format, width, height);
        }

        @Override
        public BitMatrix build() {
            return this.bitMatrix;
        }

    }

}