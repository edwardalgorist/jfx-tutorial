package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.print.PageLayout;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-printing-generating-and-printing-reports-and-documents/">coderscratchpad.com</a>
 */
public class BasicDocumentPrinting extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private final BorderPane parent = new BorderPane();
    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        this.setupStage(stage);
    }

    @Override
    public void init() throws Exception {
        super.init();
        this.buildUI();
    }

    private void setupStage(Stage stage) throws IOException {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("JavaFX Printing: Generating and Printing Reports and Documents");

        // Sets the stage scene
        stage.setScene(scene);

        // Centers stage on screen
        stage.centerOnScreen();

        // Show stage on screen
        stage.show();

    }

    private void buildUI() {

        Button print = new Button("Print Report");
        print.setOnAction(this::printReport);

        this.parent.setCenter(print);

    }

    private void printReport(ActionEvent actionEvent) {

        Printer printer = Printer.getDefaultPrinter();

        PageLayout pageLayout = printer.getDefaultPageLayout();

        VBox report = createSampleReport(pageLayout.getPrintableWidth());

        PrinterJob printerJob = PrinterJob.createPrinterJob();

        if (printerJob != null && printerJob.showPrintDialog(this.stage)) {

            boolean success = printerJob.printPage(report);

            if (success) {

                printerJob.endJob();

            }

        }

    }

    private VBox createSampleReport(double wrappingWidth) {

        VBox report= new VBox(20);

        Label header1 = this.createHeader("What is Lorem Ipsum?");
        Label header2 = this.createHeader("Where does it come from?");
        Label header3 = this.createHeader("Why do we use it?");

        Text paragraph1 = this.createParagraph("Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                "when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                "It has survived not only five centuries, but also the leap into electronic typesetting, " +
                "remaining essentially unchanged. It was popularised in the 1960s with the release of " +
                "Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing " +
                "software like Aldus PageMaker including versions of Lorem Ipsum.", wrappingWidth);

        Text paragraph2 = this.createParagraph("Contrary to popular belief, Lorem Ipsum is not simply random text. " +
                "It has roots in a piece of classical Latin literature from 45 BC, making it over " +
                "2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, " +
                "looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, " +
                "and going through the cites of the word in classical literature, discovered the " +
                "undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" " +
                "(The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of " +
                "ethics, very popular during the Renaissance. The first line of Lorem Ipsum, " +
                "\"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.", wrappingWidth);

        Text paragraph3 = this.createParagraph("The standard chunk of Lorem Ipsum used since the 1500s is reproduced below " +
                "for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" " +
                "by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 " +
                "translation by H. Rackham.", wrappingWidth);

        Text paragraph4 = this.createParagraph("It is a long established fact that a reader will be distracted by the readable content of a " +
                "page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as " +
                "opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page " +
                "editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their " +
                "infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).", wrappingWidth);

        report.getChildren().addAll(
                header1, paragraph1,
                header2, paragraph2, paragraph3,
                header3, paragraph4
        );

        return report;

    }

    private Label createHeader(String title) {
        Label header = new Label(title);
        header.setStyle("-fx-font-weight: bold");
        return header;
    }

    private Text createParagraph(String text, double wrappingWidth) {

        Text paragraph= new Text();

        paragraph.setText(text);

        // Sets the wrapping width
        paragraph.wrappingWidthProperty().set(wrappingWidth);

        return paragraph;

    }

}