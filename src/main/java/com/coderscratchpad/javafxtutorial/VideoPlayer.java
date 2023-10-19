package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import java.util.Objects;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/creating-a-video-player-with-javafx/">coderscratchpad.com</a>
 */
public class VideoPlayer extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    @Override
    public void start(Stage stage) {

        // Create the main layout as a BorderPane
        BorderPane layoutManager = new BorderPane();
        Scene scene = new Scene(layoutManager, WIDTH, HEIGHT);

        // Create a MediaFileView for the video
        MediaFileView mediaView = new MediaFileView("video.mp4");

        // Add the media view to the center of the BorderPane
        layoutManager.setCenter(mediaView);

        // Add media player controls to the bottom of the BorderPane
        layoutManager.setBottom(new MediaPlayerControls(mediaView.getMediaPlayer()));

        // Set the stage title and scene
        stage.setTitle("Creating a Video Player with JavaFX");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    private static class MediaFileView extends MediaView {

        public MediaFileView(String path) {
            super();
            this.init(path, false, 0.2);
        }

        public MediaFileView(String path, boolean autoplay, double volume) {
            super();
            this.init(path, autoplay, volume);
        }

        private void init(String path, boolean autoplay, double volume) {

            // Get the video path as an external form URL
            String videoPath = Objects.requireNonNull(this.getClass().getClassLoader().getResource(path)).toExternalForm();

            // Create a Media instance with the video URL
            Media media = new Media(videoPath);

            // Create a MediaPlayer and set autoplay and volume
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setAutoPlay(autoplay);
            mediaPlayer.setVolume(volume);

            // Set the MediaPlayer for this MediaView
            setMediaPlayer(mediaPlayer);
        }
    }
}

class MediaPlayerControls extends HBox {

    private final MediaPlayer mediaPlayer;

    public MediaPlayerControls(MediaPlayer mediaPlayer) {

        super(2);
        this.mediaPlayer = mediaPlayer;

        setAlignment(Pos.CENTER);
        setPadding(new Insets(8));

        // Add media player control buttons
        getChildren().addAll(
                new MediaPlayerButton("PLAY", MediaPlayerControls.this::play),
                new MediaPlayerButton("PAUSE", MediaPlayerControls.this::pause),
                new MediaPlayerButton("STOP", MediaPlayerControls.this::stop)
        );
    }

    protected void play(ActionEvent actionEvent) {
        this.mediaPlayer.play();
    }

    protected void pause(ActionEvent actionEvent) {
        this.mediaPlayer.pause();
    }

    protected void stop(ActionEvent actionEvent) {
        this.mediaPlayer.stop();
    }

    private static class MediaPlayerButton extends Button {

        public MediaPlayerButton(String label, EventHandler<ActionEvent> handler) {
            super(label);

            // Set the button's action event handler
            setOnAction(handler);
        }
    }
}