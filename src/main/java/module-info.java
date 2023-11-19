module com.coderscratchpad.javafxtutorial {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.desktop;
    requires com.google.zxing;
    requires javafx.swing;
    requires javafx.web;
    requires java.prefs;
    requires de.jensd.fx.glyphs.fontawesome;
    requires org.controlsfx.controls;

    exports com.coderscratchpad.javafxtutorial;
    exports com.coderscratchpad.javafxtutorial.button;
    exports com.coderscratchpad.javafxtutorial.datepicker;
    exports com.coderscratchpad.javafxtutorial.text;
    exports com.coderscratchpad.javafxtutorial.effects.lighting.distant;
    exports com.coderscratchpad.javafxtutorial.effects.lighting.point;
    exports com.coderscratchpad.javafxtutorial.effects.lighting.spot;
    exports com.coderscratchpad.javafxtutorial.menus;
    exports com.coderscratchpad.javafxtutorial.tableview;
    exports com.coderscratchpad.javafxtutorial.paginatedtables;
    exports com.coderscratchpad.javafxtutorial.dialogs;
    exports com.coderscratchpad.javafxtutorial.customdialogs;
    exports com.coderscratchpad.javafxtutorial.textfield;
    exports com.coderscratchpad.javafxtutorial.radiobutton;
    exports com.coderscratchpad.javafxtutorial.combobox;
    exports com.coderscratchpad.javafxtutorial.listview;
    exports com.coderscratchpad.javafxtutorial.toolbar;
    exports com.coderscratchpad.javafxtutorial.treeview;
    exports com.coderscratchpad.javafxtutorial.scrollpane;
    exports com.coderscratchpad.javafxtutorial.splitpane;
    exports com.coderscratchpad.javafxtutorial.tabpane;
    exports com.coderscratchpad.javafxtutorial.imageview;
    exports com.coderscratchpad.javafxtutorial.tooltip;
    exports com.coderscratchpad.javafxtutorial.filechooser;
    exports com.coderscratchpad.javafxtutorial.directorychooser;
    exports com.coderscratchpad.javafxtutorial.anchorpane;
    exports com.coderscratchpad.javafxtutorial.hbox;
    exports com.coderscratchpad.javafxtutorial.vbox;
    exports com.coderscratchpad.javafxtutorial.stackpane;
    exports com.coderscratchpad.javafxtutorial.borderpane;
    exports com.coderscratchpad.javafxtutorial.flowpane;
    exports com.coderscratchpad.javafxtutorial.gridpane;
    exports com.coderscratchpad.javafxtutorial.textarea;
    exports com.coderscratchpad.javafxtutorial.htmleditor;
    exports com.coderscratchpad.javafxtutorial.accordion;
    exports com.coderscratchpad.javafxtutorial.tilepane;
    exports com.coderscratchpad.javafxtutorial.treetableview;
    exports com.coderscratchpad.javafxtutorial.fontawesomeicons;
    exports com.coderscratchpad.javafxtutorial.controlsfx;
    exports com.coderscratchpad.javafxtutorial.controlsfx.popover;
    exports com.coderscratchpad.javafxtutorial.controlsfx.ratingcontrol;
    exports com.coderscratchpad.javafxtutorial.controlsfx.toggleswitch;
    exports com.coderscratchpad.javafxtutorial.controlsfx.notifications;
    exports com.coderscratchpad.javafxtutorial.controlsfx.statusbar;
    exports com.coderscratchpad.javafxtutorial.controlsfx.worldmapview;
    exports com.coderscratchpad.javafxtutorial.controlsfx.rangeslider;
    exports com.coderscratchpad.javafxtutorial.controlsfx.plusminusslider;
    exports com.coderscratchpad.javafxtutorial.controlsfx.autocompletion;
    exports com.coderscratchpad.javafxtutorial.controlsfx.clearabletextfield;

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