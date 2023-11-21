package com.coderscratchpad.javafxtutorial.mediaplayer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
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

