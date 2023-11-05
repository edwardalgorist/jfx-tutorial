module com.coderscratchpad.javafxtutorial {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.desktop;
    requires com.google.zxing;
    requires javafx.swing;
    requires javafx.web;
    requires java.prefs;

    exports com.coderscratchpad.javafxtutorial;
    exports com.coderscratchpad.javafxtutorial.button;
    exports com.coderscratchpad.javafxtutorial.datepicker;
    exports com.coderscratchpad.javafxtutorial.text;
    exports com.coderscratchpad.javafxtutorial.effects.lighting.distant;
    exports com.coderscratchpad.javafxtutorial.effects.lighting.point;
    exports com.coderscratchpad.javafxtutorial.effects.lighting.spot;

    opens com.coderscratchpad.javafxtutorial to javafx.fxml;
    opens com.coderscratchpad.javafxtutorial.button to javafx.fxml;
    opens com.coderscratchpad.javafxtutorial.datepicker to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial.label;
    opens com.coderscratchpad.javafxtutorial.label to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial.checkbox;
    opens com.coderscratchpad.javafxtutorial.checkbox to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial.images;
    opens com.coderscratchpad.javafxtutorial.images to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial.webview;
    opens com.coderscratchpad.javafxtutorial.webview to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial.charts;
    opens com.coderscratchpad.javafxtutorial.charts to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial.progressbar;
    opens com.coderscratchpad.javafxtutorial.progressbar to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial.progressindicator;
    opens com.coderscratchpad.javafxtutorial.progressindicator to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial.effects;
    opens com.coderscratchpad.javafxtutorial.effects to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial.effects.coloradjust;
    opens com.coderscratchpad.javafxtutorial.effects.coloradjust to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial.effects.boxblur;
    opens com.coderscratchpad.javafxtutorial.effects.boxblur to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial.effects.colorinput;
    opens com.coderscratchpad.javafxtutorial.effects.colorinput to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial.effects.dropshadow;
    opens com.coderscratchpad.javafxtutorial.effects.dropshadow to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial.effects.innershadow;
    opens com.coderscratchpad.javafxtutorial.effects.innershadow to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial.effects.reflection;
    opens com.coderscratchpad.javafxtutorial.effects.reflection to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial.effects.perspectivetransform;
    opens com.coderscratchpad.javafxtutorial.effects.perspectivetransform to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial.effects.sepiatone;
    opens com.coderscratchpad.javafxtutorial.effects.sepiatone to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial.effects.gausian;
    opens com.coderscratchpad.javafxtutorial.effects.gausian to javafx.fxml;
    exports com.coderscratchpad.javafxtutorial.effects.shadow;
    opens com.coderscratchpad.javafxtutorial.effects.shadow to javafx.fxml;

}