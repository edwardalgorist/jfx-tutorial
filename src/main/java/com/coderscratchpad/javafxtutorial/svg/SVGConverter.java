package com.coderscratchpad.javafxtutorial.svg;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.ImageTranscoder;

import java.awt.image.BufferedImage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/displaying-svg-images-in-javafx/">coderscratchpad.com</a>
 */
public class SVGConverter extends ImageTranscoder {

    private BufferedImage image;

    public SVGConverter(String svgFilePath) throws TranscoderException {

        // Initialize the SVGConverter with the path to the SVG file
        TranscoderInput input = new TranscoderInput(svgFilePath);
        this.transcode(input, null);
    }

    public BufferedImage toBufferedImage() {
        return this.image;
    }

    public Image toImage() {

        // Convert the BufferedImage to a JavaFX Image
        return SwingFXUtils.toFXImage(this.toBufferedImage(), null);
    }

    @Override
    public BufferedImage createImage(int width, int height) {

        // Create a new BufferedImage with the specified width and height
        return new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    @Override
    public void writeImage(BufferedImage img, TranscoderOutput output) throws TranscoderException {

        // Store the converted image in the 'image' variable
        image = img;
    }
}
