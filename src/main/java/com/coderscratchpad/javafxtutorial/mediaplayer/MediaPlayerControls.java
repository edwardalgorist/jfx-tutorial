package com.coderscratchpad.javafxtutorial.mediaplayer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.media.MediaPlayer;

public class MediaPlayerControls extends HBox {

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
