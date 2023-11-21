package com.coderscratchpad.javafxtutorial.svg;

import javafx.embed.swing.SwingNode;
import org.apache.batik.swing.JSVGCanvas;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/displaying-svg-images-in-javafx/">coderscratchpad.com</a>
 */
public class SVGViewer extends SwingNode {

    public SVGViewer(String svgFilePath) {

        // Create a new JSVGCanvas
        JSVGCanvas svgCanvas = new JSVGCanvas();

        // Load an SVG document from the given file path
        svgCanvas.setURI(svgFilePath);

        // Wrap the JSVGCanvas in a SwingNode to integrate it into JavaFX
        this.setContent(svgCanvas);

    }

}
